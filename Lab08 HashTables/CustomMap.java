import java.util.*;
import java.io.*;

public class CustomMap {

	Map<Integer, ArrayList<String>> map;
	ArrayList<String> famArr;

	public CustomMap() {
		map = new HashMap<Integer, ArrayList<String>>();
		famArr = new ArrayList<String>();
	}

	public void populate() { populate(map); }

	public void populate(Map<Integer, ArrayList<String>> map) {
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

		System.out.println(map.entrySet());
	}

	public void initialWords(Integer length) { initialWords(length, map); }

	public void initialWords(Integer length, Map<Integer, ArrayList<String>> map) {
		while (!map.containsKey(length)) {
			System.out.println("sorry breh don't have a word of that length. try another.");
			Scanner uinput = new Scanner(System.in);
			length = Integer.parseInt(uinput.nextLine().trim());
		}
		// System.out.println(map.entrySet());
		
		ArrayList<String> tmp = map.get(length);
		map = new HashMap<Integer, ArrayList<String>>();
		map.put(null, tmp);

		// System.out.println(map.entrySet());
	}

	public void updateFam() { updateFam(map); }

	public void updateFam(Map<Integer, ArrayList<String>> map) {
		System.out.println("teh stuff");
	}

	public static void main(String[] args) {
		CustomMap hangMap = new CustomMap();
		hangMap.populate();
		
		Scanner uinput = new Scanner(System.in);
		System.out.println("ENTER LENGHT OF WORD TO PLAY WITH QUICK DO EET NOW");
		//uinput.close();
		hangMap.initialWords(Integer.parseInt(uinput.nextLine().trim()));


	}
}