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
		System.out.println("");
		System.out.println(map.entrySet());
		
		ArrayList<String> tmp = map.get(length);
		map = new HashMap<Integer, ArrayList<String>>();
		map.put(length, tmp);

		System.out.println(map.entrySet());
	}

	public void updateFam(Character c) {
		System.out.println(map.entrySet());

		Map.Entry<Integer, ArrayList<String>> entry = map.entrySet().iterator().next();
		ArrayList<String> tmp = entry.getValue();
			// ehhh getting by the "only entry in map" logic ONLY works for the first round......
			// I need to get a better split
		System.out.println(tmp.toString());

		// grabs each entry in map, see above note for why (possibly) necessary.
			/*
			for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
				System.out.println(entry);
			}
			*/
		
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