import java.util.*;

public class WordyFamilyMaps {

	WordyFamilyMaps(){};

	public static void main(String[] args) {
		
		// "words" was chosen to simulate those from 4 character family.
		
		// we want to group into families such that (based on user input) the strings are grouped into:
			// (for 4 letter words only)
				// words which match 1 character
				// words which match 2 characters
				// words which match 3 characters
				// words which match 4 characters
			// then, we take the family with MOST members, and return a (random?) word from it to the user
					// guess it doesn't matter which word, since they are all returning the same number of revealed letters.
					// it could just always be first member of family lol. 
		
		Map<Integer, ArrayList<String>> map = new HashMap<>();
		Character guess = 'o';
		String[] words = { "this", "four", "char", "word", "boon", "doof" };

		for (String word : words) {
			Integer numMatches = 0;
			ArrayList<String> wordFamily;			

			for (int i = 0; i < word.length(); i++) {
				if (guess == word.charAt(i)) numMatches++;
			}

			wordFamily = map.containsKey(numMatches) ? map.get(numMatches) : new ArrayList<String>();
			wordFamily.add(word);
			map.put(numMatches, wordFamily);
		}
		System.out.println(map.entrySet());


		// begin user interactivity building:

	}
}