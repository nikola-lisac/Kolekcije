import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Zadatak01 {
	public static void main(String[] args) {
		String file = "Files\\nightfall.txt";
		List<String> allWordsWithDuplicates = readFileDuplicateWords(file);
		System.out.println("With duplicates: \n");
		for (String word : allWordsWithDuplicates) {
			System.out.println(word);
		}

		Set<String> allUniqueWords = readFileUniqueWords(file);
		System.out.println("Without duplicates: \n");
		for (String word : allUniqueWords) {
			System.out.println(word);
		}

	}

	public static List<String> readFileDuplicateWords(String filePath) {
		List<String> words = new ArrayList<String>();
		try (BufferedReader read = Files.newBufferedReader(Paths.get(filePath))) {
			String line;
			while ((line = read.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z]", " ");
				words.addAll(Arrays.asList(line.trim().split("\\s+")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(words);
		return words;
	}

	public static Set<String> readFileUniqueWords(String filePath) {
		Set<String> words = new TreeSet<String>();
		try (BufferedReader read = Files.newBufferedReader(Paths.get(filePath))) {
			String line;
			while ((line = read.readLine()) != null) {
				line = line.replaceAll("[^a-zA-Z]", " ");
				words.addAll(Arrays.asList(line.trim().split("\\s+")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words;
	}
}
