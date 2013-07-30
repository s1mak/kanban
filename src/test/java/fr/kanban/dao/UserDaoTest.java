package fr.kanban.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.kanban.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@ContextConfiguration({ "classpath:test-context.xml" })
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	/**
	 * Pour Exemple
	 */
	@Test
	public void findByEmail() {
		User user = new User();
		user.setEmail("email");
		userDao.save(user);
		User user2 = new User();
		user2.setEmail("email2");
		userDao.save(user2);

		User u1 = userDao.findByEmail("email");
		assertNotNull(u1);
		User u2 = userDao.findByEmail("email2");
		assertNotNull(u2);
		User u3 = userDao.findByEmail("email3");
		assertNull(u3);

	}
}
