package com.bxc.assemble.circuitbreaker.handle;

import com.bxc.assemble.circuitbreaker.annon.CircuitBreakerControl;
import com.bxc.assemble.circuitbreaker.CircuitBreakerMonitor;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.configure.CircuitBreakerConfigurationProperties;
import io.github.resilience4j.circuitbreaker.utils.CircuitBreakerUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class CircuitBreakerHandler{


    private final CircuitBreakerConfigurationProperties circuitBreakerProperties;


    private final CircuitBreakerRegistry circuitBreakerRegistry;


    public CircuitBreakerHandler(CircuitBreakerConfigurationProperties backendMonitorPropertiesRegistry,
                                CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreakerProperties = backendMonitorPropertiesRegistry;
        this.circuitBreakerRegistry = circuitBreakerRegistry;
    }

    /**
     * aop切面处理
     * @param circuitBreaker
     */
    @Pointcut(value = "@within(circuitBreaker) || @annotation(circuitBreaker)", argNames = "circuitBreaker")
    public void matchAnnotatedClassOrMethod(CircuitBreakerControl circuitBreaker) {
    }

    /**
     * 环绕处理
     * @param proceedingJoinPoint
     * @param backendMonitored
     * @return
     * @throws Throwable
     */
    @Around(value = "matchAnnotatedClassOrMethod(backendMonitored)",
            argNames = "proceedingJoinPoint, backendMonitored")
    public Object circuitBreakerAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, CircuitBreakerControl backendMonitored) throws Throwable {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        String methodName = method.getDeclaringClass().getName() + "#" + method.getName();
        if (backendMonitored == null) {
            backendMonitored = getBackendMonitoredAnnotation(proceedingJoinPoint);
        }
        String backend = backendMonitored.resourceName();
        io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = getOrCreateCircuitBreaker(methodName, backend);
        return handleJoinPoint(proceedingJoinPoint, circuitBreaker, methodName);
    }

    /**
     * 获取以及创建对应的操作
     * @param methodName
     * @param backend
     * @return
     */
    private io.github.resilience4j.circuitbreaker.CircuitBreaker getOrCreateCircuitBreaker(String methodName, String backend) {
        io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(backend,
                () -> circuitBreakerProperties.createCircuitBreakerConfig(backend));
        CircuitBreakerMonitor.addCircuitBreakerListener(circuitBreaker);
        if (log.isInfoEnabled()) {
            log.info("Created or retrieved circuit breaker '{}' with failure rate '{}' and wait interval'{}' for method: '{}'",
                    backend, circuitBreaker.getCircuitBreakerConfig().getFailureRateThreshold(),
                    circuitBreaker.getCircuitBreakerConfig().getWaitDurationInOpenState(), methodName);
        }
        return circuitBreaker;
    }

    /**
     * 获取后端方法的监控注解
     * @param proceedingJoinPoint
     * @return
     */
    private CircuitBreakerControl getBackendMonitoredAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
        if (log.isInfoEnabled()) {
            log.info("circuitBreaker parameter is null");
        }
        CircuitBreakerControl circuitBreaker = null;
        Class<?> targetClass = proceedingJoinPoint.getTarget().getClass();
        if (targetClass.isAnnotationPresent(CircuitBreakerControl.class)) {
            circuitBreaker = targetClass.getAnnotation(CircuitBreakerControl.class);
            if (circuitBreaker == null) {
                if (log.isInfoEnabled()) {
                    log.info("TargetClass has no annotation 'CircuitBreaker'");
                }
                circuitBreaker = targetClass.getDeclaredAnnotation(CircuitBreakerControl.class);
                if (circuitBreaker == null) {
                    if (log.isInfoEnabled()) {
                        log.info("TargetClass has no declared annotation 'CircuitBreaker'");
                    }
                }
            }
        }
        return circuitBreaker;
    }


    private Object handleJoinPoint(ProceedingJoinPoint proceedingJoinPoint,
                                   io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreaker, String methodName) throws Throwable {
        CircuitBreakerUtils.isCallPermitted(circuitBreaker);
        long start = System.nanoTime();
        try {
            Object returnValue = proceedingJoinPoint.proceed();

            long durationInNanos = System.nanoTime() - start;
            circuitBreaker.onSuccess(durationInNanos);
            return returnValue;
        } catch (Throwable throwable) {
            long durationInNanos = System.nanoTime() - start;
            circuitBreaker.onError(durationInNanos, throwable);
            if (log.isDebugEnabled()) {
                log.debug("Invocation of method '" + methodName + "' failed!", throwable);
            }
            throw throwable;
        }
    }



}
