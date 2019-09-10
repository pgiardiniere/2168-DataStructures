import java.util.*;

public class genericsLab02 {
    private static ArrayList foo = new ArrayList<String>();

    public static void main(String args[]) {

        // make test data: ArrayList of Strings
        ArrayList<String> bar = new ArrayList<>();
        bar.add("poop");
        bar.add("second");
        bar.add("third");


        unique(foo);
        allMultiples(foo);
        allStringsOfSize(foo);
        tokenize(foo);
        removeAll(foo);


    }

    public static boolean isUnique(ArrayList l) {
        return false;
    }

    // getting OOB Exception here

    // test whether any List element is repeated
    public static Boolean unique(ArrayList L) {
        for(int i = 0; i <= L.size() - 1; i++) {
            for (int j = 0; j <= L.size() - 1; j++) {
                // if (elements equal to each other) and (not from same position) return false
                if ( L.get(i).equals(L.get(j)) && (L.indexOf(i) != L.indexOf(j)) ) return false; // this isn't working... probably compare is broken
            } 
        }
        return true;
    }
    // working, but throwing warnings about unchecked conversion
    public static ArrayList allMultiples(ArrayList<Integer> l, int divisor) {
        ArrayList multiples = new ArrayList<Integer>();
        for (int i = 0; i <= l.size() - 1; i++) {
            if (l.get(i) % divisor == 0) 
                multiples.add(l.get(i)); 
        }
        System.out.print(multiples);
        return multiples;
    }

    public static void allStringsOfSize(ArrayList l) {

    }

    public static void tokenize(ArrayList l) {

    }

    public static void removeAll(ArrayList l) {

    }


}