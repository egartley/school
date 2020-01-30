import javax.swing.*;

public class Main {
	
	private static final int QUESTIONS = 20;
	
	private static Question[] questions = new Question[QUESTIONS];

	public static void main(String[] args) {
		int score = QUESTIONS;
		
		for (int i = 0; i < QUESTIONS; i++) {
			String msg = i + 1 + ") What is ";

			int type = (int) (Math.random() * 10 + 1);
			String to;
			
			if (type >= 7) {
				// hex to dec
				String from = Integer.toHexString((int) (Math.random() * 9999));
				
				msg += "0x" + from.toUpperCase() + " in decimal? ";
				to = String.valueOf(Integer.parseUnsignedInt(from, Question.HEXADECIMAL));
				
				questions[i] = new Question(from, Question.HEXADECIMAL, new Answer(to));
				questions[i].setHint("Ends with \"" + to.substring(to.length() - 2) + "\"");
			} else if (type <= 6 && type >= 3) {
				// dec to bin
				int from = (int) (Math.random() * 9999);
				
				msg += from + " in binary? ";
				to = Integer.toBinaryString(from);

				questions[i] = new Question(Integer.toString(from), Question.DECIMAL, new Answer(to));
				questions[i].setHint("Ends with \"" + to.substring(to.length() - 2) + "\"");
			} else {
				// bin to hex
				String from = Integer.toBinaryString((int) (Math.random() * 9999));
				
				msg += from + " in decimal? ";
				to = String.valueOf(Integer.parseUnsignedInt(from, Question.BINARY));
				
				questions[i] = new Question(from, Question.BINARY, new Answer(to));
				questions[i].setHint("Ends with \"" + to.substring(to.length() - 2) + "\"");
			}
			
			String in = JOptionPane.showInputDialog(msg), append = "Try again!", o = msg;
			boolean flag = true, again = true, shown = false;
			while (again) {
				if (questions[i].isCorrect(new Answer(in)))
					break;
				msg = append + "\n" + o;
				in = JOptionPane.showInputDialog(msg);
				
				if (flag) {
					score--;
					questions[i].answer.retry = false;
				}
				
				questions[i].retries++;
				if (questions[i].retries >= 3 && !shown) {
					append = "Try again! " + questions[i].getHintMessage();
					shown = true;
				}
				
				flag = false;
			}
			// JOptionPane.showMessageDialog(null, "Correct!");
		}
		String lastMsg = "Accuracy: " + (int) ((score / (1.0 * QUESTIONS)) * 100) + "% correct";
		if (score != QUESTIONS) {
			for (int i = 0; i < questions.length; i++) {
				if (i == 0)
					lastMsg += "\n";
				if (!questions[i].answer.retry) {
					lastMsg += "\nQuestion " + (i + 1) + " was wrong (" + questions[i].retries + " retries)";
				}
			}
		}
		JOptionPane.showMessageDialog(null, lastMsg);
	}

}