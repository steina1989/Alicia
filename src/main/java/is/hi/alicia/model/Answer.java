package is.hi.alicia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Answer {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String sourceCode;
	private int distance;
	
	@ManyToOne
    @JoinColumn(name="question_id")
	private Question question;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private Teacher user;
	

}
