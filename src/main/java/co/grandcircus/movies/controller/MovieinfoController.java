/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.movies.rest.MovieInfoService;
import co.grandcircus.movies.rest.WeatherService;

/**
 * Handles requests for the additional movie info page.
 */
@Controller
public class MovieinfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieinfoController.class);
	
	@Autowired
	private MovieInfoService movieInfo;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/movieinfo")
	public String movieinfo(Locale locale, Model model, String movieName) {
		// add the 'movieinfo' variable to the JSP
		model.addAttribute("movieinfo", movieInfo.getSelectedMovieInfo("Flight"));
		
		logger.info("/movieinfo -> movieinfo.jsp");
		
		// select to use the movieinfo.jsp view
		return "movieinfo";
	}
	
}