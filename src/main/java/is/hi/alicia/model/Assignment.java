package is.hi.alicia.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Assignment  {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private String questionDescription;

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	private Date returnDate;
	
	@OneToMany(mappedBy = "assignment")
	private Set<Answer> answers = new HashSet<Answer>();
	
}
