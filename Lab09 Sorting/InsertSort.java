import java.util.*;

public class InsertSort {
	
	static <E extends Comparable<E>> void insertionSort(List<E> list) {
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

	public static void main(String[] args) {
		// ArrayList<> implementation
		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4}; 
		List<Integer> arr = new ArrayList<>(Arrays.asList(tmp));
		arr = Arrays.asList(tmp);

		String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		List<String> arr2 = new ArrayList<>(Arrays.asList(temp));

		System.out.println(arr.toString());
		InsertSort.insertionSort(arr);
		System.out.println(arr.toString());

		System.out.println("\n" + arr2.toString());
		InsertSort.insertionSort(arr2);
		System.out.println(arr2.toString());
	}
}