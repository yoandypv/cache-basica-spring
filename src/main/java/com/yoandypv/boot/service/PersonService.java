package com.yoandypv.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements InitializingBean {

	private List<Person> repository;
	
	private Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		this.repository = new ArrayList<>();
	}
	
	public void save(Person person) {
		this.repository.add(person);
	}
	
	@Cacheable(cacheNames = "personas")
	public Person findById(int id) {
		Person p = this.repository
				.stream()
				.filter(it -> it.getId()== id)
				.findFirst()
				.orElseThrow(RuntimeException::new);
		logger.info("Item {} retrieved from list (not cached)", p.toString());
		return p;
	}
	
	

}
