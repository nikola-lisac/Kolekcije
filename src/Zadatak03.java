import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Zadatak03 {

	public static void main(String[] args) {
		String file = "Files\\nightfall.txt";
		int numOfLines = getNumOfLineInFile(file);
		List<String> lines = new ArrayList<>(numOfLines);
		int numOfLinesToPrint = 7;
		addAllLinesToTheList(lines, file);
		for (int i = 0; i < numOfLinesToPrint; i++) {
			System.out.println(lines.get((int)(Math.random() * lines.size())));
		}
	}

	public static void addAllLinesToTheList(List<String> list, String fileName) {
		try (BufferedReader read = Files.newBufferedReader(Paths.get(fileName))) {
			String line;
			while ((line = read.readLine()) != null) {
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getNumOfLineInFile(String fileName) {
		int count = 0;
		try (BufferedReader read = Files.newBufferedReader(Paths.get(fileName))) {
			String line;
			while ((line = read.readLine()) != null) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}
