import java.util.*;

public class Sorter1 {
	
	static <E extends Comparable<E>> void sort(List<E> list) {
		for (int i = 1; i < list.size(); i++) {
			int j = i;
			while (j > 0 && list.get(j-1).compareTo(list.get(j)) > 0) {
				E tmp = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1, tmp);
				j--;
			}
			// System.out.println(list.subList(0, i+1).toString()); // intermediate output, currently sorted subarrs 
		}
	}

	public static void main(String[] args) {
		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4}; 
		List<Integer> integerList = new ArrayList<>();
		integerList = Arrays.asList(tmp);

		String[] temp = {"these", "are", "a", "few", "strings", "to", "sort"};
		List<String> stringList = new ArrayList<>(Arrays.asList(temp));

		System.out.println(integerList.toString());
		Sorter1.sort(integerList);
		System.out.println(integerList.toString());

		System.out.println(stringList.toString());
		Sorter1.sort(stringList);
		System.out.println(stringList.toString());
	}
}