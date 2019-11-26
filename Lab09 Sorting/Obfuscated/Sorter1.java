import java.util.*;

public class Sorter1 {
	
	private Long swapCount;
	Sorter1() { swapCount = (long) 0; }

	<E extends Comparable<E>> void swap(List<E> list, int i, int j) {
		E tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);

		swapCount++;
	}	

	<E extends Comparable<E>> Long sort(List<E> list) {
		for (int i = 1; i < list.size(); i++) {
			int j = i;
			while (j > 0 && list.get(j-1).compareTo(list.get(j)) > 0) {
				swap(list, j, j-1);
				j--;
			}
			System.out.println(list.subList(0, i+1).toString() + "swaps: " + swapCount); // intermediate output, currently sorted subarrs 
		}
		return swapCount;
	}

	public static void main(String[] args) {
		Sorter1 sortVar = new Sorter1();

		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4}; 
		List<Integer> integerList = new ArrayList<>();
		integerList = Arrays.asList(tmp);

		// String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		// List<String> stringList = new ArrayList<>(Arrays.asList(temp));

		System.out.println(integerList.toString());
		Long staticSwap = sortVar.sort(integerList);
		System.out.println(integerList.toString());

		System.out.println("numSwaps is:" + staticSwap);

		// System.out.println(stringList.toString());
		// sortVar.sort(stringList);
		// System.out.println(stringList.toString());
	}
}