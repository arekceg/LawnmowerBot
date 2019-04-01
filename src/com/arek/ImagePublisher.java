package com.arek;

import com.restfb.*;
import com.restfb.types.GraphResponse;

import java.io.File;
import java.nio.file.Files;

class ImagePublisher {
	private final String _TOKEN = System.getenv("TOKEN");
	private final String _PAGEID = System.getenv("PAGEID_LAWN");

	private FacebookClient fbClient = new DefaultFacebookClient(_TOKEN, Version.LATEST);

	void publishImage(File image, String description) throws Exception {
		GraphResponse imagePublishedResponse =
				fbClient.publish(_PAGEID + "/photos", GraphResponse.class,
						BinaryAttachment.with(image.getName(), Files.readAllBytes((image.toPath()))),
						Parameter.with("message", description));
		System.out.println("Image published.\n" +
				"ID: " + imagePublishedResponse.getId());
	}
}
