import java.util.*;

public class QuickSorter {

	static <E extends Comparable<E>> void swap(List<E> list, int i, int j) {
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

	static <E extends Comparable<E>>void quickSort(List<E> list, int left, int right) {
		int pivIndex = partition(list, left, right);
		if (left < pivIndex - 1) {
			quickSort(list, left, pivIndex - 1);
		}
		if (pivIndex < right) {
			quickSort(list, pivIndex, right);
		}
	}

	static <E extends Comparable<E>> int partition(List<E> list, int left, int right) {
		E pivot = list.get((left + right)/2); 	// assign pivot val, taking index @ midpoint (so, random/arbitrary value)
		while (left <= right) {
			while (list.get(left).compareTo(pivot)  < 0) left++; 	// get (index of el on left) : (val @ index > pivot val)
			while (list.get(right).compareTo(pivot) > 0) right--; 	// get (index of el on righ) : (val @ index < pivot val)
			if (left <= right) { 									// Swap those two indices			
				swap(list, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		Integer[] tmp = {13, 22, 3, 4, 4, 99, 100, 23, 3, 5, 7, 8, 9, 10, 0}; 		// {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		List<Integer> list = Arrays.asList(tmp);
		
		// System.out.println(list.toString());
		for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", "); System.out.println();
		QuickSorter.quickSort(list, 0, list.size()-1);
		for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", "); System.out.println();
	}
}