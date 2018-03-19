package is.hi.alicia.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;


@Data
@Entity
public class Course {


	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
		
	@ManyToMany
	@JoinColumn(name="user_id")
	private Set<User> users = new HashSet<User>();	
	
	@OneToMany
	@JoinColumn(name="assignment_id")
	private Set<Assignment> assignments = new HashSet<Assignment>();
	
	public void addUser(User user) {
		this.users.add(user);
	}

	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);

	}



}
