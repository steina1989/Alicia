package is.hi.alicia.model;

import javax.persistence.Embeddable;

@Embeddable
public class Feedback {
	
	private String comment;
	private double grade;
	
	public Feedback() {
		this.comment = "";
		this.grade = 1.0;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	

}
