package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		RandomImage randomImage = new RandomImage();
		RandomDescription randomDescription = new RandomDescription();
		ImagePublisher imagePublisher = new ImagePublisher();

		imagePublisher.publishImage(randomImage.getImage(), randomDescription.makeDescription());
//		for (int i = 0; i < 10; i++) {
//		System.out.println(randomDescription.makeDescription()+"\n"+
//				"==================================");

	}
}

