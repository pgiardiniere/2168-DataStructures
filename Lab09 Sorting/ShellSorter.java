import java.util.*;

public class ShellSorter {

	static <E extends Comparable<E>> void shellSort(List<E> list) {
		int gap = list.size() / 2;
		while (gap > 0) {
			// System.out.println("\ngap is:" + gap);
			for (int i = gap; i < list.size(); i++) {
				int nextPos = i;
				E nextVal = list.get(nextPos);
				while (nextPos >= gap && list.get(nextPos-gap).compareTo(list.get(nextPos)) > 0) {
					list.set(nextPos, list.get(nextPos-gap));   // System.out.println("Swap Indices:" + (nextPos-gap) + "-" +  nextPos + " of Values: " );
					list.set(nextPos-gap, nextVal); 			// System.out.println("{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}" + "\n" + list.toString());
					nextPos -= gap;
				}
			}
			if (gap == 2) gap = 1;
			else gap = (int)(gap/2.2);
		}
	}

	public static void main(String[] args) {
		Integer[] tmp =  {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		List<Integer> integerList = new ArrayList<>();
		integerList = Arrays.asList(tmp);

		String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		List<String> stringList = new ArrayList<>(Arrays.asList(temp));

		System.out.println(integerList.toString());
		ShellSorter.shellSort(integerList);
		System.out.println(integerList.toString());

		System.out.println(stringList.toString());
		ShellSorter.shellSort(stringList);
		System.out.println(stringList.toString());
	} 
}