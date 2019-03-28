package com.arek;

import java.io.File;
import java.util.Random;

class RandomImage {
	private static final File image = pickRandomImage();

	 private static File pickRandomImage() {
		final File dir = new File("./kosiarki");
		File[] images = dir.listFiles();
		Random r = new Random();
		return images[r.nextInt(images.length)];
	}

	static File getImage() {
		return image;
	}
}
