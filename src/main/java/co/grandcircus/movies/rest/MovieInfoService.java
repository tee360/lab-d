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
	private final static String GB_RATING = "3.8";

	public Movieinfo getMovieRatingForGhostbusters() {
		return getCurrentMovieRating(GB_RATING);
	}
	
	public Movieinfo getCurrentMovieRating(String title) {
		String url = "https://community-netflix-roulette.p.mashape.com/api.php?title=Ghostbusters";
		// Use HTTP GET with the above URL
		try (BufferedReader reader = HttpHelper.doGet(url)) { // try with resources will auto close the reader
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}
			
			// parse the HTTP response body to JSON
			JsonElement root = new JsonParser().parse(reader);
			// pick the "rating1" key from the root JSON object.
			JsonObject jObject = root.getAsJsonObject();

			Movieinfo movieinfo = new Movieinfo();
			// pick the "Rating" key from the JSON object
			movieinfo.setRating(jObject.get("rating").getAsString());
			// pick the "Poster" key from the JSON object
			movieinfo.setImage("http://netflixroulette.net/api/posters/541018.jpg"
					+ jObject.get("poster").getAsString());
			// pick the "Summary" key from the JSON object
			movieinfo.setSummary(jObject.get("summary").getAsString());

			return movieinfo;
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}
	
	public Movieinfo getSelectedMovieInfo(String title) {
		String url = "https://community-netflix-roulette.p.mashape.com/api.php?title=" +title;
		// Use HTTP GET with the above URL
		try (BufferedReader reader = HttpHelper.doGet(url)) { // try with resources will auto close the reader
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}
			
			// parse the HTTP response body to JSON
			JsonElement root = new JsonParser().parse(reader);
			// pick the "rating1" key from the root JSON object.
			JsonObject rootObject = root.getAsJsonObject();

			Movieinfo movieinfo = new Movieinfo();
			// pick the "Rating" key from the JSON object
			movieinfo.setRating(rootObject.get("rating").getAsString());
			// pick the "Poster" key from the JSON object
			movieinfo.setImage(rootObject.get("poster").getAsString());
			// pick the "Summary" key from the JSON object
			movieinfo.setSummary(rootObject.get("summary").getAsString());

			return movieinfo;
		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}
