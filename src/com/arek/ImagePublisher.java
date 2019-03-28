package com.arek;

import com.restfb.*;
import com.restfb.types.GraphResponse;
import com.restfb.types.Page;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

class ImagePublisher {

	private static String _TOKEN = "EAACVS6jUj0QBAPi1ZAVc6PudfgQkZAlenY3PN17sGeDElCzUe07ZAA5nwqtXZCuxvuk2XqTpiz6YQmEnahgXrqiV4F2mrmxrifpUTHn2AqEuMuphREoBSZBJ8ZAKuatoYFehMAJnoVQsTp1Cf9Uwmke9mPeEZBiP4ZAVAXpfNK3p8gZDZD";
	private static String _PAGEID = "lawnmowerbot1";

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
}
