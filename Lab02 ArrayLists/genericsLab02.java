import java.util.*;

// import com.sun.tools.javac.code.Attribute.Array;

public class genericsLab02 {
    private static ArrayList foo = new ArrayList<String>();

    public static void main(String args[]) {

        // make test data: ArrayList of Strings
        ArrayList<String> bar = new ArrayList<>();
        bar.add("poop");
        bar.add("second");
        bar.add("third");


        unique(foo);
        // allMultiples(foo);
        // allStringsOfSize(foo);
        tokenize(foo);
        removeAll(foo);


    }

    // test whether any List element is repeated
    public static Boolean unique(ArrayList L) {
        for(int i = 0; i < L.size(); i++) {
            for (int j = 0; j <= L.size() - 1; j++) {
                // if (elements equal to each other) and (not from same position) return false
                if ( L.get(i).equals(L.get(j)) && (L.indexOf(i) != L.indexOf(j)) ) return false; // this isn't working... probably compare is broken
            } 
        }
        return true;
    }
    public static ArrayList allMultiples(ArrayList<Integer> l, int divisor) {
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % divisor == 0) 
                multiples.add(l.get(i)); 
        }
        System.out.print(multiples);
        return multiples;
    }

    public static ArrayList allStringsOfSize(ArrayList<String> l, Integer len) {
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
        // if lists not of same size, cannot be a permutation 
        if (l1.size() != l2.size()) return false;        

        ArrayList<String> matchedEls = new ArrayList<String>();
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++)
                if (l1.get(i).equals(l2.get(j))) matchedEls.add(l1.get(i));
            }
        if (matchedEls.size() == l1.size()) return true;
        else return false;
        }


    public static ArrayList tokenize(ArrayList<String> l) {
        ArrayList<String> tokenized = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            String str = l.get(i);
            tokenized.add(str.strip());
        }
        return tokenized;
    }

    // strange, it doesn't necessarily remove all the ints equal to the int val in first pass (see screenshot)
    // OHH --- when I remove, I am skipping indices. that's why it doesn't catch all in first pass
    public static ArrayList removeAll(ArrayList<Integer> l, Integer toKill) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(toKill)) l.remove(i);
        }
        return l;
    }
}