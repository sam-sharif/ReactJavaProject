package telus.server.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telus.server.entity.Project;
import telus.server.service.MapValidationService;
import telus.server.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationService mapValidationService;

	@PostMapping("/project")
	public ResponseEntity<?> saveProject(@Valid @RequestBody Project project , BindingResult theBindingResult) {
		
		ResponseEntity<?> errors = mapValidationService.mapValidation(theBindingResult);
		if(errors!=null) return errors;
		Project theProject = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(theProject,HttpStatus.CREATED);
	}
	
	@GetMapping("/project/{projectIdentifier}")
	public ResponseEntity<?> findByProjectIdentifier(@PathVariable String projectIdentifier) {
		
		Project project = projectService.findByProjectIdentifier(projectIdentifier.toUpperCase());
		if(project==null) {
			return new ResponseEntity<String>("The project Id does not exist!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/projects")
	public List<Project> findAllProjects(){
		
		return projectService.findAllProjects();
	}
	
	@DeleteMapping("/project/{projectIdentifier}")
	public ResponseEntity<?> deleteByProjectIdentifier(@PathVariable String projectIdentifier){
		
		projectService.deleteByProjectIdentifier(projectIdentifier.toUpperCase());
		return new ResponseEntity<String>("project with id of "+projectIdentifier+" was deleted!",HttpStatus.OK);
	}
	
	
	
}
