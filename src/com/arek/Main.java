package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		RandomDescriptionGenerator randomDescriptionGenerator = new RandomDescriptionGenerator();
		RandomImageGenerator randomImageGenerator = new RandomImageGenerator();
		ImagePublisher imagePublisher = new ImagePublisher();

		imagePublisher.publishImage(randomImageGenerator.pickRandomImage(), randomDescriptionGenerator.makeDescription());
	}

}

