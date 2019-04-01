package com.arek;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

class RandomDescriptionGenerator {
	private String currentDirectory;
	{
		try {
			currentDirectory = new File(ImagePublisher.class.getProtectionDomain().getCodeSource().getLocation()
					.toURI()).getParentFile().getParentFile().getParentFile().getParentFile().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	private Path names = Paths.get(currentDirectory + "/wordsSrc/names");
	private Path adj = Paths.get(currentDirectory + "/wordsSrc/adj");
	private Path adv = Paths.get(currentDirectory + "/wordsSrc/adv");
	private Path nouns = Paths.get(currentDirectory + "/wordsSrc/nouns");
	private Random rand = new Random();

	String makeDescription() throws IOException {
		return ("Name: " + makeName() + "\n" +
				"Nickname in High School: " + makeNickname());
	}

	private String makeName() throws IOException {
		return pickFrom(names) + makeNameSuffix();
	}

	private String makeNameSuffix() throws IOException{
		if(Math.random()<0.5) return "";
		else if(Math.random()<0.5) return " the " + pickFrom(adj);
		else return " the " + pickFrom(adv) + pickFrom(adj);
	}

	private String makeNickname() throws IOException {
		StringBuilder sb = new StringBuilder();
		double chance = Math.random();

		if(chance <= 0.3) sb.append(pickFrom(adj)).append(pickFrom(nouns));
		else if(chance <=0.7) sb.append(pickFrom(adj));
		else sb.append (pickFrom(nouns));

		return sb.toString();
	}

	private String pickFrom(Path path) throws IOException {
		List<String> namesList = Files.readAllLines(path);
		return namesList.get(rand.nextInt(namesList.size()));
	}
}
