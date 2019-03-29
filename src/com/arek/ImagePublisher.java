package com.arek;

import com.restfb.*;
import com.restfb.types.GraphResponse;
import com.restfb.types.Page;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class ImagePublisher {

	private String _TOKEN = get_TOKEN();
	private String _PAGEID = get_PAGEID();

	private FacebookClient fbClient = new DefaultFacebookClient(_TOKEN, Version.LATEST);
	Page page = fbClient.fetchObject(_PAGEID, Page.class);

	void publishImage(File image, String description) throws Exception {
		GraphResponse imagePublishedResponse =
				fbClient.publish(_PAGEID + "/photos", GraphResponse.class,
						BinaryAttachment.with(image.getName(), Files.readAllBytes((image.toPath()))),
						Parameter.with("message", description));
		System.out.println("Image published.\n" +
				"ID: " + imagePublishedResponse.getId());
	}


	private String get_PAGEID() {
		Path pageidPath = Paths.get("pageid");
		try {
			return (Files.readAllLines(pageidPath).get(0));
		} catch (IOException e) {
			System.out.println("Error reading pageid file");
			e.printStackTrace();
		}
		return null;
	}
	private String get_TOKEN() {
		Path tokenPath = Paths.get("token");
		try {
			return (Files.readAllLines(tokenPath).get(0));
		} catch (IOException e) {
			System.out.println("Error reading token file");
			e.printStackTrace();
		}
		return null;
	}
}
