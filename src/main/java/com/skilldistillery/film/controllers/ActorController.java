package com.skilldistillery.film.controllers;

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

@Controller
public class ActorController {

	private int actorIdTemp = 0;
	private Actor actorForDisplay = null;

	@Autowired
	private MVCFilmSiteDAO filmDAO;

	public void setFilmDAo(MVCFilmSiteDAO filmdao) {
		this.filmDAO = filmdao;
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
					mv.setViewName("WEB-INF/actorResult.jsp");
				}

				else {
					mv.addObject("actor", "Invalid Actor, try Again!");
					mv.setViewName("WEB-INF/actorByID.jsp");
				}
			} 
			
			else {
				mv.addObject("actor", "Invalid Actor, try Again!");
				mv.setViewName("WEB-INF/actorByID.jsp");
			}

		}

		else {
			mv.addObject("actor", "Invalid Actor, try Again!");
			mv.setViewName("WEB-INF/actorByID.jsp");
		}

		return mv;
	}

	
	

	
	@RequestMapping(path = "addActorForm.do", method = RequestMethod.GET)
	private ModelAndView getForm(@Valid Actor actor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/addActor.jsp");
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
