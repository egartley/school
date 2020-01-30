import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static boolean running = true;
	public static int numberOfBubbles;
	public static double radiusFactor, radiusIncrement, spreadFactor,
			alphaIncrement;

	private static int diameter;

	private static DrawingPanel panel;
	private static Graphics g;
	private static Coordinate coordinate;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bubble Controller");
		frame.setSize(200, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.addMouseListener(new MouseListen());
		// JButton increaseButton = new JButton();
		// JButton decreaseButton = new JButton();
		/*
		 * increaseButton.setName("increaseButton");
		 * decreaseButton.setName("decreaseButton");
		 * increaseButton.setToolTipText("Increase bubble spread");
		 * decreaseButton.setToolTipText("Decrease bubble spread"); int w = 116;
		 * increaseButton.setBounds(4, 4, w, w); decreaseButton.setBounds(4, w +
		 * 10, w, w); buttonFont = new Font("Arial", Font.PLAIN, 66);
		 * increaseButton.setFont(buttonFont);
		 * decreaseButton.setFont(buttonFont); increaseButton.setText("+");
		 * decreaseButton.setText("-"); increaseButton.setFocusable(false);
		 * decreaseButton.setFocusable(false);
		 * 
		 * JLabel incrementDisplay = new JLabel("Increment: 0.0400");
		 * incrementDisplay.setBounds(4, 250, 120, 32); JLabel amountDisplay =
		 * new JLabel("Amount: 20"); amountDisplay.setBounds(4, 270, 80, 32);
		 * JLabel spreadDisplay = new JLabel("Spread: 2.15");
		 * spreadDisplay.setBounds(4, 290, 120, 32);
		 * 
		 * increaseButton.addActionListener(new ControllerActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * radiusIncrement += 0.005; numberOfBubbles++; spreadFactor += 0.125;
		 * incrementDisplay.setText("Increment: " + String.format("%.4f",
		 * radiusIncrement)); amountDisplay.setText("Amount: " +
		 * numberOfBubbles); spreadDisplay.setText("Spread: " + spreadFactor); }
		 * }); decreaseButton.addActionListener(new ControllerActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * radiusIncrement -= 0.005; numberOfBubbles--; spreadFactor -= 0.125;
		 * incrementDisplay.setText("Increment: " + String.format("%.4f",
		 * radiusIncrement)); amountDisplay.setText("Amount: " +
		 * numberOfBubbles); spreadDisplay.setText("Spread: " + spreadFactor); }
		 * });
		 */
		frame.setLayout(null);

		radiusFactor = 1;
		radiusIncrement = 0.04;
		spreadFactor = 2.15;
		numberOfBubbles = 20;
		alphaIncrement = 15;

		ValueController amount = new ValueController(numberOfBubbles, 5,
				"Amount of Bubbles") {
			@Override
			public void onUpdate() {
				numberOfBubbles = (int) value;
			}
		};
		amount.register(frame);
		ValueController dist = new ValueController(spreadFactor, 0.05,
				"Spread Divider") {
			@Override
			public void onUpdate() {
				spreadFactor = (double) value;
			}
		};
		dist.register(frame);
		ValueController ri = new ValueController(radiusIncrement, 0.005,
				"Radius Increment") {
			@Override
			public void onUpdate() {
				radiusIncrement = (double) value;
			}
		};
		ri.register(frame);
		ValueController rf = new ValueController(radiusFactor, 0.1,
				"Radius Factor") {
			@Override
			public void onUpdate() {
				radiusFactor = (double) value;
			}
		};
		rf.register(frame);
		ValueController ai = new ValueController(alphaIncrement, 1,
				"Alpha Increment") {
			@Override
			public void onUpdate() {
				double v = (double) value;
				if (v > 255)
					v = 255;
				if (v < 0)
					v = 0;
				alphaIncrement = v;
			}
		};
		ai.register(frame);

		frame.setVisible(true);

		int fullWidth = 800, fullHeight = 800;
		panel = new DrawingPanel(fullWidth, fullHeight);
		g = panel.getGraphics();
		frame.setLocationRelativeTo(panel.frame);

		g.setFont(new Font("Segoe UI", Font.BOLD, 17));
		g.setColor(Color.BLACK);

		int baseAlpha = 80;
		int spread = (int) (fullWidth / spreadFactor);
		ArrayList<Integer> bubbleX = new ArrayList<Integer>();
		ArrayList<Integer> bubbleY = new ArrayList<Integer>();
		Color circleColor = new Color(15, 147, 255, baseAlpha);

		while (running) {
			panel.clear();

			spread = (int) (fullWidth / spreadFactor);

			radiusFactor += radiusIncrement;
			g.setColor(circleColor);

			diameter = (int) (96 * radiusFactor);

			coordinate = getBaseCenterCoordinate(new Sprite(diameter, diameter,
					1));
			for (int i = 0; i < numberOfBubbles; i++) {
				if ((int) (Math.random() * 10 + 1) <= 5)
					bubbleX.add((int) (Math.random() * (spread * (fullWidth / fullHeight))));
				else
					bubbleX.add((int) (Math.random()
							* (spread * (fullWidth / fullHeight)) * -1));

				if ((int) (Math.random() * 10 + 1) <= 5)
					bubbleY.add((int) (Math.random() * spread));
				else
					bubbleY.add((int) (Math.random() * spread * -1));
			}
			for (int i = 0; i < numberOfBubbles; i++)
				g.fillOval(coordinate.x + bubbleX.get(i), coordinate.y
						+ bubbleY.get(i), diameter, diameter);

			baseAlpha -= alphaIncrement;
			if (baseAlpha <= 0) {
				baseAlpha = 150;
				radiusFactor = 1;
				bubbleX = new ArrayList<Integer>();
				bubbleY = new ArrayList<Integer>();

				for (int i = 0; i < numberOfBubbles; i++) {
					if ((int) (Math.random() * 10 + 1) <= 5)
						bubbleX.add((int) (Math.random() * (spread * (fullWidth / fullHeight))));
					else
						bubbleX.add((int) (Math.random()
								* (spread * (fullWidth / fullHeight)) * -1));

					if ((int) (Math.random() * 10 + 1) <= 5)
						bubbleY.add((int) (Math.random() * spread));
					else
						bubbleY.add((int) (Math.random() * spread * -1));
				}
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static Coordinate getBaseCenterCoordinate(Sprite s) {
		return new Coordinate(
				(panel.getWidth() / 2) - (s.getActualWidth() / 2),
				(panel.getHeight() / 2) - (s.getActualHeight() / 2));
	}

}