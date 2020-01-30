public abstract class Student {

	public static final int NUM_TESTS = 3;
	private String myName;
	private int[] myTests;
	private String myGrade;

	public Student() {
		myName = "";
		myTests = new int[NUM_TESTS];
	}

	public Student(String name, int[] test) {
		myName = name;
		myTests = test;
	}

	public String getName() {
		return myName;
	}

	public String getGrade() {
		return myGrade;
	}

	public void setGrade(String newGrade) {
		myGrade = newGrade;
	}

	public double getTestAverage() {
		double sum = 0;
		for (int g : myTests)
			sum += g;
		return sum / myTests.length;
	}

	public void computeGrade() {
		if (myName.equals(""))
			myGrade = "No grade";
		if (getTestAverage() < 65)
			myGrade = "Fail";
		else
			myGrade = "Pass";
	}

}
