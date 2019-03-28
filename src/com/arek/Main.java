package com.arek;

public class Main {
	public static void main(String[] args) throws Exception {
		ImagePublisher imagePublisher = new ImagePublisher();
		imagePublisher.publishImage(RandomImage.getImage());
	}
}
