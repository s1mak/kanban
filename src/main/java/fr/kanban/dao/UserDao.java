package fr.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.kanban.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByEmail(String string);

}
