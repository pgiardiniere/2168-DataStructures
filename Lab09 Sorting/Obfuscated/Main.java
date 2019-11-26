import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Sorter1 sortVar1 = new Sorter1();
		Sorter2 sortVar2 = new Sorter2();
		Sorter3 sortVar3 = new Sorter3();

		// Lists of 100 elements, randomly generated Doubles
		List<Double> list1 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list1.add(Math.random()); }
		List<Double> list2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list2.add(Math.random()); }
		List<Double> list3 = new ArrayList<>();
		for (int i = 0; i < 100; i++) { list3.add(Math.random()); }

		// Lists of 1000 elements, randomly generated Doubles


		// Lists of 10,000  elements, randomly generated Doubles

		System.out.println("time to sort in nanoseconds: Initial time, PostTime, & Difference");
		long initTime;
		long postTime;
		
		initTime = System.nanoTime();
		sortVar1.sort(list1);
		postTime = System.nanoTime();
		
		System.out.println(initTime);
		System.out.println(postTime);
		System.out.println(postTime - initTime);


		// for (Double dub : list1) { System.out.println(dub); } System.out.println();
		// System.out.println(list1 + "\n");
		sortVar2.sort(list2);
		// System.out.println(list2 + "\n");
		sortVar3.sort(list3);
		// System.out.println(list3 + "\n");







	}
}