public class RationalNumberTester {

	public static void main(String[] args) {
		RationalNumber rn1 = new RationalNumber();
		RationalNumber rn2 = new RationalNumber(2, 3);
		System.out.println(rn1.multiply(rn2).toString());
	}

}
