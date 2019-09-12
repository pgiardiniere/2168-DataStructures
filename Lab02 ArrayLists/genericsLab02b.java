import java.util.*;

public class genericsLab02b {

    public static void main(String args[]) {
        // make & populate first ArrayList of Integers
        ArrayList<Integer> intsOne = new ArrayList<Integer>();
        intsOne.add(1); intsOne.add(2); intsOne.add(3); intsOne.add(9); intsOne.add(33); intsOne.add(99);

        // make & populate second ArrayList of Integers -- rearranged for isPermutation()
        ArrayList<Integer> intsTwo = new ArrayList<Integer>();
        intsTwo.add(3); intsTwo.add(2); intsTwo.add(1); intsTwo.add(9); intsTwo.add(33); intsTwo.add(99);

        // make & populate first ArrayList of Strings
        ArrayList<String> strsOne = new ArrayList<String>();
        strsOne.add("foo"); strsOne.add("bar"); strsOne.add("foobar"); strsOne.add ("bar"); strsOne.add("fubar");
    
        // make & populate second ArrayList of Strings
        ArrayList<String> strsTwo = new ArrayList<String>();
        strsTwo.add("foo"); strsTwo.add("bar"); strsTwo.add("foobar"); strsTwo.add ("bar"); strsTwo.add("fubar");

        // make strings
        String str = "This string is a sentence.";
        String extra = ".%wowee__- this? has@ some,. garbage";

        // execute all methods
        unique(intsOne);
        allMultiples(intsOne, 3);
        allStringsOfSize(strsTwo, 3);
        isPermutation(intsOne, intsTwo);
        
        // tokenize() demo -- "str" Demonstrates base functionality, "extra" demonstrates extra credit functionality
        tokenize(str);
        tokenize(extra);

        // removeAll() demo -- after removing all "bar" elements from strsOne, it now is unique
        unique(strsOne);
        removeAll(strsOne, "bar");
        unique(strsOne);        

    }

    public static <E> Boolean unique(ArrayList<E> L) {
        for(int i = 0; i < L.size(); i++) {
            for (int j = 0; j < L.size(); j++) {
                // if (2 els equal to each other) and (not comparing the same index location) return false
                if ( L.get(i).toString().equals(L.get(j).toString()) && i != j ) return false;
            } 
        }
        return true;
    }

    public static <E> ArrayList<E> allMultiples(ArrayList<E> l, E divisor) {
        ArrayList<E> multiples = new ArrayList<E>();
        for (int i = 0; i < l.size(); i++) {
            if  (Integer.parseInt(l.get(i).toString()) % Integer.parseInt(divisor.toString()) == 0)
                multiples.add(l.get(i)); 
        }
        return multiples;
    }

    public static <E> ArrayList<E> allStringsOfSize(ArrayList<E> l, Integer len) {
        String curStr = new String();
        ArrayList<E> allStrs = new ArrayList<E>();
        for (int i = 0; i < l.size(); i++) {
            curStr = l.get(i).toString();
            if (curStr.length() == len)
                allStrs.add(l.get(i));
        }
        return allStrs;
    }

    public static <E> Boolean isPermutation(ArrayList<E> l1, ArrayList<E>l2) { 
        if (l1.size() != l2.size()) return false;        
        // make temp a copy of l2, to use remove() on.
        ArrayList<E> temp = new ArrayList<E>();
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

    public static <E> ArrayList<E> tokenize(String str) {
        str = str.strip();
        str = str.replaceAll("[^a-zA-Z0-9 ]", "");  // extra credit: regex replaces all characters NOT a-zA-Z0-9 or whitespace with "" (i.e. nothing)
        String[] temp = str.split(" ");
        ArrayList<E> list = new ArrayList<E>();
        for (int i = 0; i < temp.length; i++) {
            list.add((E) temp[i]);
        }
        return list;
    }

    public static <E> void removeAll(ArrayList<E> l, E toKill) {
        ArrayList<E> indices = new ArrayList<E>();  
        for (int i = l.size()-1; i >= 0; i--) {
            if (l.get(i).equals(toKill)) indices.add(l.get(i));
        }
        for (int i = 0; i < indices.size(); i++) {
            l.remove(indices.get(i));
        }
    }
}