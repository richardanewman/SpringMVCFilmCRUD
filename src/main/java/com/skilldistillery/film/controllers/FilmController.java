package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.MVCFilmSiteDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private MVCFilmSiteDAO filmDAO;

	public void setFilmDAo(MVCFilmSiteDAO filmdao) {
		this.filmDAO = filmdao;
	}

	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET, params = "id")
	public ModelAndView findFilmByID(@RequestParam("id") int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDAO.findFilmById(filmId));
		mv.setViewName("WEB-INF/result.jsp");
		return mv;

	}
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST, params = {"title", "description", "release_year", "language_id", "rental_duration", "rental_rate", "length", "replacement_cost", "rating", "special_features"})
	public ModelAndView createFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("newfilm", filmDAO.createFilm(film));
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
		
	}
	
	

}
