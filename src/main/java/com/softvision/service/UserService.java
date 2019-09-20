/**
 * 
 */
package com.softvision.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.softvision.bean.User;

/**
 * @author ramesh.vasantula
 *
 */
@Component
public class UserService {

	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1, "Adam" , new Date()));
		users.add(new User(2, "Ram" , new Date()));
		users.add(new User(3, "Eve" , new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()<=0) {
			user.setId(users.size());
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteUser(int id) {
		Iterator< User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
