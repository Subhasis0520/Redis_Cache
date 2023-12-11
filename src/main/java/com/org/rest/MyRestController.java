package com.org.rest;

import java.util.Collection;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.binding.Country;

@RestController
public class MyRestController {

	HashOperations<String, Integer, Country> opsForHash = null;
	
//	@Autowired
	public MyRestController(RedisTemplate<String, Country> rt) {
		 this.opsForHash = rt.opsForHash();
	}
	
	@PostMapping("/country")
	public String saveCountry(@RequestBody Country country) {
		opsForHash.put("COUNTRIES", country.getId(), country);
		
		return "Country Added";
	}
	
	@GetMapping("/country")
	public Collection<Country> getCountry() {
		Map<Integer, Country> entries = opsForHash.entries("COUNTRIES");
		Collection<Country> values = entries.values();
		
		return values;
	}
}
