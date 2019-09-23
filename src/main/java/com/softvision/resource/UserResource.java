/**
 * 
 */
package com.softvision.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softvision.bean.HelloWorld;
import com.softvision.bean.User;
import com.softvision.exception.UserNotFoundException;
import com.softvision.service.UserService;

/**
 * @author ramesh.vasantula
 *
 */
@RestController
public class UserResource {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	UserService service;
	
	@GetMapping(path="/hello")
	public String hello() {
		return "Hello called";
	}
	
	@GetMapping(path="/hello-world")
	public HelloWorld helloWorld() {
		return new HelloWorld(1, "Ramesh");
	}
	
	@GetMapping(path="/hello-world/{name}")
	public HelloWorld pathVariable(@PathVariable String name) {
		return new HelloWorld(1, name);
	}
	
	@GetMapping(path="/users")
	public List<User> getUsers() {
		return service.findAll();
	}
	@GetMapping(path="/users/{id}")
	public Resource<User> findUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());

		resource.add(linkTo.withRel("all-users"));
//		linkTo(methodOn(this.getClass()).getUsers());
		return resource;
	}
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User updatedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
