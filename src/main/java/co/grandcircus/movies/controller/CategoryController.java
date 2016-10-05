/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.grandcircus.movies.dao.MovieDao;

/**
 * Handles requests for pages related to categories
 */
@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private MovieDao movieDao;
	
	/**
	 * List all categories
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listMovies(Model model) {
		model.addAttribute("categories", movieDao.getAllCategories());
		
		logger.info("/categories -> category-list.jsp");
		return "category-list";
	}
	
}
