package is.hi.alicia.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Entity
public class Course {
	
	private long id;
	private String name;
	private String identifier;
	private int count;
	private Set<Assignment> assignments = new HashSet<>();
	private Set<User> users = new HashSet<User>();	
	
	
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinColumn(name="course_assignment")
	public Set<Assignment> getAssignments() {
		return assignments;
	}
	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}
	
	@ManyToMany(mappedBy = "courses")
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public int getCount() {
		return this.assignments.size();
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	

}
