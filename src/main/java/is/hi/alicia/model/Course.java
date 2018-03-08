package is.hi.alicia.model;
import java.util.ArrayList;
import java.util.List;

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
	@JoinColumn(name="teacher_id")
	private List<Teacher> teachers = new ArrayList<Teacher>();	

	@ManyToMany
	@JoinColumn(name="student_id")
	private List<Student> students =  new ArrayList<Student>();	
	
	@OneToMany(mappedBy="course")
	private List<Assignment> assignments = new ArrayList<Assignment>();	
	
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void addTecher(Teacher teacher) {
		this.teachers.add(teacher);
	}
	
	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
	}



}
