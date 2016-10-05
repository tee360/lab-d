/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies.dao;

import java.util.List;

import co.grandcircus.movies.exception.NotFoundException;
import co.grandcircus.movies.model.User;

/**
 * Responsibility: To provide access to all the users.
 */
public interface UserDao {
	
	/**
	 * Get a list that contains every user.
	 */
	List<User> getAllUsers();
	
	/**
	 * Get a list that contains every user, sorted as specified.
	 *  
	 * @param sortOrder must be one of "firstName", "lastName", "email".
	 * @return sorted list of users
	 * @throws IllegalArgumentException if the sortOrder is invalid
	 */
	List<User> getAllUsersSortedBy(String sortOrder) throws IllegalArgumentException;

	/**
	 * Get the user with the specified id number.
	 * 
	 * @param id numeric ID of the user
	 * @return the user
	 * @throws NotFoundException if no such user exists
	 */
	User getUser(int id) throws NotFoundException;
	
	/**
	 * Get the user with the specified email and password.
	 * 
	 * @param email
	 * @param password
	 * @return the matching user
	 * @throws NotFoundException if no such user exists
	 */
	User getUserByEmailAndPassword(String email, String password);
	
	/**
	 * Add the given move to the list.
	 * 
	 * @param user the user to add
	 * @return the id of the new user
	 */
	int addUser(User user);
	
	/**
	 * Update the specified user
	 * 
	 * @param id numeric id identifies the user to update
	 * @param user the new values for the user
	 * @throws NotFoundException if the user does not exist
	 */
	void updateUser(int id, User user) throws NotFoundException;
	
	/**
	 * Delete the specified user
	 * 
	 * @param id numeric id identifies the move to delete
	 * @throws NotFoundException if the user does not exist
	 */
	void deleteUser(int id) throws NotFoundException;
	

}
