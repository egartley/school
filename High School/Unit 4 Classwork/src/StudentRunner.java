public class StudentRunner {
	public static void main(String[] args) {
		/*
		 * Declare a student object called bro and set the name to Mr. Wuest
		 * with all three test scores set to 100. Declare a Student object
		 * called orb and set the name to Louis with test scores of 80, 82, and
		 * 84.
		 */

		Student orb = new Student("Mr. Wuest", 100, 100, 100);
		Student bro = new Student("Louis", 80, 82, 84);

		if (bro.getAverage() == 82)
			System.out.println("Your getAverage() method is correct!");
		else
			System.out.println("Fix your getAverage() method");
		bro.setScore(1, 90);
		bro.setScore(2, 95);
		if (bro.getScore(2) == 95)
			System.out.println("Your setScore() method is correct!");
		else
			System.out.println("Fix your setScore() method!");
		if (orb.getHighScore() == 100)
			System.out.println("Your getHighScore() method is correct!");
		else
			System.out.println("Fix your getHighScore() method!");
	}
}