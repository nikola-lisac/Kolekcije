import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Zadatak05 {

	static Scanner input = new Scanner(System.in);
	static Map<String, String> countriesAndCities = new HashMap<>();
	static List<Map.Entry<String, String>> listOfCountriesAndCities;
	private static String recordsFilePath = "Files\\records.txt";

	public static void main(String[] args) {
		fillMap();
		System.out.println("Unesite ime: ");
		String name = input.nextLine();
		printLastResult(name);
		System.out.println("Koliko zelite pitanja: ");
		int numOfQuestions = input.nextInt();
		int numOfCorrect = 0;
		input.nextLine();
		for (int i = 0; i < numOfQuestions; i++) {
			Map.Entry<String, String> entry = getQuestionSetup();
			boolean correct = askQuestion(entry);
			if (correct) {
				numOfCorrect++;
			}
		}

		System.out.println("Imali ste " + numOfCorrect + " tacnih odgovora.");
		printToFile(name, numOfCorrect, numOfQuestions);

	}

	public static void fillMap() {
		String path = "Files\\countries.txt";

		try (BufferedReader read = Files.newBufferedReader(Paths.get(path))) {
			String line;
			while ((line = read.readLine()) != null) {
				String[] countryCity = line.split(",");
				countriesAndCities.put(countryCity[0], countryCity[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		listOfCountriesAndCities = new ArrayList<>(countriesAndCities.entrySet());
	}

	public static Map.Entry<String, String> getQuestionSetup() {
		int randomIndex = (int) (Math.random() * listOfCountriesAndCities.size());
		return listOfCountriesAndCities.get(randomIndex);

	}

	public static boolean askQuestion(Map.Entry<String, String> entry) {
		System.out.println("Koji je glavni grad drzave: " + entry.getKey());
		String answer = input.nextLine().toLowerCase();
		boolean isCorrect = entry.getValue().toLowerCase().equals(answer);
		if (isCorrect) {
			System.out.println("Tacan odgovor!");
		} else {
			System.out.println("Netacan odgovor.\nTacan odgovor je " + entry.getValue());
		}
		return isCorrect;
	}

	public static void printToFile(String name, int numOfCorrect, int numOfQuestions) {
		if (!Files.exists(Paths.get(recordsFilePath), LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createFile(Paths.get(recordsFilePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (BufferedWriter write = Files.newBufferedWriter(Paths.get(recordsFilePath), StandardOpenOption.APPEND)) {
			write.write(name + "," + numOfCorrect + "," + numOfQuestions);
			write.newLine();
		} catch (Exception e) {

		}
	}

	public static void printLastResult(String name) {
		String result = "";
		boolean isExisting = false;
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(recordsFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] record = line.split(",");
				if (record[0].equals(name)) {
					result = "Ime: " + record[0] + "\nBroj tacnih odgovora iz prethodne partije: " + record[1]
							+ "\nBroj pitanja iz prethodne partije: " + record[2];
					isExisting = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isExisting) {
			System.out.println(result);
		}
	}

}
