package com.skilldistillery.film.data;

public interface AuthenticationDAO {
	public User create(User user);

	public boolean isEmailUnique(String email);

	public User getUserByEmail(String email);

	public boolean isValidUser(User u);

}