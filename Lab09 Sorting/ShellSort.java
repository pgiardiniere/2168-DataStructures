import java.util.*;

public class ShellSort {

	static <E extends Comparable<E>> void ShellSorter(List<E> list) {
		int interval = list.size() / 2;
		while (interval > 0) {
			System.out.println(list.toString());
			System.out.println("The gap is " + interval);

			int j = interval;
			while (j > 0 && list.get(j).compareTo(list.get(j-interval)) > 0) {
				E tmp = list.get(j);
				list.set(j, list.get(j-interval));
				list.set(j-interval, tmp);
				j -= interval;
			}
			if (interval == 2) interval = 1;
			else interval = (int)(interval/2.2);
		}
	}

	public static void main(String[] args) {
		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4, 7}; 
		List<Integer> arr = new ArrayList<>(Arrays.asList(tmp));
		arr = Arrays.asList(tmp);

		String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		List<String> arr2 = new ArrayList<>(Arrays.asList(temp));

		// System.out.println(arr.toString());
		ShellSort.ShellSorter(arr);
		System.out.println(arr.toString());
	} 
}