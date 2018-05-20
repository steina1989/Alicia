package is.hi.alicia.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.googlejavaformat.FormatterDiagnostic;

import is.hi.alicia.diff.GoogleDiff;
import lombok.Data;

@Entity
public class Answer {	

	private Long id;
	private String sourceCode;
	private String sourceCodeBeautified;
	private int distance;
	private Assignment assignment;
	private boolean marked;
	private String formatterDiagnostics;
	@Embedded
	private Feedback feedback = new Feedback();
		
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	@Column(columnDefinition = "TEXT")
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	@Column(columnDefinition = "TEXT")
	public String getSourceCodeBeautified() {
		return sourceCodeBeautified;
	}
	public void setSourceCodeBeautified(String sourceCodeBeautified) {
		this.sourceCodeBeautified = sourceCodeBeautified;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		
		this.distance = distance;
	}
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="assignment_answer")
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	@Column(columnDefinition = "TEXT")
	public String getFormatterDiagnostics() {
		return formatterDiagnostics;
	}
	public void setFormatterDiagnostics(String formatterDiagnostics) {
		this.formatterDiagnostics = formatterDiagnostics;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	


	
	
	
	


}
