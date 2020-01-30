import java.awt.Color;
import java.awt.Graphics;

public class Sprite {

	private int width, height, pixelSize;
	private Pixel[][] pixels;

	public Sprite(int w, int h, int ps) {
		width = w;
		height = h;
		pixelSize = ps;
		calc();
	}

	public Sprite(int w, int h, int ps, Pixel[][] p) {
		width = w;
		height = h;
		pixelSize = ps;
		pixels = p;
	}

	public void draw(Graphics g, int originX, int originY) {
		for (int i = 0; i < getPixels().length; i++) {
			for (int j = 0; j < getPixels()[i].length; j++) {
				Pixel p = getPixels()[i][j];
				// grab color to paint with from canvas
				g.setColor(p.getColor());
				// paint pixel
				g.fillRect(originX + (getPixelSize() * i),
						originY + (getPixelSize() * j), getPixelSize(),
						getPixelSize());
			}
		}
	}

	private void calc() {
		pixels = new Pixel[width][height];
		setDefault();
	}

	public void setDefault() {
		for (int i = 0; i < pixels.length; i++)
			for (int j = 0; j < pixels[i].length; j++)
				pixels[i][j] = new Pixel(new Color(0, 0, 0, 0)); // transparent
	}

	public void setPixels(Pixel[][] p) {
		pixels = p;
	}

	public void setPixel(int r, int c, Pixel p) {
		pixels[r][c] = p;
	}

	public void setWidthHeight(int w, int h) {
		width = w;
		height = h;
		calc();
	}

	public Pixel getPixelAt(int r, int c) {
		return pixels[r][c];
	}

	public Pixel[][] getPixels() {
		return pixels;
	}

	public int getActualWidth() {
		return width * pixelSize;
	}

	public int getActualHeight() {
		return height * pixelSize;
	}

	public int getPixelWidth() {
		return width;
	}

	public int getPixelHeight() {
		return height;
	}

	public int getPixelSize() {
		return pixelSize;
	}

}