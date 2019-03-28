package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		ImagePublisher imagePublisher = new ImagePublisher();
		imagePublisher.publishImage(RandomImage.getImage(), RandomDescription.makeDescription());
//		System.out.println(RandomDescription.makeDescription());
	}
}
