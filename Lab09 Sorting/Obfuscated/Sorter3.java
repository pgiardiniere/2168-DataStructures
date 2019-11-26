import java.util.*;

public class Sorter3 {

	private Long swapCount;
	Sorter3() { swapCount = (long) 0; }

	<E extends Comparable<E>> void swap(List<E> list, int i, int j) {
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);

		swapCount++;
	}

	<E extends Comparable<E>> void sort(List<E> list) { sort(list, 0, list.size()-1); }

	<E extends Comparable<E>> void sort(List<E> list, int left, int right) {
		int pivIndex = partition(list, left, right);
		if (left < pivIndex - 1) {
			sort(list, left, pivIndex - 1);
		}
		if (pivIndex < right) {
			sort(list, pivIndex, right);
		}
	}

	<E extends Comparable<E>> int partition(List<E> list, int left, int right) {
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
		Sorter3 sortVar = new Sorter3();

		Integer[] tmp = {13, 22, 3, 4, 4, 99, 100, 23, 3, 5, 7, 8, 9, 10, 0}; 		// {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		List<Integer> list = Arrays.asList(tmp);
		
		// System.out.println(list.toString());
		for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", "); System.out.println();
		sortVar.sort(list);
		for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + ", "); System.out.println();
	}
}