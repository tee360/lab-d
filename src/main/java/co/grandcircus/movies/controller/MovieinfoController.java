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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.movies.dao.MovieDao;
import co.grandcircus.movies.model.Movie;
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
	@Autowired
	private MovieDao movieDao;

	/**
	 * Retrieves movie info from Netflix API for "Flight"
	 */
	@RequestMapping("/movieinfo") 	// will work for GET or POST
	public String movieinfo(Model model, @RequestParam(value="movieName")String movieName) {
		// add the 'movieinfo' variable to the JSP
		model.addAttribute("movieinfo", movieInfo.getSelectedMovieInfo(movieName));

		logger.info("/movieinfo -> movieinfo.jsp");

		// select to use the movieinfo.jsp view
		return "movieinfo";
	}

	/**
	 * Retrieves movie info from Netflix API for movie selected from list
	 */
//	@RequestMapping(value = "/movieinfo", method = RequestMethod.GET)
//	public String additionalMovieInfo(@PathVariable int id, Movie movie, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("movie", movieDao.getMovie(id));
//		model.addAttribute("movieinfo", id);
//	
//		switch (id) {
//		case 3:
//			movie.setTitle("Flight");
//			break;
//		case 4:
//			movie.setTitle("Friday The 13th");
//			break;
//		case 5:
//			movie.setTitle("Ghostbusters");
//			break;
//		case 6:
//			movie.setTitle("Pulp Fiction");
//			break;
//		case 7:
//			movie.setTitle("Titanic");
//			break;
//		case 8:
//			movie.setTitle("Boomerang");
//			break;
//		default:
//			System.out.println("Invalid Selection");
//		}
//
//		// add the 'movieinfo' variable to the JSP
//		model.addAttribute("movieinfo", movieInfo.getSelectedMovieInfo(movie.getTitle()));
//
//		logger.info("/movieinfo -> movieinfo.jsp");
//
//		// select to use the movieinfo.jsp view
//		return "movieinfo";
//	}

}