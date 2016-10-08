package co.grandcircus.movies.model;

/**
 * Responsibility: Provide additional movie info fromNetflix API
 */
public class Movieinfo {

	/**
	 * URL of poster depicting movie
	 */
	private String image;
	/**
	 * Synopsis of movie
	 */
	private String summary;
	/**
	 * Obtain movie rating
	 */
	private String rating;
	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}	

}