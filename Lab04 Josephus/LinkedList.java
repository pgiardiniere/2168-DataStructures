import java.util.*;

@SuppressWarnings("unchecked")

public class LinkedList<E> implements Iterable<E>{  
    Node<E> head;
    int size;

    static class Node<E> {
        E data;
        Node next;

        Node(E dat) {
            data = dat;
            next = null;
        }
    }

    public LinkedList(Node headNode) {
        head = headNode;
        head.next = head;
        size = 1;
    }

    public void add(E dat) {        
        Node newNode = new Node(dat);
        // walk to (almost) end of the list
        Node last = head;
        for (int i = 1; i < size; i++) { last = last.next; }
        // append newNode   
        last.next = newNode;
        newNode.next = head;
        size++;
    }

    public void add(int index, E dat) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(Integer.toString(index)); }
        Node newNode = new Node(dat);
        // place new node in head
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
        }
        // place new node at end
        else if (index == size-1) { add(dat); }
        // place node in middle
        else {
            Node traverser = head;
            for (int i = 1; i < index; i++) { traverser = traverser.next; }
            newNode.next = traverser.next;
            traverser.next = newNode;
            size++;
        }
        
    }

    public Node remove(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(Integer.toString(index)); }        
        Node temp = head;
        // remove node at head
        if (index == 0) {
            Node prev = head;
            while (prev.next != head) { prev = prev.next; }
            head = temp.next;
            prev.next = head;
            size--;
            return temp;
        }
        // remove node at end
        else if (index == size-1) {
            for (int i = 1; i < index; i++) { temp = temp.next; }
            temp.next = head;
            size--;
            return temp;
        }
        // remove node in middle
        else {
            for (int i = 1; i < index; i++) { temp = temp.next; }
            temp.next = temp.next.next;
            size--;
            return temp;
        }
    }

    public String toString() {        
        if (size == 1) { return head.data.toString(); }
        
        else {
            Node currentNode = head;
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                strb.append(currentNode.data + " ==> ");
                currentNode = currentNode.next;
            }
            return strb.toString();
        }
    }

    public static void main(String[] args) {
        //              JOSEPHUS: preset data mode.
        int numSoldiers = 13; 
        int numSkips = 2;
        int[] soldiers = new int[numSoldiers];
        for (int i=0; i < numSoldiers; i++) { soldiers[i] = i + 1; }

        /*              JOSEPHUS: user-input mode.
        // Get soldiers[] and interval
        Scanner inScan = new Scanner(System.in);
        System.out.println("input num soldiers, hit enter, input num skips");
        int numSoldiers = inScan.nextInt();
        int numSkips = inScan.nextInt();
        int[] soldiers = new int[numSoldiers];
        for (int i = 0; i < numSoldiers; i++) { soldiers[i] = i + 1; }
        */

        Node nod1 = new Node(1);                    //  If in JSHELL:: LinkedList.Node nod1 = new LinkedList.Node(1);
        LinkedList sll = new LinkedList(nod1);
        for (int i = 1; i < numSoldiers; i++) { 
            sll.add(soldiers[i]); 
        }

        /*
        // ############### demonstrate all edge-cases ####################
        // ############### addition ###############
        // add at end
        System.out.print("\nDemonstrate Addition \n");
        sll.add(numSoldiers - 1, 6);
        System.out.println(sll.toString());
        // add at head
        sll.add(0, 9001);
        System.out.println(sll.toString());
        // add in middle
        sll.add(3, 42);
        System.out.println(sll.toString());

        // ############### removal ###############
        // remove at end
        System.out.print("\nDemonstrate Removal \n");
        sll.remove(7);
        System.out.println(sll.toString());
        // remove at head 
        sll.remove(0);
        System.out.println(sll.toString());
        // remove in middle
        sll.remove(2);
        System.out.println(sll.toString());


        // demonstrate traversal with iterator
        System.out.print("\nDemonstrate ListIterator implementation \n");
        Iterator testIter = sll.iterator();
        System.out.println(testIter.next());
        System.out.println(testIter.next());
        System.out.println(testIter.next() + "\n");
        */

        // ###############      end demonstration     ####################
        
        //  JOSEPHUS: remove every k'th soldier using iterator remove()
        System.out.println("Core Jospehus Demonstration: ");
        System.out.println(sll.toString());
        
        Iterator iter = sll.iterator();
        while (numSoldiers > 2) {
            for (int i = 0; i < numSkips; i++) { iter.next(); }
            iter.remove();
            System.out.println(sll.toString());
            numSoldiers--;
        }        
    }

    // LinkedList - method to create ListIterator in class:::
    public Iterator<E> iterator() {
        return new ListIterator<E>();
    }

    // ListIterator implementation
    private class ListIterator<E> implements Iterator<E> {
        Node<E> nextItem; 
        Node<E> prev;
        int index;

        public ListIterator() {
            nextItem = (Node<E>) head;
            index = 0;
        }

        // Circular linked list. It always hasNext.
        public boolean hasNext() {
            return true;
        }

        public E next() {
            prev =  nextItem;
            nextItem = nextItem.next;
            index =  (index + 1) % size;
            return prev.data;
        }

        public void remove() {
            int target;
            if (nextItem == head) {
                target = size - 1;
            } 
            else { 
                target = index - 1;
                index--;
            }
            LinkedList.this.remove(target);
        }
    }
}
