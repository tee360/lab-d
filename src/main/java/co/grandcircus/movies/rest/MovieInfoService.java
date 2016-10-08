package co.grandcircus.movies.rest;

import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.movies.model.Movieinfo;
import co.grandcircus.movies.model.Weather;

@Service
public class MovieInfoService {
	
	private final static String GB_SUMMARY = "After losing their academic posts at a prestigious college, a team of parapsychologists creates a business exterminating ghouls, hobgoblins and supernatural pests -- and are soon hired by a cellist to purge her digs of a demon.";
;
	private final static String GB_RATING = "3.8";

	public Movieinfo getMovieRatingForGhostbusters() {
		return getCurrentMovieRating(GB_RATING);
	}
	
	public Movieinfo getCurrentMovieRating(String rating) {
		String url = "https://community-netflix-roulette.p.mashape.com/api.php";
		// Use HTTP GET with the above URL
		try (BufferedReader reader = HttpHelper.doGet(url)) { // try with resources will auto close the reader
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}
			
			// parse the HTTP response body to JSON
			JsonElement root = new JsonParser().parse(reader);
			// pick the "currentobservation" key from the root JSON object.
			JsonObject currentObservation = root.getAsJsonObject().get("currentobservation").getAsJsonObject();

			Movieinfo movieinfo = new Movieinfo();
			// pick the "Rating" key from the currentobservation object
			movieinfo.setRating(currentObservation.get("Rating").getAsString());
			// pick the "Poster" key from the currentobservation object
			movieinfo.setImage("http://netflixroulette.net/api/posters/541018.jpg"
					+ currentObservation.get("Poster").getAsString());

			return movieinfo;
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}


}