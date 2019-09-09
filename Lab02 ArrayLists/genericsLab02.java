import java.util.*;

public class genericsLab02 {
    private static ArrayList foo = new ArrayList<String>();

    public static void main(String args[]) {

        // make test data: ArrayList of Strings
        List<String> bar = new ArrayList<>();
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

    // test whether any List element is repeated
    public static Boolean unique(ArrayList L) {
        for(int i = 0; i <= L.size(); i++) {
            for (int j = 0; j <= L.size(); j++) {
                // if (elements equal to each other) and (not from same position) return true
                if ( L.get(i).equals(L.get(j)) && (L.indexOf(i) != L.indexOf(j)) ) return true;
            } 
        }
        return false;
    }

    public static void allMultiples(ArrayList l) {
        
    }

    public static void allStringsOfSize(ArrayList l) {

    }

    public static void tokenize(ArrayList l) {

    }

    public static void removeAll(ArrayList l) {

    }


}