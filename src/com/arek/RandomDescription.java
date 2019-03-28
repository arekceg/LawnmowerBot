package com.arek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

class RandomDescription {
	private static Random rand = new Random();
//	private String description = makeDescription();

	static String makeDescription() throws IOException {
		StringBuilder sb = new StringBuilder();
		Path names = Paths.get("./nazwy/names");
		Path adj = Paths.get("./nazwy/adj");
		Path adv = Paths.get("./nazwy/adv");
		Path nouns = Paths.get("./nazwy/nouns");

		sb.append(pickFrom(names)).append(pickConjunction());
		if(sb.charAt(sb.length()-1)==' ') sb.append(pickFrom(adv)).append(" ").append(pickFrom(adj));
//		sb.append("\n");
//		sb.append(pickFrom(nouns)).append(" ").append(pickFrom(adv)).append(" ").append(pickFrom(adj));
		return sb.toString();
	}

	static String pickFrom(Path path) throws IOException{
		Path names = path;
		List<String> namesList = Files.readAllLines(names);
		return namesList.get(rand.nextInt(namesList.size()));
	}

	static String pickConjunction() {
		String[] conjArray = {"", " the ", " the ", " the "};
		return conjArray[rand.nextInt(3)];
	}
}
