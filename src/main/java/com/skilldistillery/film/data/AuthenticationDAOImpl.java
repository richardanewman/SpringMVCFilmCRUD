
//package com.skilldistillery.film.data;
//
//import com.skilldistillery.film.entities.User;
//
//public class AuthenticationDAOImpl implements AuthenticationDAO {
//	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
//	private static final String USER = "student";
//	private static final String PASSWORD = "student";
//	
//	
//	static {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("42");
//			e.printStackTrace();
//		}
//	}
//	
//	public AuthenticationDAOImpl () {
//		this.users.put("admin@admin.com", 
//				new User("admin@admin.com", "admin", "admin", "password", 22));
//	}
//
//	@Override
//	public User create(User user) {
//		if (isEmailUnique(user.getEmail())) {
//			users.put(user.getEmail(), user);
//			return user;
//		}
//		return null;
//	}
//
//	@Override
//	public boolean isEmailUnique(String email) {
//	  return !users.containsKey(email);
//	}
//
//	@Override
//	public User getUserByEmail(String email) {
//		if (users.containsKey(email)) {
//			return users.get(email);
//		}
//		return null;
//	}
//
//	@Override
//	public boolean isValidUser(User u) {
//		if (getUserByEmail(u.getEmail()) == null) {
//			return false;
//		}
//		if (users.get(u.getEmail())
//				.getPassword()
//				.equals(u.getPassword())){
//			return true;
//		}
//		return false;
//	}
//
//	
//}

