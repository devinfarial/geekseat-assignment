package com.devinfarial.assignmentgs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.devinfarial.assignmentgs.model.User;

class UserDAOTest {
	private DriverManagerDataSource dataSource;
	private UserDAO dao;
	
	
	@BeforeEach
	void setupBeforeEach(){
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/geekseat");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao = new UserDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		User user = new User("testname", "testemail", "testpassword", "testrole","active");
		System.out.println(user.toString());
		dao.save(user);
	}

	@Test
	void testUpdate() {
		User user = new User(9, "asd", "asd", "asd", "testrole","active");
		dao.update(user);
	}

	@Test
	void testGet() {
		Integer id = 1;
		
		System.out.println(dao.get(id));
	}

	@Test
	void testDelete() {
		Integer id = 9;
		dao.delete(id);
	}

	@Test
	void testList() {
		System.out.println(dao.list());
	}
	
	@Test
	void testLogin() {
		User user = new User("d","d");
		dao.validateUser(user);
		System.out.println(dao.validateUser(user).getId());
	}

}
