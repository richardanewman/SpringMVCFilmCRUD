package com.skilldistillery.film.data;

import java.util.HashMap;
import java.util.Map;
import com.skilldistillery.film.entities.*;
public class AuthenticationDAOImpl implements AuthenticationDAO {
	private Map<String, User> users = new HashMap<>();
	
	public AuthenticationDAOImpl () {
		this.users.put("admin@admin.com", 
				new User("admin@admin.com", "admin", "admin", "password", 22));
	}

	@Override
	public User create(User user) {
		if (isEmailUnique(user.getEmail())) {
			users.put(user.getEmail(), user);
			return user;
		}
		return null;
	}

	@Override
	public boolean isEmailUnique(String email) {
		// TODO: Check to see if the provided email exists as a key in the users HashMap
	  return !users.containsKey(email);
	}

	@Override
	public User getUserByEmail(String email) {
		if (users.containsKey(email)) {
			return users.get(email);
		}
		return null;
	}

	@Override
	public boolean isValidUser(User u) {
		if (getUserByEmail(u.getEmail()) == null) {
			return false;
		}
		if (users.get(u.getEmail())
				.getPassword()
				.equals(u.getPassword())){
			return true;
		}
		return false;
	}

	
}
