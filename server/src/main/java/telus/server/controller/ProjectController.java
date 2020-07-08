package telus.server.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
	
	
	
}
