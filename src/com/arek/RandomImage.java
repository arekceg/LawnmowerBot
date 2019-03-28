package com.arek;

import java.io.File;
import java.util.Random;

class RandomImage {
	private  final File image = pickRandomImage();

	 private  File pickRandomImage() {
		final File dir = new File("./img");
		File[] images = dir.listFiles();
		Random r = new Random();
		return images[r.nextInt(images.length)];
	}

	 File getImage() {
		return image;
	}
}
