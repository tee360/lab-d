package co.grandcircus.movies.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Provides connections to a MySQL database.
 */
@Component
public class JdbcConnectionFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(JdbcConnectionFactory.class);
	
	private String driverClass = "com.mysql.jdbc.Driver";
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	public Connection getConnection() {
		try {
			boolean passwordPresent = password != null & !password.isEmpty();
			logger.info("DB Connection. url:" + dbUrl + " user:" + username + "password:" + ( passwordPresent ? "present" : "ABSENT!" ));
			
			Class.forName(driverClass); 
		    return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException | ClassNotFoundException ex) {
		    throw new RuntimeException("Connection Failure", ex);
		}
	}

}
