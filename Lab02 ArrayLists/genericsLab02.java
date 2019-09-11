import java.util.*;

public class genericsLab02 {

    public static void main(String args[]) {
        // populate first ArrayList of Integers
        ArrayList<Integer> intsOne = new ArrayList<Integer>();
        intsOne.add(1); intsOne.add(2); intsOne.add(3); intsOne.add(9); intsOne.add(33); intsOne.add(99);

        // populate second ArrayList of Integers (for compare)
        ArrayList<Integer> intsTwo = new ArrayList<Integer>();
        intsTwo.add(1); intsTwo.add(2); intsTwo.add(3); intsTwo.add(9); intsTwo.add(33); intsTwo.add(99);

        // populate first ArrayList of Strings
        ArrayList<String> strsOne = new ArrayList<String>();
        strsOne.add("foo"); strsOne.add("bar"); strsOne.add("foobar"); strsOne.add ("bar"); strsOne.add("fubar"); strsOne.add("this is a sentence");
    
        // populate second ArrayList of Strings
        ArrayList<String> strsTwo = new ArrayList<String>();
        strsTwo.add("foo"); strsTwo.add("bar"); strsTwo.add("foobar"); strsTwo.add ("bar"); strsTwo.add("fubar"); strsTwo.add("this is a sentence");


        // Aaaaaand now I see the issue. Cannot use across types without implementing generics. SEE: genericsLab02b.java
        unique(strsOne);
        removeAll(strsOne, "bar");
        unique(strsOne);

        unique(intsOne);
        // allMultiples();
        // allStringsOfSize();
        // tokenize();
        // removeAll();
    }

    public static Boolean unique(ArrayList<String> L) {
        for(int i = 0; i < L.size(); i++) {
            for (int j = 0; j < L.size(); j++) {
                // if (2 els equal to each other) and (not comparing the same index location) return false
                if ( L.get(i).toString().equals(L.get(j).toString()) && i != j ) return false;
            } 
        }
        System.out.println("it's unique");
        return true;
    }

    public static ArrayList<Integer> allMultiples(ArrayList<Integer> l, int divisor) {
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % divisor == 0) 
                multiples.add(l.get(i)); 
        }
        return multiples;
    }

    public static ArrayList<String> allStringsOfSize(ArrayList<String> l, Integer len) {
        String curStr = new String();
        ArrayList<String> allStrs = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            curStr = l.get(i);
            if (curStr.length() == len)
                allStrs.add(curStr);
        }
        return allStrs;
    }

    public static Boolean isPermutation(ArrayList<String> l1, ArrayList<String>l2) { 
        if (l1.size() != l2.size()) return false;        
        // make temp a copy of l2, to use remove() on.
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < l2.size(); i++) {
            temp.add(l2.get(i));
        }
        // compare l1 to temp, if element found, remove(). repeat until all common elements to l1 removed from temp
        for (int i = 0; i < l1.size(); i++) {
            if (temp.indexOf(l1.get(i)) == -1) return false;
            else temp.remove(temp.indexOf(l1.get(i)));
        }
        if (temp.size() == 0) return true;
        else return false;
        }

    public static ArrayList<String> tokenize(String str) {
        str = str.strip();
        String[] temp = str.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < temp.length; i++) {
            list.add(temp[i]);
        }
        return list;
    }

    public static void removeAll(ArrayList<Integer> l, Integer toKill) {
        ArrayList<Integer> indices = new ArrayList<Integer>();  
        for (int i = l.size()-1; i >= 0; i--) {
            if (l.get(i).equals(toKill)) indices.add(l.get(i));
        }
        for (int i = 0; i < indices.size(); i++) {
            l.remove(indices.get(i));
        }
    }
}