public class StudentTester {

	public static void main(String[] args) {
		Student chris = new Student("Chris", new int[] { 100, 90 });
		Student bill = new Student("Bill", new int[] { 80, 90 });
		System.out.println(chris.getAverage());
		System.out.println(chris.highGrade());
		chris.extraCredit(5);
		System.out.println(chris.getAverage());
		System.out.println(chris);
		if (chris.compareAverage(bill))
			System.out.println("Chris had a higher average than Bill");
		else
			System.out.println("Bill had a higher average than Chris");
	}

}
