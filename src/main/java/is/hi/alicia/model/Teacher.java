package is.hi.alicia.model;

import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
public class Teacher {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private String name;
	private int age;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_teacher", 
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "teacher_id", 
    referencedColumnName = "id"))
	private List<Course> courses;
	
		
}

