import java.util.*;

public class RandQuickSort {

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		if (index < right) {
			quickSort(arr, index, right);
		}
	}

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2]; // assign pivot val, taking index @ midpoint
		while (left <= right) {
			while (arr[left] < pivot) left++; 		// get (index of el on left) : (val @ index > pivot val)
			while (arr[right] > pivot) right--; 	// get (index of el on righ) : (val @ index < pivot val)
			if (left <= right) { 					// Swap those two indices
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] tmp =  {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

		for (int i = 0; i < tmp.length; i++) System.out.print(tmp[i] + ", "); System.out.println();
		RandQuickSort.quickSort(tmp, 0, tmp.length-1);
		for (int i = 0; i < tmp.length; i++) System.out.print(tmp[i] + ", "); System.out.println();
	}
}