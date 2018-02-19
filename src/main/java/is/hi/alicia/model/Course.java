package is.hi.alicia.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Course {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	
	/
	@ManyToMany
	@JoinColumn(name="teacher_id")
	private List<Teacher> teachers;
	
	@ManyToMany
	@JoinColumn(name="student_id")
	private List<Student> students;
	
	@OneToMany(mappedBy="course")
	private List<Assignment> assignments;
	
	
	

}
