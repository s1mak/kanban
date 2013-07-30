package fr.kanban.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;

import fr.kanban.bean.User;
import fr.kanban.dao.UserDao;

//@Repository
public class UserDaoJpaImpl extends QueryDslJpaRepository<User, Long> implements
		UserDao {

	public UserDaoJpaImpl(JpaEntityInformation<User, Long> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public User findByEmail(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// public UserDaoJpaImpl(JpaEntityInformation<User, ?> entityInformation,
	// EntityManager entityManager) {
	// super(entityInformation, entityManager);
	// // TODO Auto-generated constructor stub
	// }

}
