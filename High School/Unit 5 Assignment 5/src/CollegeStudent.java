
public class CollegeStudent implements Teachable {

	private double gpa;
	private String studentName;
	
	public CollegeStudent(String n, double gpa) {
		studentName = n;
		this.gpa = gpa;
	}

	public double getGPA() {
		return gpa;
	}
	
	public String getName() {
		return studentName;
	}
	
}