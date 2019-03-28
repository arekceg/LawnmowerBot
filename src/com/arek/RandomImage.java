package com.arek;

import java.io.File;
import java.util.Random;

class RandomImage {
	private  final File image = pickRandomImage();

	 private  File pickRandomImage() {
		File[] images = new File("./img").listFiles();
		Random r = new Random();
		return images[r.nextInt(images.length)];
	}

	 File getImage() {
		return image;
	}
}
