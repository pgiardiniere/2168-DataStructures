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
            for (int j = 0; j < L.size(); j++) {
                // if (2 els equal to each other) and (not comparing the same index location) return false
                if ( L.get(i).toString().equals(L.get(j).toString()) && i != j ) return false;
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

        // make temp a copy of l2, so can remove() els for tracking.
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