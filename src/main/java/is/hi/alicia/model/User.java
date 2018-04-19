package is.hi.alicia.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "AliciaUser")
public class User {
	
	private Long id;
	private String name;
	private String pwhash;
	private String email;
	private Set<Course> courses = new HashSet<Course>();

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwhash() {
		return pwhash;
	}

	public void setPwhash(String pwhash) {
		this.pwhash = pwhash;
	}
	@Column(unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_course", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}	
	
	
	
		
}

