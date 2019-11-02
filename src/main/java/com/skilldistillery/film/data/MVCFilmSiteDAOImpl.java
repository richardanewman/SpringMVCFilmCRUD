package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.FilmCategory;
import com.skilldistillery.film.entities.Language;

@Component
public class MVCFilmSiteDAOImpl implements MVCFilmSiteDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String USER = "student";
	private static final String PASSWORD = "student";

	static {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("42");
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from film where film.id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				Integer releaseYear = rs.getInt("release_year");
				String rating = rs.getString("rating");
				String desc = rs.getString("description");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String features = rs.getString("special_features");
				FilmCategory category = getCategory(id);
				List<Actor> actors = findActorsByFilmId(filmId);
				film = new Film(id, title, desc, releaseYear, langId, rentDur, length, repCost, rating, features, category, actors);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select id, first_name, last_name from actor where id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, actorId);
			ResultSet actorResult = pst.executeQuery();
			if (actorResult.next()) {
				actor = new Actor();
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from actor join film_actor on actor.id = film_actor.actor_id where film_actor.film_id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, filmId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);	
			}
			rs.close();
			pst.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
		
	}

	@Override
	public List<Film> findFilmBySearch(String keyword) {
		Film film = null;
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select * from film where description like ? or title like ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + keyword + "%");
			pst.setString(2, "%" + keyword + "%");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				int langId = rs.getInt("language_id");
				int rentDur = rs.getInt("rental_duration");
				int length = rs.getInt("length");
				double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				FilmCategory category = getCategory(id);
				List<Actor> actors = findActorsByFilmId(id);
				film = new Film(id, title, description, releaseYear, langId, rentDur, length, repCost, rating, features, category, actors);
				films.add(film);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Language getLanguage(int langId) {
		Language lang = null;

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select name from language where language.id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, langId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				lang = new Language(name);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lang;
	}

	@Override
	public FilmCategory getCategory(int categoryId) {
		FilmCategory cat = null;

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "select category.name from category join film_category on film_category.category_id = category.id where film_category.film_id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, categoryId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				cat = new FilmCategory(name);
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}
	@Override
	public Film createFilm(Film film) {
		Film newFilm = film;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "insert into film(title, description, release_year, language_id, rental_duration, length, replacement_cost, rating, special_features) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn.setAutoCommit(false);
			PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, newFilm.getTitle());
			pst.setString(2, newFilm.getDescription());
			pst.setInt(3, newFilm.getReleaseYear());
			pst.setInt(4, newFilm.getLanguageId());
			pst.setInt(5, newFilm.getRentalDuration());
			pst.setInt(6, newFilm.getLength());
			pst.setDouble(7, newFilm.getReplacementCost());
			pst.setString(8, newFilm.getRating());
			pst.setString(9, newFilm.getSpecialFeatures());
			
			int updateCount = pst.executeUpdate();
		    if (updateCount == 1) {
		      ResultSet keys = pst.getGeneratedKeys();
		      if (keys.next()) {
		        int newFilmId = keys.getInt(1);
		        newFilm.setId(newFilmId);
		      }
		      keys.close();
		    }
		    conn.commit();
			pst.close();
			conn.close();
			
		} catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    throw new RuntimeException("Error inserting film " + film.getTitle());
		  }
		
		
		return film;
		
	}
	@Override
	public boolean deleteFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "delete from film where id = ?";
			conn.setAutoCommit(false);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, film.getId());
			
			int updateCount = pst.executeUpdate();
		    if (updateCount == 1) {
		     System.out.println("You successfully deleted " + updateCount + " record.");
		    }
		    conn.commit();
			pst.close();
			conn.close();
			
		} catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		        
		      }
		     
		    }
		    throw new RuntimeException("Error inserting film " + film.getTitle());
		  }
		
		return true;
		
		
		
	}

}



