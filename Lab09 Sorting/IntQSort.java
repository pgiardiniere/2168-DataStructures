import java.util.*;

public class IntQSort {

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low-1); 	// i := index of smaller element
		for (int j = high; j > i; j--) { // j := index of higher element
			if (arr[j] < pivot) {
				i++;
				System.out.println("i:=" + i + "j:=" + j);
				// swap arr[i] into arr[j]
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				for (int ind = 0; ind < arr.length; ind++) System.out.print(arr[ind] + ", "); System.out.println();
			}
		}
		int tmp = arr[low];
		arr[low] = arr[pivot];	// pivot == high
		arr[pivot] = tmp;

		return 42;
	}

	void sort() {

	}

	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5, 6, 7, 8};
		
		for (int i = 0; i < ar.length; i++) System.out.print(ar[i] + ", "); System.out.println();
		IntQSort.partition(ar, 0, ar.length-1);
		for (int i = 0; i < ar.length; i++) System.out.print(ar[i] + ", "); System.out.println();
	}
}