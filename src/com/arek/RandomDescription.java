package com.arek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;

class RandomDescription {
	private Path names = Paths.get("./wordsSrc/names");
	private Path adj = Paths.get("./wordsSrc/adj");
	private Path adv = Paths.get("./wordsSrc/adv");
	private Path nouns = Paths.get("./wordsSrc/nouns");
	private Random rand = new Random();

	String makeDescription() throws IOException {
		return ("Name :" + makeName() + "\n" +
				"Nickname in High School: " + makeNickname());
	}

	private String makeName() throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append(pickFrom(names)).append(pickConjunction());
		if (sb.charAt(sb.length() - 1) == ' '){
			if(Math.random() <= 0.3) sb.append(pickFrom(adv));
			else sb.append(pickFrom(adv)).append(pickFrom(adj));
		}
		return sb.toString();
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

	private String pickConjunction() {
        StringBuilder conj = new StringBuilder();
		return(conj.append((random()<0.7 ? " the " : ""))).toString();
	}
}
