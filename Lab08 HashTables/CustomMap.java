import java.util.*;
import java.io.*;

public class CustomMap {

	Map<Integer, ArrayList<String>> map;
	ArrayList<String> famArr;

	public CustomMap() {
		map = new HashMap<Integer, ArrayList<String>>();
		famArr = new ArrayList<String>();
	}

	public void populate() {
		try { 
			Scanner scanner = new Scanner(new File("shortdict.txt")); 
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
				famArr = ( map.containsKey(str.length()) ) ? map.get(str.length()) : new ArrayList<String>();
				famArr.add(str);
				map.put(str.length(), famArr);
			}
		}
		catch (IOException e) { System.out.println(e); }
	}

	public void initialWords(Integer length) {
		while (!map.containsKey(length)) {
			System.out.println("sorry breh don't have a word of that length. try another.");
			Scanner uinput = new Scanner(System.in);
			length = Integer.parseInt(uinput.nextLine().trim());
		}
		ArrayList<String> tmp = map.get(length);
		map = new HashMap<Integer, ArrayList<String>>();
		map.put(length, tmp);
	}

	public void updateFam(Character c) {
		System.out.println(map.entrySet());

		Map.Entry<Integer, ArrayList<String>> entry = map.entrySet().iterator().next();
		ArrayList<String> tmpArr = entry.getValue();
		Integer tmpInt = entry.getKey();
		
		// re-write map with all new valid families (of matched chars) & remove existing data
		for (int i = 0; i < tmpInt; i++) {
			ArrayList<String> arr = new ArrayList<String>();
			map.put(i, arr);
		}
		map.remove(tmpInt);
		System.out.println(map.entrySet());
		
		// fill in the word families based on character (guess) input
		for (String str : tmpArr) {
			Integer matches = 0;
			for (int i = 0; i < str.length(); i++) {
				if (c == str.charAt(i)) { matches++; }
			}
			if (map.get(matches) == null) {
				ArrayList<String> tmp2 = new ArrayList<String>();
				tmp2.add(str);
				map.put(matches, tmp2);

			}
			else {
				ArrayList<String> tmp2 = map.get(matches);
				tmp2.add(str);
				map.put(matches, tmp2);
			}
		}
		System.out.println(map.entrySet());

		// The guess should now be set to the first word in the LARGEST of the families.
		// method:
		// iterate over entire map entryset, compare length of each arr, taking the greatest length arr, then the first string in the largest family.
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			// do the stuff
		}
	}

	public static void main(String[] args) {
		CustomMap hangMap = new CustomMap();
		hangMap.populate();
		
		Scanner uinput = new Scanner(System.in);
		System.out.println("ENTER LENGHT OF WORD TO PLAY WITH QUICK DO EET NOW");
		hangMap.initialWords(Integer.parseInt(uinput.nextLine().trim()));

		System.out.println("OKAY WE READY TO PLAY CHUMP. PICK A LETTER");
		hangMap.updateFam(uinput.nextLine().charAt(0));
	}
}