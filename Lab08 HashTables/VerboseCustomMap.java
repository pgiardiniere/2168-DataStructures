import java.util.*;
import java.io.*;

public class VerboseCustomMap {

	Map<Integer, ArrayList<String>> map;
	ArrayList<String> famArr;
	String curWord;
	ArrayList<Character> guessedChars;
	ArrayList<Character> guessedCharsPos;
	Integer wordLength;

	public VerboseCustomMap() {
		map = new HashMap<Integer, ArrayList<String>>();
		famArr = new ArrayList<String>();
		curWord = "";
		guessedChars = new ArrayList<Character>();
		guessedCharsPos = new ArrayList<Character>();
	}

	public void populate() {
		try { 
			Scanner scanner = new Scanner(new File("shordict.txt")); 
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
				famArr = ( map.containsKey(str.length()) ) ? map.get(str.length()) : new ArrayList<String>();
				famArr.add(str);
				map.put(str.length(), famArr);
			}
		}
		catch (IOException e) { System.out.println(e); }

		System.out.println("\nTotal word bank:\n" + map.entrySet());
	}

	public void initialWords(Integer length) {
		while (!map.containsKey(length)) {
			System.out.println("I don't have a word of that length. try another.");
			Scanner uinput = new Scanner(System.in);
			length = Integer.parseInt(uinput.nextLine().trim());
		}
		wordLength = length;
		ArrayList<String> tmp = map.get(length);
		map = new HashMap<Integer, ArrayList<String>>();
		map.put(length, tmp);

		System.out.println(map.entrySet());
	}

	public void updateFam(Character c) {
		guessedChars.add(c);

		Map.Entry<Integer, ArrayList<String>> entry = map.entrySet().iterator().next();
		ArrayList<String> tmpArr = entry.getValue();
		Integer tmpInt = entry.getKey();
		
		System.out.println("\n" + map.entrySet());
		// re-write map with all valid families (of matched chars) & remove existing data
		for (int i = 0; i < tmpInt; i++) {
			ArrayList<String> arr = new ArrayList<String>();
			map.put(i, arr);
		}
		map.remove(tmpInt);
		System.out.println(map.entrySet());
		
		// fill in the word families based on FIRST character (guess) input
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

		// Check size() of each updated word family, update maxFamily to key containing greatest num of words.
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

		// select the first word of the largest family as the initial word. Reveal output hint to user.
		curWord = map.get(maxFamily).get(0);
		System.out.println("\nYour word is \"" + curWord + "\"");

		System.out.println("Current correct letters printed below:");
		guessedCharsPos = new ArrayList<Character>(curWord.length());
		for (int i = 0; i < curWord.length(); i++ ) {
			for (Character cha : guessedChars) {
				if (cha.equals(curWord.charAt(i))) guessedCharsPos.add(i, curWord.charAt(i));
				else guessedCharsPos.add(i, null);
			}
		}
		for (Character cha : guessedCharsPos) { System.out.print(cha == null ? "_" : cha); }
		System.out.print("\n");

		// Cleanup map: remove all non-greatest-family entries.
		tmpArr = map.get(maxFamily);
		map.clear();
		map.put(maxFamily, tmpArr);
	}

	public boolean play(Character c) {
		guessedChars.add(c);

		// Check size() of each updated word family, select family with greatest num of words.
		ArrayList<String> maxArray = null;
		Integer maxFamily = null;

		for ( ArrayList<String> list : map.values()) { 
			if (maxArray == null || list.size() > maxArray.size()) maxArray = list;
		} 
		for (Map.Entry<Integer, ArrayList<String>> ent : map.entrySet()) {
			if (maxFamily == null || ent.getValue().size() > map.get(maxFamily).size()) maxFamily = ent.getKey();
		}

		System.out.println("\n" + map.entrySet());
		// overwrite map with all new valid families (of num-matched chars)
		for (int i = 0; i < wordLength; i++) {
			ArrayList<String> arr = new ArrayList<String>();
			map.put(i, arr);
		}
		System.out.println(map.entrySet());
		
		// fill in the word families based on ALL character (guess) input
		for (String str : maxArray) {
			Integer matches = 0;
			for (int i = 0; i < str.length(); i++) {
				for (Character cha : guessedChars) {
					if (cha == str.charAt(i)) { matches++; }
				}
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

		// re-select the first word of the updated largest family as the initial word. Reveal output hint to user.
		maxArray = null;
		maxFamily = null;
		for ( ArrayList<String> list : map.values()) { 
			if (maxArray == null || list.size() > maxArray.size()) maxArray = list;
		} 
		for (Map.Entry<Integer, ArrayList<String>> ent : map.entrySet()) {
			if (maxFamily == null || ent.getValue().size() > map.get(maxFamily).size()) maxFamily = ent.getKey();
		}		
		System.out.println("\nmaxFamily is " + maxFamily + "\nand maxArray is " + maxArray);

		curWord = maxArray.get(0);
		System.out.println("\nYour word is \"" + curWord + "\"");

		System.out.println("Current correct letters printed below:");
		guessedCharsPos = new ArrayList<Character>();
		for (int i = 0; i < curWord.length(); i++ ) {
			if (guessedChars.contains(curWord.charAt(i))) 
				guessedCharsPos.add(i, curWord.charAt(i));
			else guessedCharsPos.add(i, null);
		}
		for (Character cha : guessedCharsPos) { System.out.print(cha == null ? "_" : cha); }
		System.out.print("\n");

		for (int i = 0; i < curWord.length(); i++) {
			if (!guessedChars.contains(curWord.charAt(i))) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		VerboseCustomMap hangMap = new VerboseCustomMap();
		hangMap.populate();
		
		Scanner uinput = new Scanner(System.in);
		System.out.println("\nEnter length of word to play with");
		Integer wordLength = Integer.parseInt(uinput.nextLine().trim());
		hangMap.initialWords(wordLength);

		System.out.println("\nEnter the total number of guesses you want to use");
		Integer numGuesses = (Integer.parseInt(uinput.nextLine().trim()));

		System.out.println("Starting new game : enter first character guess");
		hangMap.updateFam(uinput.nextLine().charAt(0));

		// hangMap.play(uinput.nextLine().charAt(0));
		boolean hasWon = false;
		exit:
		for (int i = 0; i < numGuesses-1; i++) {
			System.out.println("\nOkay, now pick another character");
			hasWon = hangMap.play(uinput.nextLine().charAt(0));
			if (hasWon) {
				System.out.println("You win!!!");
				break exit;
			}
		}
		if (!hasWon) System.out.println("You're out of guesses");
	}
}