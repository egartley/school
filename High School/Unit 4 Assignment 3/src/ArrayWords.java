public class ArrayWords {

	public String[][] letters;

	public ArrayWords(String[][] letters) {
		this.letters = letters;
	}

	public String getUpDown(int rowStart, int rowEnd, int colNumber) {
		String r = "";
		for (int i = rowStart; i <= rowEnd; i++) {
			r += letters[i][colNumber];
		}
		return r;
	}

	public String getLeftRight(int colStart, int colEnd, int rowNum) {
		String r = "";
		for (int i = colStart; i <= colEnd; i++) {
			r += letters[rowNum][i];
		}
		return r;
	}

}
