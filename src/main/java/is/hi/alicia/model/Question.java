package is.hi.alicia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Question {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String text;
	
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

}
