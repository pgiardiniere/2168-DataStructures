import java.util.*;

public class LinkedList2 {
    Node head;
    int size;

    static class Node {
        Integer data;
        Node next;

        Node(int dat) {
            data = dat;
            next = null;
        }
    }

    public LinkedList2(Node headNode) {
        head = headNode;
        head.next = head;
        size = 1;
    }

    public void append(int dat) {        
        // walk to (almost) end of the list
        Node last = head;
        for (int i = 1; i < size; i++) {
            last = last.next;
        }

        // append newNode
        Node newNode = new Node(dat);
        last.next = newNode;
        newNode.next = head;
        size++;
    }

    public String toString() {
        
        if (size == 1) { return head.data.toString(); }
        else {
            Node currentNode = head;
            StringBuilder strb = new StringBuilder();
            do {
                strb.append(currentNode.data + " ==> ");
                currentNode = currentNode.next;

            } while (currentNode != head);
            return strb.toString();
        }
    }

    public static void main(String[] args) {

        //              Testing: use preset data
        int numSoldiers = 5; 
        int numSkips = 2;
        int[] soldiers = new int[5];
        for (int i=0; i < numSoldiers; i++) { soldiers[i] = i + 1; }


        /*              Production: Get user input. This stuff works - just tested it. uncomment when ready
        // Get soldiers[] and interval
        Scanner inScan = new Scanner(System.in);
        System.out.println("input num soldiers, hit enter, input num skips");
        int numSoldiers = inScan.nextInt();
        int numSkips = inScan.nextInt();
        int[] soldiers = new int[numSoldiers];
        for (int i = 0; i < numSoldiers; i++) { soldiers[i] = i + 1; }
        */

        // Put soldiers[] into a single linked list. init loop at 1 as head already made
        Node nod1 = new Node(1);                    //  FOR JSHELL LinkedList2.Node nod1 = new LinkedList2.Node(1);
        LinkedList2 sll = new LinkedList2(nod1);
        for (int i = 1; i < numSoldiers; i++) { 
            System.out.println("index " + i + " soldier " +  soldiers[i]);
            sll.append(soldiers[i]); 
        }

        System.out.print("\n");
        System.out.println(sll.head.data);
        System.out.println(sll.toString());
    }
}
