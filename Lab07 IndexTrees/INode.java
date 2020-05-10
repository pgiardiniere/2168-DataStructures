import java.util.*;

public class INode {
	String word;
	int occurrences;
	ArrayList<Integer> indices;
	INode left;
	INode right;

	public INode(String word, int lineIndex) {
		this.word = word;
		occurrences = 1;
		indices = new ArrayList<Integer>();
		indices.add(lineIndex);
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();
		strb.append("Your word " + word + " occurs " + Integer.toString(occurrences) + " times, ");
		strb.append("at the following line indices: " + indices.toString());
		return strb.toString();
	}

}