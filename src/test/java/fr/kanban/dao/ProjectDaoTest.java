package fr.kanban.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.kanban.bean.Project;
import fr.kanban.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@ContextConfiguration({ "classpath:test-context.xml" })
@Transactional
public class ProjectDaoTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ProjectDao projectDao;

	/**
	 * Pour exemple.
	 */
	@Test
	public void exemple1() {
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

		Project project = new Project();
		project.setName("P1");
		project.setOwner(user);
		projectDao.save(project);

		Project project2 = new Project();
		project2.setName("P2");
		project2.setOwner(user);
		projectDao.save(project2);

		Project project3 = new Project();
		project3.setName("P3");
		project3.setOwner(user2);
		projectDao.save(project3);

		List<Project> projects = projectDao
				.findAllByOwnerEmailOrderByNameAsc("email");
		assertEquals(2, projects.size());
	}

	/**
	 * Pour exemple avec QueryDSL.
	 */
	@Test
	public void exemple2() {
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

		Project project = new Project();
		project.setName("P1");
		project.setOwner(user);
		projectDao.save(project);

		Project project2 = new Project();
		project2.setName("P2");
		project2.setOwner(user);
		projectDao.save(project2);

		Project project3 = new Project();
		project3.setName("P3");
		project3.setOwner(user2);
		projectDao.save(project3);

		List<Project> projects = projectDao
				.findAllByOwnerEmailOrderName("email");
		assertEquals(2, projects.size());
	}
}
