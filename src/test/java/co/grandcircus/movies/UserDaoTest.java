/*
 * Source Material (c) 2016 GCD
 * All rights reserved
 */
package co.grandcircus.movies;

import org.junit.Assert;
import org.junit.Test;

import co.grandcircus.movies.dao.UserDao;
import co.grandcircus.movies.dao.UserDaoImpl;
import co.grandcircus.movies.exception.NotFoundException;
import co.grandcircus.movies.model.User;

public class UserDaoTest {
	
	UserDao dao = new UserDaoImpl();
	
	@Test
	public void getUserById() {
		User user = dao.getUser(2);
		Assert.assertEquals("Mark", user.getFirstName());
		Assert.assertEquals("Twain", user.getLastName());
	}
	
	@Test(expected = NotFoundException.class)
	public void getUserByIdNotFound() {
		dao.getUser(0);
	}
	
	@Test(expected = NotFoundException.class)
	public void getUserByIdNotFound2() {
		dao.getUser(12);
	}
	
	@Test
	public void getUserByEmailAndPassword() {
		User user = dao.getUserByEmailAndPassword("mark@example.com", "sawyer");
		Assert.assertEquals("Mark", user.getFirstName());
		Assert.assertEquals("Twain", user.getLastName());
	}
	
	@Test(expected = NotFoundException.class)
	public void getUserByEmailAndPasswordNotFoundEmail() {
		dao.getUserByEmailAndPassword("wrong@example.com", "sawyer");
	}
	
	@Test(expected = NotFoundException.class)
	public void getUserByEmailAndPasswordNotFoundPassword() {
		dao.getUserByEmailAndPassword("mark@example.com", "wrong");
	}
	
	@Test(expected = NotFoundException.class)
	public void getUserByEmailAndPasswordNotFound() {
		dao.getUserByEmailAndPassword("wrong@example.com", "also wrong");
	}

}
