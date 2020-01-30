package net.egartley.breakout.media;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {

	public static BufferedImage mike;

	public static void load() {
		try {
			mike = ImageIO.read(new File("res/mike.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
