/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.model;

/**
 * Responsibility: Hold information about any ONE movie.
 */
public class Movie {
	private Integer id;
	private String title;
	private String category;
	
	public Movie() {
	}

	// Constructor
	public Movie (String t, String c) {
		title = t;
		category = c;
	}
	
	
	
	public Movie(Integer id, String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// getter
	public String getTitle() {
		return title;
	}
	
	// getter
	public String getCategory() {
		return category;
	}
	
	// setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	// setter
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + "]";
	}
	
	

}
