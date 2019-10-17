import java.util.*;
import java.io.*;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree extends BinaryTree {
	
	// This is your root
	private Node root;
	
	IndexTree() {
		super();
	}
	IndexTree(String word, int index) {
		super(new Node(word, index));
	}
	IndexTree(String word, int index, BinaryTree leftSubTree, BinaryTree rightSubTree) {
		super(word, index, leftSubTree, rightSubTree); 
	}

	
	// complete the methods below
	
	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the Node that already exists
	// otherwise make a new Node
	private Node add(Node root, String word, int lineNumber){
		return null;
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		return false;
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private Node delete(Node root, String word){
		return null;
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		
	}
	

	public static void main(String[] args) throws IOException {
		IndexTree leftSub = new IndexTree("LEEEFT", 1);
		IndexTree rightSub = new IndexTree("RIIGHT", 2);
		IndexTree iTree = new IndexTree("ROOOOT", 0, leftSub, rightSub);
		
		System.out.println("\ninOrder :");
		System.out.println(iTree.toString());

		System.out.println(leftSub.toString());


		// add all the words to the tree

		// reads file until end, removes formatting and capitals
		Scanner scanner = new Scanner(new File("dummy.txt"));
		while (scanner.hasNext()) {
			String next = scanner.next();
			next = next.toLowerCase().replaceAll("[^a-z0-9]", ""); 	// formatting
			System.out.println(next);
		}

		Scanner scan = new Scanner(new File("dummy.txt"));
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			nextLine = nextLine.toLowerCase().replaceAll("[^a-z0-9]", ""); 	// formatting
			system.out.println(nextLine);

			String[] split = nextLine.split("\\s+")
			for 
		}

		// print out the index
		
		// test removing a word from the index

		
	}
}
