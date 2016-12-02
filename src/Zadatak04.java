import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Zadatak04 {
	static Map<String, String> adresar = new HashMap<>();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		adresar.put("065155127", "Nikola Lisicic");
		adresar.put("065225883", "Ensar Bavrk");
		adresar.put("065111222", "Cvijetin Petrovic");

		while (true) {
			System.out.println("Unesi 1 za unos novog korisnika");
			System.out.println("Unesi 2 za ispis korisnika korisnika");

			int choice = input.nextInt();
			if (choice == 1) {
				input.nextLine();
				addNewUser();
			} else if (choice == 2) {
				printAdresar();
			} else {
				System.out.println("Nepostojeca opcija.");
				break;
			}

		}
	}

	private static void printAdresar() {
		List<Map.Entry<String, String>> list = new LinkedList<>(adresar.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareToIgnoreCase(o2.getValue());
			}

		});

		for (Map.Entry<String, String> entry : list) {
			System.out.println(entry.getValue() + " : " + entry.getKey());
		}
	}

	private static void addNewUser() {
		System.out.println("Unesi ime i prezime covjeka: ");
		String name = input.nextLine();
		System.out.println("Unesi covjekov broj telefona: ");
		String number = input.nextLine();

		if (!adresar.containsKey(number)) {
			adresar.put(number, name);
		} else {
			System.out.println("Taj broj telefona vec postoji!");
		}
	}

}
