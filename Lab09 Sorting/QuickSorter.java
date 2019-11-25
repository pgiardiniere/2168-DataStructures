import java.util.*;

public class QuickSorter {

	static <E extends Comparable<E>> void sortMedian(List<E> list) {
		// sort medianList by way of InsertionSort
		for (int i = 1; i < list.size(); i++) {
			int j = i;
			while (j > 0 && list.get(j-1).compareTo(list.get(j)) > 0) {
				E tmp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1, tmp);
				j--;
			}
		}		
	}

	static <E extends Comparable<E>> void quickSort(List<E> list, int first, int last) {
		// Recursion: base case
		if (last-first == 0) ; //TODO: do something

		// Partitioning: Take Median of (first, middle, last), swap to Front, then begin sort
		int middle = (last-first)/2 + first;
		List<E> medianList = new ArrayList<>(); 
		medianList.add(list.get(first)); medianList.add(list.get(middle)); medianList.add(list.get(last));
		System.out.println(medianList);
		sortMedian(medianList);
		System.out.println(medianList);

		if (list.get(first).equals(medianList.get(1))) { 
			// no swap necessary
		} 
		else if (list.get(middle).equals(medianList.get(1))) {
			E temp = list.get(first);
			list.set(first, medianList.get(1));
			list.set(middle, temp);
		}
		else {
			E temp = list.get(first);
			list.set(first, medianList.get(1));
			list.set(last, temp);
		}
		System.out.println(list.get(first));
		
	}

	public static void main(String[] args) {
		Integer[] tmp =  {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		List<Integer> integerList = new ArrayList<>();
		integerList = Arrays.asList(tmp);

		String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		List<String> stringList = new ArrayList<>(Arrays.asList(temp));

		System.out.println(integerList.toString());
		QuickSorter.quickSort(integerList, 0, integerList.size()-1);
		System.out.println(integerList.toString());

		System.out.println(stringList.toString());
		QuickSorter.quickSort(stringList, 0, stringList.size()-1);
		System.out.println(stringList.toString());
	}
}