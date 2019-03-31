package com.arek;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Random;

class RandomImage {
	private String currentDirectory;
	{
		try {
			currentDirectory = new File(ImagePublisher.class.getProtectionDomain().getCodeSource().getLocation()
					.toURI()).getParentFile().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	File pickRandomImage() {
		File[] images = new File(currentDirectory + "/img").listFiles();
		Random r = new Random();
		return images[r.nextInt(images.length)];
	}

}
