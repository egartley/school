public class RationalNumber {

	private int numerator, denominator;

	public RationalNumber() {
		numerator = 0;
		denominator = 1;
	}

	public RationalNumber(int n, int d) {
		numerator = n;
		denominator = d;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setNumerator(int n) {
		numerator = n;
	}

	public void setDenominator(int d) {
		denominator = d;
	}

	public RationalNumber multiply(RationalNumber r) {
		return new RationalNumber(r.getNumerator() * this.getNumerator(),
				r.getDenominator() * this.getDenominator());
	}

	public String toString() {
		if (denominator == 1)
			return String.valueOf(numerator);
		return numerator + "/" + denominator;
	}

}
