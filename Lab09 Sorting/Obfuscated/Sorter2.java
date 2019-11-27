import java.util.*;

public class Sorter2 {

	private Long swapCount;
	private Long compCount;
	Sorter2() { 
		swapCount = (long) 0; 
		compCount = (long) 0;
	}

	<E extends Comparable<E>> void swap(List<E> list, int i, int j) {
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);

		swapCount++;
	}

	<E extends Comparable<E>> Long[] sort(List<E> list) {
		int gap = list.size() / 2;
		while (gap > 0) {
			// System.out.println("\ngap is:" + gap);
			for (int i = gap; i < list.size(); i++) {
				int nextPos = i;
				while (nextPos >= gap && list.get(nextPos-gap).compareTo(list.get(nextPos)) > 0) {
					swap(list, nextPos, nextPos-gap);   	// System.out.println("Swap Indices:" + (nextPos-gap) + "-" +  nextPos + " of Values: " );
													 		// System.out.println("{0, 1, 2, 3, 4, 5, 6, 7}" + "\n" + list.toString());
					nextPos -= gap;
				}
			}
			if (gap == 2) gap = 1;
			else gap = (int)(gap/2.2);
		}
		Long[] counts = {swapCount, compCount};
		return counts;
	}

	public static void main(String[] args) {
		Sorter2 sortVar = new Sorter2();

		Integer[] tmp = {7, 6, 5, 4, 3, 2, 1, 0 };  // {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; (Test data for Shellsort-Gap logic)
		List<Integer> integerList = new ArrayList<>();
		integerList = Arrays.asList(tmp);

		// String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		// List<String> stringList = new ArrayList<>(Arrays.asList(temp));

		System.out.println(integerList.toString());
		Long[] staticSwap = sortVar.sort(integerList);
		System.out.println(integerList.toString());

		System.out.println("numSwaps is:" + staticSwap);

		// System.out.println(stringList.toString());
		// sortVar.sort(stringList);
		// System.out.println(stringList.toString());
	} 
}