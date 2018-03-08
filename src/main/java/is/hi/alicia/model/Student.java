package is.hi.alicia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
public class Student {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private String pwhash;
	
	@Column(unique=true)
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", 
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "student_id", 
    referencedColumnName = "id"))
	private List<Course> courses = 	new ArrayList<Course>();	
	
		
}

