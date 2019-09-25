import java.util.*;

public class LinkedList {
    private Node head;
    // Linked List Node

    // NOTE: genericize class -- Node<E> -- then remove int references, replace with E
    // Inner class is static so Main() can access it

    static class Node {
        // instance variables
        int data;
        Node next;

        // Constructor
        Node(int dat) {
            data = dat;
            next = null;
        }
    }

    // add (really, append) a new node
    public static LinkedList add(LinkedList list, int data) {
        // create new node with passed-in data
        Node newNode = new Node(data);
        newNode.next = null;

        // case where list has no head yet (i.e. empty LinkedList)
        if (list.head == null) { list.head = newNode; }
        else {
            // else traverse until hit last node, then insert
            Node last = list.head;
            while (last.next != null) { last = last.next; }
            last.next = newNode;
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        sll.add(sll, 1);
        sll.add(sll, 2);
        sll.add(sll, 3);

        System.out.println(sll.toString());
    }
}
