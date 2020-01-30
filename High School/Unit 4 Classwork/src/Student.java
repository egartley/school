public class Student {

	private String name;
	private int test1;
	private int test2;
	private int test3;

	/**
	 * pre: none post: constructs a Student object with name "" and all scores 0
	 */
	public Student() {
		name = "";
		test1 = 0; // redundent
		test2 = 0; // redundent
		test3 = 0; // redundent
	}

	/**
	 * pre: none post: intializes the name and test scores to the values
	 * provided by the client
	 */
	public Student(String n, int t1, int t2, int t3) {
		name = n;
		test1 = t1;
		test2 = t2;
		test3 = t3;
	}

	/**
	 * pre: none post: returns name
	 */
	public String getName() {
		return name;
	}

	/**
	 * pre: needs 1 <= testNum <= 3 post: returns the specified grade
	 */
	public int getScore(int testNum) {
		switch (testNum) {
		case 1:
			return test1;
		case 2:
			return test2;
		case 3:
			return test3;
		default:
			return 0;
		}
	}

	/**
	 * pre: none post: returns the average of the test scores to the nearest
	 * whole number
	 */
	public int getAverage() {
		return (int) ((test1 + test2 + test3) / 3.0);
	}

	/**
	 * pre: none post: returns the value of the highest test score
	 */
	public int getHighScore() {
		return Math.max(Math.max(test1, test2), test3);
	}

	/**
	 * pre: none post: returns a String version of the Student
	 * 
	 * @return "name of student has tests scores of _____, ______, and _____,
	 *         with a test average of ___"
	 */
	public String toString() {
		return name + " has test scores of " + test1 + ", " + test2 + ", and "
				+ test3 + " with with an average of " + getAverage();
	}

	/**
	 * pre: none post: Changes the name
	 */
	public void setName(String nm) {
		name = nm;
	}

	/**
	 * pre: needs 1 <= testNum <= 3 post: replaces the specified grade with new
	 * value
	 */
	public void setScore(int testNum, int score) {
		switch (testNum) {
		case 1:
			test1 = score;
			break;
		case 2:
			test2 = score;
			break;
		case 3:
			test3 = score;
			break;
		default:
			break;
		}
	}
	
	public boolean hasHigherTestAverageThan(Student other) {
		return this.getAverage() < other.getAverage();
	}
	
}