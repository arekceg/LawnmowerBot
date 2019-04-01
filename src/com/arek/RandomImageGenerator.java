package com.arek;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Random;

class RandomImageGenerator {
	private String currentDirectory;

	{
		try {
			currentDirectory = new File(ImagePublisher.class.getProtectionDomain().getCodeSource().getLocation()
					.toURI()).getParentFile().getParentFile().getParentFile().getParentFile().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	File pickRandomImage() {
		Random r = new Random();
//		try {
			File[] images = new File(currentDirectory + "/img").listFiles();
			return images[r.nextInt(images.length)];
//		} catch (NullPointerException e) {
//			throw new RuntimeException();
//		}
	}

}
