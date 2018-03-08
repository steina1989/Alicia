package is.hi.alicia.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Assignment  {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	private Date returnDate;
	
}
