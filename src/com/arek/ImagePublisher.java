package com.arek;

import com.restfb.*;
import com.restfb.types.GraphResponse;
import com.restfb.types.Page;

import java.io.File;
import java.nio.file.Files;
import java.util.Random;

class ImagePublisher {

	private static String _TOKEN = "EAACVS6jUj0QBAJu4lZAz4YI8l8dek5KNZAMyZAvLBPA7ZAeilQhG7xPGI5WgwNRr91y5DEJm4xCS4yZBX4OIZBh7fFWYbSCGOxUmNGMBjmjAaVGNCEZApEL0CZBXFJWWwmRjnNdQuBZBaSPhDZCZAOXrEswim4ZBS76gLLYvDeoVZCVFo5QZDZD";
	private static String _PAGEID = "KosiarkaBot";

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
