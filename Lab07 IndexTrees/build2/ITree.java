import java.util.*;
import java.io.*;

public class ITree {

	private INode root;

	public ITree() { root = null; }

	public void add(String word, int lineNum) {
		if (root == null) { root = add(root, word, lineNum); }
		else add(root, word, lineNum);
	}

	public INode add(INode curNode, String word, int lineNum) {
		if (curNode == null) { 
			curNode = new INode(word, lineNum);
			return curNode;
		}

		else if (curNode.word.equals(word)) { 
			curNode.occurrences++;
			curNode.indices.add(lineNum);
			return curNode; 
		}

		else if (word.compareToIgnoreCase(curNode.word) < 0) { 	// if new word occurs BEFORE curnode alphabetically,
				return add(curNode.left, word, lineNum); 		// then look for match down lefthand nodes
			} 

		else { 													// else new word occurs AFTER curnode alphabetically,
				return add(curNode.right, word, lineNum);		// then look for match down righthand nodes 
		} 

		// if we hit a null node, then we have NO MATCH. (and are in the correct position to add the new word)

	}

	public static void main(String[] args) {
		// ITree treeLeft = new ITree("left", 0 );	
		// ITree treeRight = new ITree("right", 2);
		ITree treeBase = new ITree();
		treeBase.add("AABB", 0);
		treeBase.add("AABB", 1);
		treeBase.add("AAAA", 1);
		treeBase.add("BBBB", 2);

		System.out.println(treeBase.root.toString());
		// System.out.println(treeBase.root.left.toString());
		// System.out.println(treeBase.root.right.toString());
	}

}