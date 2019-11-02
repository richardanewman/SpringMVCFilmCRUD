package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.MVCFilmSiteDAO;

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
		mv.setViewName("WEB-INF/result.jsp");
		mv.addObject("film", filmDAO.findFilmById(filmId));
		return mv;

	}

}
