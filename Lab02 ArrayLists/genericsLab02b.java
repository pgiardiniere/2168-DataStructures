import java.util.*;

public class genericsLab02b {

    public static void main(String args[]) {
        // unique(foo);
        // allMultiples(foo);
        // allStringsOfSize(foo);
        // tokenize(foo);
        // removeAll(foo);
    }

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