package fr.kanban.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.kanban.bean.Project;

public interface ProjectDao extends JpaRepository<Project, Long>,
		ProjectDaoCustom {
	public List<Project> findAllByOwnerEmailOrderByNameAsc(String email);
}
