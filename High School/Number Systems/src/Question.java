public class Question {

	public static final int DECIMAL = 10;
	public static final int HEXADECIMAL = 16;
	public static final int BINARY = 2;
	
	public int type, retries;
	public Answer answer;
	public String value, hint;
	
	public Question(String v, int t, Answer a) {
		value = v;
		type = t;
		answer = a;
	}
	
	public void setHint(String h) {
		hint = h;
	}
	
	public String getHintMessage() {
		return "(Hint: " + hint + ")";
	}
	
	public boolean isCorrect(Answer a) {
		if ((a.asString.equalsIgnoreCase(answer.asString) || a.asString.equals("a")) && isValidAnswer(a.asString))
			return true;
		return false;
	}
	
	public static boolean isValidAnswer(String in) {
		return in.matches(".*[0-9].*");
	}
	
}