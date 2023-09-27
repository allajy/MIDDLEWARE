package com.bxc.assemble.dubbo3.comp.anno.consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;

public class AnnotationConsumerApplication {



    public static void main(String[] args) {
        System.setProperty("server.port","8802");
        System.setProperty("user.dir",".");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConsumerBootstrap.class);
        AnnotationProcessAction annotationProcessAction = context.getBean("annotationAction",AnnotationProcessAction.class);
        IntStream.range(0,10).forEach(param->{
            annotationProcessAction.multriVersionProcess("test");
        });
        context.start();
    }

}
