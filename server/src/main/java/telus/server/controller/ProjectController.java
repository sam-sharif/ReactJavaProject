package telus.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import telus.server.entity.Project;
import telus.server.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping("/project")
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		
		Project theProject = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(theProject,HttpStatus.CREATED);
	}
}
