public class StudentTester {

	public static void main(String[] args) {
		Teachable[] students = { new HighSchoolStudent("Bob", 3.8),
				new CollegeStudent("Stevie", 3.1),
				new CollegeStudent("Adam", 4.0) };
		System.out.println(greaterGPA(students[0], students[1]));
		System.out.println(greaterGPA(students[1], students[2]));
		System.out.println(greaterGPA(students[0], students[2]));
		System.out.println(findMax(students).getGPA());
	}

	public static String greaterGPA(Teachable one, Teachable two) {
		if (one.getGPA() > two.getGPA())
			return one.getName();
		else if (one.getGPA() == two.getGPA())
			return "They have the same GPA!";
		return two.getName();
	}

	public static Teachable findMax(Teachable[] students) {
		if (students.length == 0)
			return null;
		for (Teachable t : students)
			if (t.equals(null))
				return null;

		Teachable max = students[0];
		for (Teachable t : students) {
			if (t.getGPA() > max.getGPA())
				max = t;
		}
		return max;
	}

}
