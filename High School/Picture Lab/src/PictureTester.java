/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		testMirrorDiagonal();
	}

	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("water.jpg");
		beach.fixUnderwater();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.mirrorHorizontal();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.mirrorTemple();
		temple.explore();
	}
	
	public static void testMirrorDiagonal() {
		Picture beach = new Picture("beach.jpg");
		beach.mirrorDiagonal();
		beach.explore();
	}

}