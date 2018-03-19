package is.hi.alicia.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.alicia.model.Assignment;
import is.hi.alicia.model.Course;
import is.hi.alicia.repository.AssignmentRepository;
import is.hi.alicia.repository.CourseRepository;
import is.hi.alicia.repository.UserRepository;

@RepositoryRestController
@RequestMapping("/api/")
public class APIController {
	
	private final CourseRepository cr;
	
	@Autowired
	APIController(CourseRepository cr){
		this.cr = cr;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/somefinnyshit/{courseId}")
	void add(@PathVariable Long courseId, @RequestBody long teacherId) {
		return;
	
	}



}
