package com.arek;

import java.io.File;
import java.util.Random;

class RandomImage {
	private static File image = pickRandomImage();

	 private static File pickRandomImage() {
		File[] images = new File("./img").listFiles();
		Random r = new Random();
		return images[r.nextInt(images.length)];
	}

	 static File getImage() {
		return image;
	}
}
