import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/** Method to keep only the blue */
	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj
						.getBlue()) / 3;
				pixelObj.setRed(255 - avg);
				pixelObj.setGreen(255 - avg);
				pixelObj.setBlue(255 - avg);
			}
		}
	}

	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(pixelObj.getRed() + 124);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = getPixels2D();
		for (int i = 0; i < pixels.length; i++) {
			Pixel[] row = pixels[i];
			for (int k = 0; k < row.length / 2; k++) {
				row[row.length - k - 1].setRed(row[k].getRed());
				row[row.length - k - 1].setGreen(row[k].getGreen());
				row[row.length - k - 1].setBlue(row[k].getBlue());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorHorizontal() {
		Pixel[][] pixels = getPixels2D();
		for (int i = 0; i < pixels.length / 2; i++) {
			Pixel[] row = pixels[i];
			for (int k = 0; k < row.length; k++) {
				pixels[pixels.length - 1 - i][k].setRed(row[k].getRed());
				pixels[pixels.length - 1 - i][k].setGreen(row[k].getGreen());
				pixels[pixels.length - 1 - i][k].setBlue(row[k].getBlue());
			}
		}
	}
	
	public void mirrorTemple() {
		Pixel[][] pixels = getPixels2D();
		for (int i = 0; i < 100; i++) {
			Pixel[] row = pixels[i];
			for (int k = 0; k < row.length / 2; k++) {
				row[row.length - k - 1].setRed(row[k].getRed());
				row[row.length - k - 1].setGreen(row[k].getGreen());
				row[row.length - k - 1].setBlue(row[k].getBlue());
			}
		}
	}
	
	public void mirrorDiagonal() {
		Pixel[][] pixels = getPixels2D();
		for (int rowIndex = 0; rowIndex < pixels.length; rowIndex++) {
			for (int col = 0; col < rowIndex; col++) {
				pixels[pixels.length - rowIndex - 1][pixels.length - col - 1].setRed(pixels[pixels.length - col - 1][pixels.length - rowIndex].getRed());
				pixels[pixels.length - rowIndex - 1][pixels.length - col - 1].setGreen(pixels[pixels.length - col - 1][pixels.length - rowIndex].getGreen());
				pixels[pixels.length - rowIndex - 1][pixels.length - col - 1].setBlue(pixels[pixels.length - col - 1][pixels.length - rowIndex].getBlue());
			}
		}
	}

	// /////////////////// constructors //////////////////////////////////
	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height "
				+ getHeight() + " width " + getWidth();
		return output;

	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

}
