package is.hi.alicia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Answer {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String sourceCode;
	
	@ManyToOne
    @JoinColumn(name="question_id")
	private Question question;
	
    @ManyToOne
    @JoinColumn(name="student_id")
	private Student student;
	

}
