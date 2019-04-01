package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		RandomDescriptionGenerator randomDescriptionGenerator = new RandomDescriptionGenerator();
		RandomImageGenerator randomImageGenerator = new RandomImageGenerator();
		ImagePublisher imagePublisher = new ImagePublisher();

		imagePublisher.publishImage(randomImageGenerator.pickRandomImage(), randomDescriptionGenerator.makeDescription());

//		System.out.println(System.getenv("PAGEID_LAWN"));
////    UNCOMMENT FOR NAME TESTING:
//		for (int i = 0; i < 10; i++) {
//		System.out.println(randomDescriptionGenerator.makeDescription()+"\n"+
//				"==================================");

	}
}

