package com.yf.config;
import com.yf.factory.RedisListenerContainerFactory;
import com.yf.factory.SimpleRedisListenerContainerFactory;
import com.yf.processor.RedisListenerAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
public class RedisMqFactoryConfig {

    @Resource
    private RedisMqProperties redisMqProperties;

    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    @Bean(name = "RedisListenerAnnotationBeanPostProcessor")
    public RedisListenerAnnotationBeanPostProcessor rabbitListenerAnnotationProcessor() {
        return new RedisListenerAnnotationBeanPostProcessor();
    }

	@Bean
	public RedisListenerContainerFactory<?> redisListenerContainerFactory() {
		SimpleRedisListenerContainerFactory factory = new SimpleRedisListenerContainerFactory();
		factory.setRetryTimes(redisMqProperties.getRetryTimes());
		factory.setMaxConsumer(redisMqProperties.getMaxConsumer());
		return factory;
	}

	@Bean(name = "MQ")
	public RedisTemplate<String, String> redisMqTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		StringRedisSerializer serializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		redisTemplate.setHashKeySerializer(serializer);
		redisTemplate.setHashValueSerializer(serializer);

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
