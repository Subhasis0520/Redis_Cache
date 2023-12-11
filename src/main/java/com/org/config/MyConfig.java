package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.org.binding.Country;

@Configuration
public class MyConfig {

	@Bean
	public JedisConnectionFactory getCon() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		// jedis configuration file
		return jcf;
	}
	
	@Bean
	public RedisTemplate<String, Country> getRedis(){
		RedisTemplate<String, Country> rt = new RedisTemplate<>();
		rt.setConnectionFactory(getCon());
		
		return rt;
	}
}
