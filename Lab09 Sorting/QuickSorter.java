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

	static <E extends Comparable<E>> boolean quickSort(List<E> list, int first, int last) {
		// Recursion: base case
		if (last-first == 0 || last-first == 1) return true;

		// Partitioning: Take Median of {first, middle, last} as pivot, then swap pivot into first
		int middle = (last-first)/2 + first;
		List<E> medianList = new ArrayList<>(); 
		medianList.add(list.get(first)); medianList.add(list.get(middle)); medianList.add(list.get(last));
		sortMedian(medianList);
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
		int pivot = first;
		// place Pivot in it's correct position. Then recursivly sort subarrays on either side of it.
		int up = first;
		int down = last;
		do {
			if (up != last || list.get(pivot).compareTo(list.get(up)) <= 0) { up++; }
			if (down != first || list.get(pivot).compareTo(list.get(down)) > 0) { down--; }
			System.out.println("Up:" + up + " Down:" + down);
			if (up < down) {
				E tmp = list.get(up);
				list.set(up, list.get(down));
				list.set(down, tmp);
			}
		} while (up < down);
		E tmp = list.get(first);
		list.set(first, list.get(down));
		list.set(down, tmp);

		pivot = down;
		return quickSort(list, first, pivot-1) && quickSort(list, pivot+1, last);

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