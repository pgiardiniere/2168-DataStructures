import java.util.*;
import java.io.*;

public class CustomMap {

	Map<Integer, ArrayList<String>> map;
	ArrayList<String> famArr;
	String curWord;
	ArrayList<Character> guessedChars;
	char[] charPositions;

	public CustomMap() {
		map = new HashMap<Integer, ArrayList<String>>();
		famArr = new ArrayList<String>();
		curWord = "";
		guessedChars = new ArrayList<Character>();
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
		guessedChars.add(c);
		// System.out.println(map.entrySet());

		Map.Entry<Integer, ArrayList<String>> entry = map.entrySet().iterator().next();
		ArrayList<String> tmpArr = entry.getValue();
		Integer tmpInt = entry.getKey();
		
		// re-write map with all new valid families (of matched chars) & remove existing data
		for (int i = 0; i < tmpInt; i++) {
			ArrayList<String> arr = new ArrayList<String>();
			map.put(i, arr);
		}
		map.remove(tmpInt);
		// System.out.println(map.entrySet());
		
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

		// Check size() of each updated word family, select family with greatest num of words.
		Iterator iter = map.entrySet().iterator();
		Map.Entry<Integer, ArrayList<String>> theEntry = (Map.Entry<Integer, ArrayList<String>>) iter.next();
		ArrayList<String> compareOld = theEntry.getValue();
		Integer maxFamily = theEntry.getKey();

		while (iter.hasNext()) {
			theEntry = (Map.Entry<Integer, ArrayList<String>>) iter.next();
			ArrayList<String> compareNew = theEntry.getValue();
			if (compareNew.size() > compareOld.size()) maxFamily = theEntry.getKey();
			compareOld = theEntry.getValue();
		}

		System.out.println("Greatest num of words is in matched-char-family " + maxFamily);
		System.out.println("That family contains " + map.get(maxFamily));

		// select the first word of the largest family as the initial word. Reveal output hint to user.
		curWord = map.get(maxFamily).get(0);
		System.out.println("Your word is " + curWord);
		System.out.println("Current correct letters printed below:");
		for (int i = 0; i < curWord.length(); i++ ) {
			for (Character cha : guessedChars) {
				// todo: instead of manuall printing these, store them in an array (or ArrayList) and then toString() it.
				// advantage: allows future access, need the position of guess chars to create future families.
				if (cha.equals(curWord.charAt(i))) System.out.print(cha);
				else System.out.print("_");

			}
		}

		// 
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