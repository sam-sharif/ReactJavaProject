package telus.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import telus.server.dao.ProjectDAO;
import telus.server.entity.Project;
import telus.server.exception.ProjectIdException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectDAO.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("The project identifier already exists.");
		}
		
	}
	
	public Project findByProjectIdentifier(String projectIdentifier) {
		
		return projectDAO.findByProjectIdentifier(projectIdentifier);
	}
	
	public List<Project> findAllProjects(){
		
		return projectDAO.findAll();
	}
	
	public void deleteByProjectIdentifier(String projectIdentifier) {
		
		Project project = projectDAO.findByProjectIdentifier(projectIdentifier);
		if(project == null) {
			throw new ProjectIdException("The project with id="+projectIdentifier+"does not exist!");
		}
		projectDAO.delete(project);
	}

}
