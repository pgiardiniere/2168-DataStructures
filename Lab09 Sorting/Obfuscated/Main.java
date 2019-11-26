import java.util.*;

public class Main {

	public static void main(String[] args) {
		// ---------------------------------------------------------------------------
		// Make list of 100 elements, randomly generated Doubles. Run & Output tests
		// ---------------------------------------------------------------------------
		Sorter1 sortVar1 = new Sorter1();
		Sorter2 sortVar2 = new Sorter2();
		Sorter3 sortVar3 = new Sorter3();

		List<Double> hundred = new ArrayList<>();
		for (int i = 0; i < 100; i++) { hundred.add(Math.random()); }

		// Make 3 full-copies to sort, ensures 1-to-1 execution/swap comparisons
		List<Double> list1 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list1.add(hundred.get(i)); }
		List<Double> list2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list2.add(hundred.get(i)); }
		List<Double> list3 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list3.add(hundred.get(i)); }

		long initTime;
		long postTime;
		long numSwaps;

		initTime = System.nanoTime();
		numSwaps = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\nSort1 --- hundred elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- hundred elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- hundred elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		// ---------------------------------------------------------------------------
		// Make list of 1000 elements, randomly generated Doubles. Run & Output tests
		// ---------------------------------------------------------------------------
		sortVar1 = new Sorter1();
		sortVar2 = new Sorter2();
		sortVar3 = new Sorter3();

		List<Double> thousand = new ArrayList<>();
		for (int i = 0; i < 1000; i++) { thousand.add(Math.random()); }

		// Make 3 full-copies to sort, ensures 1-to-1 execution/swap comparisons
		list1 = new ArrayList<>();
		for (int i = 0; i < 1000; i++) { list1.add(thousand.get(i)); }
		list2 = new ArrayList<>();
		for (int i = 0; i < 1000; i++) { list2.add(thousand.get(i)); }
		list3 = new ArrayList<>();
		for (int i = 0; i < 1000; i++) { list3.add(thousand.get(i)); }

		initTime = System.nanoTime();
		numSwaps = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\n--------------------------------------------------");
		System.out.println("\nSort1 --- thousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- thousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- thousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		// ---------------------------------------------------------------------------
		// Make list of 10000 elements, randomly generated Doubles. Run & Output tests
		// ---------------------------------------------------------------------------
		sortVar1 = new Sorter1();
		sortVar2 = new Sorter2();
		sortVar3 = new Sorter3();

		List<Double> tenThousand = new ArrayList<>();
		for (int i = 0; i < 10000; i++) { tenThousand.add(Math.random()); }

		// Make 3 full-copies to sort, ensures 1-to-1 execution/swap comparisons
		list1 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) { list1.add(tenThousand.get(i)); }
		list2 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) { list2.add(tenThousand.get(i)); }
		list3 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) { list3.add(tenThousand.get(i)); }

		initTime = System.nanoTime();
		numSwaps = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\n--------------------------------------------------");
		System.out.println("\nSort1 --- tenThousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- tenThousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);

		initTime = System.nanoTime();
		numSwaps = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- tenThousand elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + numSwaps);
	}
}