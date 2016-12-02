import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Zadatak02 {

	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();

		fillList(arrayList);
		fillList(linkedList);
		System.out.println("ArrayList - iterator: " + getTimeOfIteration(arrayList) + " ms");
		System.out.println("LinkedList - iterator: " + getTimeOfIteration(linkedList) + " ms");
		System.out.println("ArrayList - get(index): " + getTimeOfGetIndex(arrayList) + " ms");
		System.out.println("LinkedList - get(index): " + getTimeOfGetIndex(linkedList) + " ms");

	}

	public static void fillList(List<Integer> list) {
		for (int i = 0; i < 50000; i++) {
			Integer num = (int) (Math.random() * 10000);
			list.add(num);
		}
	}

	public static long getTimeOfIteration(List<Integer> list) {
		long start = System.currentTimeMillis();
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			iterator.next();

		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}

	public static long getTimeOfGetIndex(List<Integer> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}

}
