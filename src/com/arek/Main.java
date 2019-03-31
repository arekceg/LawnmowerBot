package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		RandomDescription randomDescription = new RandomDescription();
		RandomImage randomImage = new RandomImage();
		ImagePublisher imagePublisher = new ImagePublisher();

		imagePublisher.publishImage(randomImage.pickRandomImage(), randomDescription.makeDescription());

////    UNCOMMENT FOR NAME TESTING:
//		for (int i = 0; i < 10; i++) {
//		System.out.println(randomDescription.makeDescription()+"\n"+
//				"==================================");

	}
}

