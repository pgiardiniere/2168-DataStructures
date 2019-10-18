import java.util.*;
import java.io.*;

public class ITree {

	private INode root;

	public ITree() { root = null; }

	public void add(String word, int lineNum) {
		if (root == null) { root = add(word, lineNum, root); }
		else add(word, lineNum, root);
	}

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

	public boolean contains(String word) { 
		return contains(word, root);
	}

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

	public void delete(String word) {
		delete(word, root);
	}

	public void delete(String word, INode curNode) {
		if (curNode == null) {  } 					// this word not in list. do nothing.

		else if (word.equals(curNode.word)) { 		// found node to delete. 
			// 0 Child nodes
			if (curNode.left == null && curNode.right == null) {
				curNode = null;
			}
			// 1 Child node (on the left)
			else if (curNode.left != null && curNode.right == null) {
				curNode = curNode.left;
			}
			// 1 Child node (on the right)
			else if (curNode.left == null && curNode.right != null) {
				curNode = curNode.right;
			}
			// 2 Child nodes
			else if (curNode.left != null && curNode.right != null) {
				// get smallest leaf node from the right-hand subTree:
				INode leastLeaf = getLeastLeaf(curNode.right);
				// transform curNode data into leastLeaf's data. Preserves tree structure
				curNode.word = leastLeaf.word;
				curNode.occurrences = leastLeaf.occurrences;
				curNode.indices = leastLeaf.indices;
				// then delete leastLeaf (as it is now duplicate)
				delete(leastLeaf.word, curNode.right);
			}
		}

		else if (word.compareToIgnoreCase(curNode.word) < 0) {
			delete(word, curNode.left);
		}
		else {
			delete(word, curNode.right);
		}
	}

	public INode getLeastLeaf(INode curNode) {
		return curNode.left == null ? curNode : getLeastLeaf(curNode.left);
	}

	public static void main(String[] args) {
		// ITree treeLeft = new ITree("left", 0 );
		// ITree treeRight = new ITree("right", 2);
		ITree treeBase = new ITree();
		treeBase.add("a", 0);
		treeBase.add("b", 1);
		treeBase.add("c", 1);
		treeBase.add("d", 2);
		treeBase.add("e", 2);
		treeBase.add("f", 2);
		treeBase.add("g", 2);
		treeBase.add("h", 2);
		treeBase.add("i", 2);
		treeBase.add("j", 2);

		treeBase.printIndex();

		treeBase.delete("j");

		System.out.println();
		treeBase.printIndex();

		treeBase.delete("a");
		treeBase.delete("e");

		System.out.println();
		treeBase.printIndex();
	}

}