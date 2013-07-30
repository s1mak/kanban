package fr.kanban.service;

import org.springframework.beans.factory.annotation.Autowired;

import fr.kanban.bean.User;
import fr.kanban.dao.UserDao;

public class UserService {

	@Autowired
	private UserDao userDao;

	public void createUser(User user) {
		userDao.save(user);
	}
}
