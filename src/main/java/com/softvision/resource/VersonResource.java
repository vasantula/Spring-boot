package com.softvision.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.bean.version.Name;
import com.softvision.bean.version.Person1;
import com.softvision.bean.version.Person2;

@RestController
public class VersonResource {
	
	
	/**
	 * http://localhost:8080/person/param?version=1
	 * @return
	 */
	@GetMapping(value="person/param", params="version=1")
	public Person1 getParam1() {
		return new Person1("Ramesh Vasantula");
	}
	
	/**
	 * http://localhost:8080/person/param?version=2
	 * @return
	 */
	@GetMapping(value="person/param", params="version=2")
	public Person2 getParam2() {
		return new Person2(new Name("Ramesh", "Vasantula"));
	}
	
	/**
	 * Set Header KEY::X-API-VERSION   Value::1
	 * @return
	 */
	@GetMapping(value="person/header", headers="X-API-VERSION=1")
	public Person1 getHeader1() {
		return new Person1("Ramesh Vasantula");
	}

	/**
	 * Set Header KEY::X-API-VERSION   Value::2
	 * @return
	 */
	
	@GetMapping(value="person/header", headers="X-API-VERSION=2")
	public Person2 getHeader2() {
		return new Person2(new Name("Ramesh", "Vasantula"));
	}
	
	/**
	 * Set Header KEY::Accept   Value::application/vnd.company.app-v1+json
	 * @return
	 */
	
	@GetMapping(value="person/produces", produces="application/vnd.company.app-v1+json")
	public Person1 getProduces1() {
		return new Person1("Ramesh Vasantula");
	}
	
	/**
	 * Set Header KEY::Accept   Value::application/vnd.company.app-v2+json
	 * @return
	 */
	@GetMapping(value="person/produces", produces="application/vnd.company.app-v2+json")
	public Person2 getProduces2() {
		return new Person2(new Name("Ramesh", "Vasantula"));
	}
}
