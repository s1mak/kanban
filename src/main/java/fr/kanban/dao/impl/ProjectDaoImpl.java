package fr.kanban.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import fr.kanban.bean.Project;
import fr.kanban.bean.QProject;
import fr.kanban.bean.QUser;
import fr.kanban.dao.ProjectDaoCustom;

public class ProjectDaoImpl implements ProjectDaoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Pour exemple.
	 */
	@Override
	public List<Project> findAllByOwnerEmailOrderName(String email) {
		QProject project = new QProject("p");
		QUser user = new QUser("u");
		JPAQuery query = new JPAQuery(entityManager);

		return query.from(project).innerJoin(project.owner, user)
				.where(user.email.eq(email)).orderBy(project.name.asc())
				.list(project);

		// return query.from(project).where(project.owner.email.eq(email))
		// .orderBy(project.name.asc()).list(project);
	}
}
