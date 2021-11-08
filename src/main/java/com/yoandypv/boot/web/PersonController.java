package com.yoandypv.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoandypv.boot.service.Person;
import com.yoandypv.boot.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@PostMapping
	public void save(@RequestBody Person person) {
	    this.personService.save(person);
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable int id) {
	    return this.personService.findById(id);
	}
	
	
}
