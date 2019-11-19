import java.util.*;

public class InsertSortArray {
	
	public InsertSortArray() {}

	public int[] PrimitiveIntSort(int[] ints) {
		int[] tmp = new int[ints.length];
		for (int i : ints) {  }
		return null;
	}

	public static List<Integer> ArrayListSort(List<Integer> list) {
		List<Integer> sorted = new ArrayList<Integer>(list.size());

		if (list.size() == 0) return null;
		else sorted.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			for (int j = sorted.size()-1; j > -1; j--) {
				if (list.get(i) >= sorted.get(j)) { 
					sorted.add(j, list.get(i)); 
					System.out.println(sorted.toString()); 
					break;
				}
			} 
		}
		return sorted;
	}

	public static List<Integer> insertSort(List<Integer> list) {
		List<Integer> sorted = new ArrayList<Integer>(list.size());
		if (list.size() == 0) return null;
		else sorted.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			for (int j = sorted.size(); j > -1; j--) {
				sorted.add(list.get(i));
				System.out.println(list.get(i) + " " + sorted.toString());
				if (list.get(i) < sorted.get(j)) {
					Integer tmp = sorted.get(j);
					sorted.set(j, sorted.get(j-1));
					sorted.set(j-1, tmp);
				}
			}
		}
		return sorted;
	}

	// need: 2 indeces. Recall: insertSort is IN-PLACE sorting algo
	static void sort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i-1) > list.get(i)) {
				while (list.get(i-1) > list.get(i) && i != 0) {
					Integer tmp = list.get(i);
					list.set(i, list.get(i-1));
					list.set(i-1, tmp);
					i--;
				}	
			}
		}
	}

	public static void main(String[] args) {
		// ArrayList<> implementation
		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4}; 
		List<Integer> arr = new ArrayList<>(Arrays.asList(tmp));
		
		System.out.println(arr.toString());
		InsertSortArray.sort(arr);
		System.out.println(arr.toString());
	}
}