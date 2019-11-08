import java.util.*;

public class NumericFamilyMaps {

	// instance vars
	// Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	// constructor
	public NumericFamilyMaps() {

	}

	public static void main(String[] args) {
		// put instance var here for testing shenanigans
		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

		// feed dummy data to map
		// word-families (keys) are based on number of characters in word.
		String[] strs = { "Wow", "this", "is", "an", "assignment"};
		for (String str : strs) {

			ArrayList<String> familyArr;
			if (!map.containsKey(str.length())){
				familyArr = new ArrayList<String>();
				familyArr.add(str);
			}
			else { 
				familyArr = map.get(str.length());
				familyArr.add(str);
			}

			map.put(str.length(), familyArr);
		}

		System.out.println(map.keySet());
		System.out.println(map.entrySet());
	}

}