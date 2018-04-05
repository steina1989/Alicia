package is.hi.alicia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

@Data
@Entity
public class Assignment  {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String questionDescription;
	
	@Column(columnDefinition = "TEXT")
	@JsonIgnore
	private String teacherSolution;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	private Date returnDate;
	
	@OneToMany
	@JoinColumn(name="answer_id")
	@OrderBy(clause = "distance")
	private List<Answer> answers = new ArrayList<Answer>();
		
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	
}
