package telus.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telus.server.dao.ProjectDAO;
import telus.server.entity.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDAO projectDAO;
	
	public Project saveOrUpdate(Project project) {
		return projectDAO.save(project);
	}

}
