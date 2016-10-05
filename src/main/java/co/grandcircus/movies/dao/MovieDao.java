/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.dao;

import java.util.List;
import java.util.Set;

import co.grandcircus.movies.exception.NotFoundException;
import co.grandcircus.movies.model.Movie;

/**
 * Responsibility: To provide access to all the movies.
 */
public interface MovieDao {
	
	/**
	 * Get a list that contains every available movie.
	 */
	List<Movie> getAllMovies();
	
	/**
	 * Get a list that contains all the movies that are in a
	 * specified category.
	 * 
	 * @param cat The category
	 * @return list of matching movies. An empty list if no movies match.
	 */
	List<Movie> getMoviesByCategory(String cat);

	/**
	 * Get the movie with the specified id number.
	 * 
	 * @param id numeric ID of the movie
	 * @return the movie
	 * @throws NotFoundException if no such movie exists
	 */
	Movie getMovie(int id) throws NotFoundException;
	
	/**
	 * Add the given move to the list.
	 * 
	 * @param movie the movie to add
	 * @return the id of the new movie
	 */
	int addMovie(Movie movie);
	
	/**
	 * Update the specified movie
	 * 
	 * @param id numeric id identifies the movie to update
	 * @param movie the new values for the movie
	 * @throws NotFoundException if the movie does not exist
	 */
	void updateMovie(int id, Movie movie) throws NotFoundException;
	
	/**
	 * Delete the specified movie
	 * 
	 * @param id numeric id identifies the move to delete
	 * @throws NotFoundException if the movie does not exist
	 */
	void deleteMovie(int id) throws NotFoundException;
	
	/**
	 * Get all the categories of all the movies.
	 * Ex: "scifi", "comedy", etc.
	 */
	Set<String> getAllCategories();
	
	/**
	 * Return true if there are any movies with the given category or
	 * false if there are none.
	 * 
	 * @param category The category
	 */
	boolean isValidCategory(String category);
	

}
