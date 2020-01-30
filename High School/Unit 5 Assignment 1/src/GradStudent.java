public class GradStudent extends Student {

	private int myGradID;

	public GradStudent() {
		super();
		myGradID = 0;
	}

	public GradStudent(String name, int[] tests, int gradID) {
		super(name, tests);
		myGradID = gradID;
	}

	public int getID() {
		return myGradID;
	}

	@Override
	public void computeGrade() {
		super.computeGrade();
		if (getTestAverage() >= 90)
			super.setGrade("Pass with Distinction");
	}

}