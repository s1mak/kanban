package fr.kanban.dao;

import java.util.List;

import fr.kanban.bean.Project;

public interface ProjectDaoCustom {

	List<Project> findAllByOwnerEmailOrderName(String email);
}
