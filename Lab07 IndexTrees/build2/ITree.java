import java.util.*;
import java.io.*;

public class ITree {

	private INode root;

	public ITree() { root = null; }

	public void add(String word, int lineNum) { root = add(word, lineNum, root); }

	public INode add(String word, int lineNum, INode curNode) {
		if (curNode == null) { 
			return new INode(word, lineNum);
		}
		else if (curNode.word.equals(word)) { 
			curNode.occurrences++;
			curNode.indices.add(lineNum);
		}
		else if (word.compareToIgnoreCase(curNode.word) < 0) {
			curNode.left = add(word, lineNum, curNode.left);
		} 
		else { 
			curNode.right = add(word, lineNum, curNode.right);
		} 
		return curNode;
	}

	public void printIndex() { printIndex(root); }
	
	public void printIndex(INode curNode) {
		if (curNode == null) {  } // do nothing
		else { 
			printIndex(curNode.left);
			System.out.println(curNode.toString());
			printIndex(curNode.right);
		}
	}

	public boolean contains(String word) { return contains(word, root); }

	public boolean contains(String word, INode curNode) {
		if (curNode == null) { return false; }

		else if (word.equals(curNode.word)) { 
			return true;
		}
		else if (word.compareToIgnoreCase(curNode.word) < 0) {
			return contains(word, curNode.left);
		}
		else {
			return contains(word, curNode.right);
		}
	}

	public String search(String word) { return search(word, root); }

	public String search(String word, INode curNode) {
		if (curNode == null) { return "Your word " + word + " was not found."; }

		else if (word.equals(curNode.word)) { 
			return curNode.toString();
		}
		else if (word.compareToIgnoreCase(curNode.word) < 0) {
			return search(word, curNode.left);
		}
		else {
			return search(word, curNode.right);
		}
	}

	public void delete(String word) { root = delete(word, root); }

	public INode delete(String word, INode curNode) {
		if (curNode == null) { return null; } 		// this word not in list. return null (no node deleted)

		if (word.equals(curNode.word)) { 			// found node to delete. 
			// 0 Child nodes
			if (curNode.left == null && curNode.right == null) {
				return null;
			}
			// 1 Child node (on the left)
			else if (curNode.left != null && curNode.right == null) {
				return curNode.left;
			}
			// 1 Child node (on the right)
			else if (curNode.left == null && curNode.right != null) {
				return curNode.right;
			}
			// 2 Child nodes
			else if (curNode.left != null && curNode.right != null) {
				// get smallest leaf node from the right-hand subTree:
				INode leastLeaf = getLeastLeaf(curNode.right);
				// delete curNode's data by overwriting with least leaf (to preserve tree structure)
				curNode.word = leastLeaf.word;
				curNode.occurrences = leastLeaf.occurrences;
				curNode.indices = leastLeaf.indices;
				// delete leastLeaf (as it is now duplicate)
				curNode.right = delete(leastLeaf.word, curNode.right);
				return curNode;
			}
		}

		if (word.compareToIgnoreCase(curNode.word) < 0) { // recurse down 1 level. 
			curNode.left = delete(word, curNode.left);
			return curNode;
		}
		// implied else-if, covered all cases. Otherwise compiler complains about missing return statement
		curNode.right = delete(word, curNode.right);
		return curNode;
	}

	public INode getLeastLeaf(INode curNode) {
		return curNode.left == null ? curNode : getLeastLeaf(curNode.left);
	}

	public static void main(String[] args) throws IOException {
		ITree tree = new ITree();

		// read input data from file:
		int curLine = 0;
		Scanner scanner = new Scanner(new File("dummy.txt"));

		// push 1 line of text into the tree, until file is done.
		while (scanner.hasNextLine()) {
			curLine++;
			String nextLine = scanner.nextLine(); 								// get raw text
			nextLine = nextLine.toLowerCase().replaceAll("[^a-z0-9 ]", ""); 	// format, but retain WhiteSpace
			
			String[] tmp = nextLine.split(" "); 									// split on whitespace, store in primitive array
			ArrayList<String> split = new ArrayList<String>(Arrays.asList(tmp)); 	// push to ArrayList
			for (String str : split) { tree.add(str, curLine); }					// feed contents of ArrayList to tree
		}

		System.out.println("\n");
			// DUMMY.txt showcase:
		
		tree.printIndex();
		System.out.println("\n" + tree.contains("beaver"));
		System.out.println(tree.search("string"));

		tree.delete("beaver");

		System.out.println(tree.contains("beaver"));
		System.out.println(tree.search("beaver") + "\n");
		tree.printIndex();
		

			// shakespeare.txt showcase:
		// tree.printIndex();
	}
}