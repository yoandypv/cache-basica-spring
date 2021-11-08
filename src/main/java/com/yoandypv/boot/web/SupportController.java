package com.yoandypv.boot.web;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoandypv.boot.service.Person;

@RestController
@RequestMapping("/support")
public class SupportController {
	
	private final CacheManager cacheManager;
	
	public SupportController(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	@GetMapping
	public void playingWithCache() {
	  ConcurrentHashMap<?, ?> cache = (ConcurrentHashMap<?, ?>) this.cacheManager.getCache("personas").getNativeCache();
	  
	  // Obteniendo los elementos de la cache
	  cache.forEach((key, value)-> {
		  System.out.println("Key is " + key + " and value " + value.toString());
	  });
	  
	  // Buscando un objeto dentro de la cache (Requiere ==)
	  Person p1 = new Person(1, "Pepe");
	  boolean result = cache.containsValue(p1);
	  System.out.println("Value " + p1.toString() + " was founded?:" + result);
	  
	 
	}
	

}
