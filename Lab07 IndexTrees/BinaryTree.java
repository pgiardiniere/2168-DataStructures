import java.util.*;

public class BinaryTree	 {
	protected Node root;
	// 3 constructors: public null-tree, protected root-node, public other node
	public BinaryTree() {
		root = null;
	} 

	protected BinaryTree(Node root) {
		this.root = root;
	}

	public BinaryTree(String word, int index, BinaryTree leftSubTree, BinaryTree rightSubTree) {
		root = new Node(word, index);

		if (leftSubTree != null) { root.left = leftSubTree.root; }
		else { root.left = null; }

		if (rightSubTree != null) { root.right = rightSubTree.root; }
		else { root.right = null;}
	}

	public String getWord() {
		if (root != null) { return root.word; }
		else return null;
	}

	// TODO: return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	// FOR NOW: simply print ALL nodes in format requested:
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		inOrderTraverse(root, 1, sb);  			// Get to string location & put data in sb.

		return sb.toString(); // print the stuff in sb
	}

	// get to string location. update stringbuilder with relevant info.
	private void inOrderTraverse(Node node, int depth, StringBuilder sb) {
		if (node == null) { 
			// sb.append("Null\n"); 	// were fed an empty tree - do nothing 
		} 
		else {
			inOrderTraverse(node.left, depth + 1, sb); 		// traverse left tree			
			sb.append(node.toString() + "\n"); 				// visit root node
			inOrderTraverse(node.right, depth + 1, sb); 	// traverse right tree
		}
	}

	private void inOrderSearch(String searchTerm) {
		// begin search at root
		
	}

	// Inner-Class Node
	protected static class Node {
		protected String word;
		protected int occurrences;
		protected ArrayList<Integer> indices;
		protected Node left;
		protected Node right;

		// "Constructor should take in a word *** and a line number ***"
		public Node(String word, int lineIndex) {
			this.word = word;
			this.occurrences = 1;
			this.indices = new ArrayList<Integer>();
			this.indices.add(lineIndex);
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

}