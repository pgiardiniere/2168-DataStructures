import java.util.*;

public class LinkedList2 {
    Node head;
    int size;

    static class Node {
        int data;
        Node next;

        Node(int dat) {
            data = dat;
            next = null;
        }
    }

    public LinkedList2(Node headNode) {
        head = headNode;
        size = 1;
    }

    public static void main(String[] args) {
        Node nod1 = new Node(1);
        LinkedList2 sll = new LinkedList2(nod1);

        // WOOT! I PUT A THING IN HEAD! AND PRINTED IT
        System.out.println(sll.head.data);
    }

}
