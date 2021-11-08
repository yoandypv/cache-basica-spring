package com.yoandypv.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringCacheBasicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheBasicaApplication.class, args);
	}

}
