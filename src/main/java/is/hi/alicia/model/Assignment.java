package is.hi.alicia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

//@Data
@Entity
public class Assignment  {
	
	private Long id;
	private String title;
	private String questionDescription;
	private String teacherSolution;
	private Set<Answer> answers = new HashSet<>();
	private Course course;

	
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(columnDefinition = "TEXT")
	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	@Column(columnDefinition = "TEXT")
	public String getTeacherSolution() {
		return teacherSolution;
	}

	public void setTeacherSolution(String teacherSolution) {
		this.teacherSolution = teacherSolution;
	}
	
	@OneToMany(cascade=CascadeType.ALL)  
    @JoinColumn(name="assignment_answer")
	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="course_assignment")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
	
}
