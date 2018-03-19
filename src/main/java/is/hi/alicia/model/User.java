package is.hi.alicia.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AliciaUser")
public class User {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String name;
	private String pwhash;
	
	
	@Column(unique=true)
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_user", 
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id", 
    referencedColumnName = "id"))
	private Set<Course> courses = new HashSet<Course>();	
		
}

