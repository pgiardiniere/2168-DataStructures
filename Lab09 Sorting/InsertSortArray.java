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

	public static void main(String[] args) {
		// ArrayList<> implementation
		Integer[] tmp =  {0, 3, 2, 1, 55, 32, 4}; // {0, 1, 2, 3};
		List<Integer> arr = new ArrayList<>(Arrays.asList(tmp));
		
		InsertSortArray.ArrayListSort(arr);
	}
}