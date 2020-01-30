import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ValueController {

	public static Font buttonFont = new Font("Arial", Font.PLAIN, 32);
	public static int currentIndex = -1;

	public Object value;
	public String valueName;
	public double increment;
	public boolean pressed;

	private int positionDelta = 108;
	private int buttonWidth = 84;
	private int buttonHeight = 64;
	private String increaseText = "+";
	private String decreaseText = "-";
	private JButton increase, decrease;
	private JLabel label;

	public ValueController(int o, double increment, String valueName) {
		value = o;
		this.valueName = valueName;
		this.increment = increment;
		currentIndex++;
		increase = new JButton(increaseText);
		decrease = new JButton(decreaseText);
		increase.setFont(buttonFont);
		decrease.setFont(buttonFont);
		increase.setBounds(8, 8 + (positionDelta * currentIndex), buttonWidth,
				buttonHeight);
		decrease.setBounds(buttonWidth + 16,
				8 + (positionDelta * currentIndex), buttonWidth, buttonHeight);
		increase.setFocusable(false);
		decrease.setFocusable(false);
		increase.addActionListener(new ControllerActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				value = (int) (((int) value) + increment);
				label.setText(valueName + ": " + value);
				onUpdate();
			}
		});
		decrease.addActionListener(new ControllerActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				value = (int) (((int) value) - increment);
				label.setText(valueName + ": " + value);
				onUpdate();
			}
		});

		label = new JLabel();
		updateLabel(String.valueOf(value));
		label.setBounds(8, buttonHeight + 16 + (positionDelta * currentIndex),
				200, 18);
	}

	public ValueController(double o, double increment, String valueName) {
		value = o;
		this.increment = increment;
		this.valueName = valueName;
		currentIndex++;
		increase = new JButton(increaseText);
		decrease = new JButton(decreaseText);
		increase.setFont(buttonFont);
		decrease.setFont(buttonFont);
		increase.setBounds(8, 8 + (positionDelta * currentIndex), buttonWidth,
				buttonHeight);
		decrease.setBounds(buttonWidth + 16,
				8 + (positionDelta * currentIndex), buttonWidth, buttonHeight);
		increase.setFocusable(false);
		decrease.setFocusable(false);
		increase.addActionListener(new ControllerActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				value = (double) (((double) value) + increment);
				updateLabel(String.format("%.4f", (double) value));
				onUpdate();
			}
		});
		decrease.addActionListener(new ControllerActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				value = (double) (((double) value) - increment);
				updateLabel(String.format("%.4f", (double) value));
				onUpdate();
			}
		});

		label = new JLabel();
		updateLabel(String.format("%.4f", (double) value));
		label.setBounds(8, buttonHeight + 16 + (positionDelta * currentIndex),
				200, 18);
	}

	public void register(JFrame frame) {
		frame.add(increase);
		frame.add(decrease);
		frame.add(label);

	}

	private void updateLabel(String newText) {
		label.setText(valueName + ": " + newText);
	}

	/**
	 * Called <i>once</i> when the button is clicked
	 */
	public void onUpdate() {

	}

}
