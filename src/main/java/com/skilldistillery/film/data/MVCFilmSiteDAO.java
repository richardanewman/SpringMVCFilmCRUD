package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.FilmCategory;
import com.skilldistillery.film.entities.Language;

public interface MVCFilmSiteDAO {
	public Film findFilmById(int filmId);

	public Film createFilm(Film film);

	public boolean deleteFilm(Film film);

	public Language getLanguage(int langId);

	public FilmCategory getCategory(int categoryId);

	public List<Film> findFilmBySearch(String keyword);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public Actor createActor(Actor actor);
	
	public boolean updateFilm(Film film, int filmid);
	
	public boolean deleteActor(Actor actor);
	
	public boolean updateActor(Actor actor, int actorid);

}
