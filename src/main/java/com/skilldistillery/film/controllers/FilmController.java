package com.skilldistillery.film.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		Film newFilm = filmDAO.createFilm(film);
		mv.addObject("newfilm", newFilm);
		mv.setViewName("WEB-INF/newFilm.jsp");
		return mv;
		
	}   
	
	@RequestMapping(path="addFilm.do", method = RequestMethod.GET)
	private ModelAndView getForm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/addFilm.jsp");
		return mv;

	}
	@RequestMapping(path="index.do", method = RequestMethod.GET)
	private ModelAndView getIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		return mv;
		
	}
	
}
