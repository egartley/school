public class StudentTester {

	public static void main(String[] args) {
		GradStudent grad = new GradStudent("Jason", new int[] { 89, 67, 92, 97,
				78 }, 12);
		UnderGrad under = new UnderGrad("Jeffery", new int[] { 66, 77, 88, 100,
				99 });
		grad.computeGrade();
		under.computeGrade();
		System.out.println("Graduate grade: " + grad.getGrade()
				+ ", undergraduate grade: " + under.getGrade());
	}

}
