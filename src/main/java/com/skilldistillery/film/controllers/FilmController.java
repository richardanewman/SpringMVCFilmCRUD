package com.skilldistillery.film.controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.MVCFilmSiteDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	private int filmIdTemp = 0;
	private int actorIdTemp = 0;
	private Film filmForDisplay = null;
	private Actor actorForDisplay = null;

	@Autowired
	private MVCFilmSiteDAO filmDAO;

	public void setFilmDAo(MVCFilmSiteDAO filmdao) {
		this.filmDAO = filmdao;
	}

	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET, params = "id")
	public ModelAndView findFilmByID(@RequestParam("id") String filmId) {
		ModelAndView mv = new ModelAndView();

		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(filmId);

		if (m.find()) {

			int id = Integer.parseInt(filmId);

			if (id != 0) {
				Film film = filmDAO.findFilmById(id);

				if (film != null) {
					filmForDisplay = film;
					mv.addObject("film", filmDAO.findFilmById(id).displayFilm());
					mv.setViewName("WEB-INF/result.jsp");
				}

				else {
					mv.addObject("film", "Invalid Film, try Again!");
					mv.setViewName("WEB-INF/filmByID.jsp");
				}
			}

		}

		else {
			mv.addObject("film", "Invalid Film, try Again!");
			mv.setViewName("WEB-INF/filmByID.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "findActorById.do", method = RequestMethod.GET, params = "id")
	public ModelAndView findActorByID(@RequestParam("id") String actorId) {
		ModelAndView mv = new ModelAndView();

		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(actorId);

		if (m.find()) {

			int id = Integer.parseInt(actorId);

			if (id != 0) {
				Actor actor = filmDAO.findActorById(id);

				if (actor != null) {
					actorForDisplay = actor;
					mv.addObject("actor", actor);
					mv.setViewName("WEB-INF/result.jsp");
				}

				else {
					mv.addObject("actor", "Invalid Film, try Again!");
					mv.setViewName("WEB-INF/actorByID.jsp");
				}
			} else {
				mv.addObject("actor", "Invalid Film, try Again!");
				mv.setViewName("WEB-INF/actorByID.jsp");
			}

		}

		else {
			mv.addObject("actor", "Invalid Film, try Again!");
			mv.setViewName("WEB-INF/actorByID.jsp");
		}

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

	@RequestMapping(path = "addFilmForm.do", method = RequestMethod.GET)
	private ModelAndView getForm(@Valid Actor film) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/addActorForm.jsp");
		return mv;

	}

	@RequestMapping(path = "createActor.do", method = RequestMethod.POST)
	public ModelAndView createActor(@Valid Actor actor) {
		ModelAndView mv = new ModelAndView();
		Actor newActor = filmDAO.createActor(actor);
		mv.addObject("newActor", newActor);
		mv.setViewName("WEB-INF/newActor.jsp");
		return mv;

	}

	@RequestMapping(path = "addActorForm.do", method = RequestMethod.GET)
	private ModelAndView getActorForm(@Valid Actor actor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/addActorForm.jsp");
		return mv;

	}

	@RequestMapping(path = "searchFilm.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView searchFilm(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmBySearch(keyword);
		if (films.isEmpty()) {
			mv.addObject("result", "No matching films found!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

		else {
			mv.addObject("result", "Here is a list of films we found matching your keyword:<br>");
			mv.addObject("films", films);
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST, params = "id")
	private ModelAndView deleteFilm(@RequestParam("id") String filmId) {
		ModelAndView mv = new ModelAndView();

		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(filmId);

		if (m.find()) {

			int id = Integer.parseInt(filmId);
			Film film = filmDAO.findFilmById(id);

			if (film != null) {

				if (filmDAO.deleteFilm(film)) {
					mv.addObject("result", "Movie was deleted!");
					mv.setViewName("/WEB-INF/status.jsp");
				}

				else {
					mv.addObject("result", "Movie was not deleted!");
					mv.setViewName("/WEB-INF/result.jsp");
				}
			} else {
				mv.addObject("result", "Movie was not deleted!");
				mv.setViewName("/WEB-INF/result.jsp");
			}
		}

		else {
			mv.addObject("film", filmForDisplay.displayFilm());
			mv.addObject("result", "Invalid Film!");
			mv.setViewName("/WEB-INF/result.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "deleteActor.do", method = RequestMethod.POST, params = "id")
	private ModelAndView deleteActor(@RequestParam("id") String actorId) {
		ModelAndView mv = new ModelAndView();

		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(actorId);

		if (m.find()) {

			int id = Integer.parseInt(actorId);
			Actor actor = filmDAO.findActorById(id);

			if (actor != null) {

				if (filmDAO.deleteActor(actor)) {
					mv.addObject("result", "Actor was deleted!");
					mv.setViewName("/WEB-INF/status.jsp");
				}

				else {
					mv.addObject("result", "Actor was not deleted!");
					mv.setViewName("/WEB-INF/result.jsp");
				}
			}
			
			else {
				mv.addObject("result", "Actor was not deleted!");
				mv.setViewName("/WEB-INF/result.jsp");
			}

		}

		else {
			mv.addObject("actor", actorForDisplay);
			mv.addObject("result", "Invalid Actor!");
			mv.setViewName("/WEB-INF/result.jsp");
		}

		return mv;
	}
	
	

	@RequestMapping(path = "editFilmForm.do", method = RequestMethod.GET, params = "id")
	private ModelAndView getEditForm(@RequestParam("id") String filmId) {
		ModelAndView mv = new ModelAndView();
		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(filmId);

		if (m.find()) {

			int id = Integer.parseInt(filmId);

			filmIdTemp = id;
			Film film = filmDAO.findFilmById(id);
			mv.addObject("film", film);
			mv.setViewName("/WEB-INF/editFilm.jsp");
		}

		else {
			mv.addObject("film", filmForDisplay.displayFilm());
			mv.addObject("result", "Invalid Film!");
			mv.setViewName("/WEB-INF/result.jsp");
		}

		return mv;

	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	private ModelAndView updateFilm(@Valid Film film) {
		ModelAndView mv = new ModelAndView();
		if (filmDAO.updateFilm(film, filmIdTemp)) {
			mv.addObject("result", "Film was updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

		else {
			mv.addObject("result", "Film was not updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}

	}

	@RequestMapping(path = "index.do", method = RequestMethod.GET)
	private ModelAndView getIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.html");
		return mv;

	}
	
	
	@RequestMapping(path = "editActorForm.do", method = RequestMethod.GET, params = "id")
	private ModelAndView getEditActorForm(@RequestParam("id") String actorId) {
		ModelAndView mv = new ModelAndView();
		Pattern p = Pattern.compile("^[0-9]");
		Matcher m = p.matcher(actorId);
		
		if (m.find()) {
			
			int id = Integer.parseInt(actorId);
			
			actorIdTemp = id;
			Actor actor = filmDAO.findActorById(id);
			mv.addObject("actor", actor);
			mv.setViewName("/WEB-INF/editActor.jsp");
		}
		
		else {
			mv.addObject("actor", actorForDisplay);
			mv.addObject("result", "Invalid Actor!");
			mv.setViewName("/WEB-INF/result.jsp");
		}
		
		return mv;
		
	}
	
	@RequestMapping(path = "editActor.do", method = RequestMethod.POST)
	private ModelAndView updateActor(@Valid Actor actor) {
		
		ModelAndView mv = new ModelAndView();
		
		if (filmDAO.updateActor(actor, actorIdTemp)) {
			mv.addObject("result", "Actor was updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
		else {
			mv.addObject("result", "Actor was not updated!");
			mv.setViewName("/WEB-INF/status.jsp");
			return mv;
		}
		
	}
	
	

}
