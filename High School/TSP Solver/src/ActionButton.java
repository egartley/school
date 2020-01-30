import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ActionButton {

	private static byte index = 0;
	private byte thisIndex;

	private short width = 180;
	private short height = 32;
	private int x, y;

	private String text;
	private Color enabledColor = new Color(0, 145, 17);
	private Color disabledColor = Color.DARK_GRAY;
	private Color textColor = Color.WHITE;
	private Font font = new Font("Arial", Font.PLAIN, 18);

	public ActionButton(String text) {
		this.text = text;
		thisIndex = index++;
		x = 700 + (int) (3.25 * text.length());
		y = (400 - (thisIndex * 44)) + 21;
	}

	void onClick() {

	}

	void render(Graphics graphics) {
		graphics.setColor(textColor);
		graphics.drawString(text, x, y);
	}

}
