package com.mariko.calculator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

/** Cache config.
*/

@Configuration
@EnableCaching
public class CacheConfig {

    private static final String redisHost = "redis";

    private static final Integer redisPort = 6379;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
        return new JedisConnectionFactory(configuration);
    }

        @Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();

        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }


    @Bean
    public CacheManager initRedisCacheManager(RedisConnectionFactory factory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder.fromConnectionFactory(factory);
        return builder.build();
    }

}
