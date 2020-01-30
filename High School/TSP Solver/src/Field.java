import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Field {

	static boolean isCalculated;

	private static short fw = 650;

	static ArrayList<Point> points = new ArrayList<>();
	static ArrayList<Segment> segments = new ArrayList<>();

	static void onClick(int x, int y) {
		x -= 6;
		y -= 6;
		if (points.size() < 150) {
			if (x > 7 && x < fw - 2 && y > 8 && y < Main.WINDOW_HEIGHT - 20) {
				boolean exists = false;
				for (Point p : points)
					exists = p.x == x && p.y == y;
				if (!exists)
					points.add(new Point(x, y));

				// update base/end booleans
				if (points.size() == 1) {
					points.get(0).isBasePoint = true;
					points.get(0).isEndPoint = true;
				} else {
					points.get(points.size() - 1).isEndPoint = true;
					points.get(points.size() - 2).isEndPoint = false;
				}
			}
		}
	}

	public static void tick() {

	}

	static void render(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.drawRect(8, 8, 650, Main.WINDOW_HEIGHT - 17);
		if (isCalculated)
			for (int i = 0; i < segments.size(); i++)
				segments.get(i).render(graphics);
		for (int i = 0; i < points.size(); i++)
			points.get(i).render(graphics);
	}

}