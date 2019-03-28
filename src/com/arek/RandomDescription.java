package com.arek;

import groovy.json.internal.IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

class RandomDescription {
	private Path names = Paths.get("./wordsSrc/names");
	private Path adj = Paths.get("./wordsSrc/adj");
	private Path adv = Paths.get("./wordsSrc/adv");
	private Path nouns = Paths.get("./wordsSrc/nouns");
	private Random rand = new Random();

	String makeDescription() throws IOException{
		StringBuilder sb = new StringBuilder();
		return (sb.append("Name: ").append(makeName()).append("\n")
				.append("Nickname at Lawnmower High School: ").append(makeNickname()).toString());
	}

	private String makeName() throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(pickFrom(names)).append(pickConjunction());
		if (sb.charAt(sb.length() - 1) == ' ') sb.append(pickFrom(adv)).append(pickFrom(adj));
//		sb.append("\n");
//		sb.append(pickFrom(nouns)).append(" ").append(pickFrom(adv)).append(" ").append(pickFrom(adj));
		return sb.toString();
	}

	private String makeNickname() throws IOException{
		StringBuilder sb = new StringBuilder();

		sb.append(pickFrom(adj)).append(pickFrom(nouns));
		return sb.toString();
	}

	private String pickFrom(Path path) throws IOException {
		Path names = path;
		List<String> namesList = Files.readAllLines(names);
		return namesList.get(rand.nextInt(namesList.size()));
	}

	private String pickConjunction() {
		String[] conjArray = {"", " the ", " the ", " the "};
		return conjArray[rand.nextInt(3)];
	}
}
