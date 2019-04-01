package com.arek;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

class RandomImageGenerator {
	private String currentDirectory;

	{
		try {
			currentDirectory = new File(ImagePublisher.class.getProtectionDomain().getCodeSource().getLocation()
					.toURI()).getParentFile().getParentFile().getParentFile().getParentFile().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	File pickRandomImage() {
		Random r = new Random();
		File[] images = new File(currentDirectory + "/img").listFiles();
		File randomImage = images[r.nextInt(images.length)];
		Path destPath = Paths.get(currentDirectory+"/img/used/"+ randomImage.getName());
		try {
			return (Files.move(randomImage.toPath(), destPath)).toFile();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}


	}

}
