package com.bxc.assemble.console.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfiguration {


//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
//                        //可选设置序列化key new GenericJackson2JsonRedisSerializer()
//                        (new Jackson2JsonRedisSerializer(Object.class))
//                        //序列化value
//                        .serializeValuesWith(RedisSerializationContext.SerializationPair.
//                                fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class))))
//                .build();
//    }
}
