public class UnderGrad extends Student {
	
	public UnderGrad() {
		super();
	}

	public UnderGrad(String name, int[] tests) {
		super(name, tests);	
	}

	@Override
	public void computeGrade() {
		double avg = getTestAverage();
		if (avg >= 70)
			setGrade("Pass");
		else
			setGrade("Fail");
	}
}
