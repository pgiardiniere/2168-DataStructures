import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 't' for terminal output. Else, output to CSV by default");
		if (in.nextLine().equals("t"))
			terminalOut();
		else 
			csvOut();
	}

	static void terminalOut() {
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
		Long[] counts;

		initTime = System.nanoTime();
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\nSort1 --- 100 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- 100 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- 100 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

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
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\n--------------------------------------------------");
		System.out.println("\nSort1 --- 1000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- 1000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- 1000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

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
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("\n--------------------------------------------------");
		System.out.println("\nSort1 --- 10,000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("\nSort2 --- 10,000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("\nSort3 --- 10,000 elements");
		System.out.println("    time to sort in nanoseconds:\n        " + (postTime - initTime));
		System.out.println("    numSwaps is:\n        " + counts[0]);
		System.out.println("    numComps is:\n        " + counts[1]);
	}

	static void csvOut() throws FileNotFoundException {
		PrintStream out = new PrintStream(new File("out.csv"));
		System.setOut(out);
		System.out.println("Datapoints: below each \"Sort X results:\", First row is time to sort in nanoseconds. Second row is counts {Swaps ; Comparisons} \n");

		// ---------------------------------------------------------------------------
		// Make list of 100 elements, randomly generated Doubles. Run & Output tests
		// ---------------------------------------------------------------------------
		Sorter1 sortVar1 = new Sorter1();
		Sorter2 sortVar2 = new Sorter2();
		Sorter3 sortVar3 = new Sorter3();

		List<Double> hundred = new ArrayList<>();
		for (int i = 0; i < 100; i++) { hundred.add(Math.random()); }

		System.out.println("100 element list");
		// Make 3 full-copies to sort, ensures 1-to-1 execution/swap comparisons
		List<Double> list1 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list1.add(hundred.get(i)); }
		List<Double> list2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list2.add(hundred.get(i)); }
		List<Double> list3 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list3.add(hundred.get(i)); }

		long initTime;
		long postTime;
		Long[] counts;

		initTime = System.nanoTime();
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("Sort 1 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("Sort 2 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("Sort 3 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		System.out.println("1000 element list");
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
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("Sort 1 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("Sort 2 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("Sort 3 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		System.out.println("10000 element list");
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
		counts = sortVar1.sort(list1);
		postTime = System.nanoTime();

		System.out.println("Sort 1 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar2.sort(list2);
		postTime = System.nanoTime();

		System.out.println("Sort 2 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);

		initTime = System.nanoTime();
		counts = sortVar3.sort(list3);
		postTime = System.nanoTime();

		System.out.println("Sort 3 results:");
		System.out.println(postTime - initTime);
		System.out.println(counts[0] + "," + counts[1]);
	}
}