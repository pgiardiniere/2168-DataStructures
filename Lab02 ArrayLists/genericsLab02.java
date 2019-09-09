import java.util.*;

public class genericsLab02 {
    private static ArrayList foo = new ArrayList<String>();

    public static void main(String args[]) {
        unique(foo);
        allMultiples(foo);
        allStringsOfSize(foo);
        tokenize(foo);
        removeAll(foo);
    }

    // test whether any List entry is repeated in 
    public static Boolean unique(ArrayList L) {
        for(int i = 0; i <= L.size(); i++) {
            Object curEl = L.get(i);
            for (int j = 0; j <= L.size(); j++) {
                if (j == i);  // do nothing on position curEl was pulled from
                else {
                    if (L.get(j).equals(L.get(i))) {
                        return false;
                    }
                }
            }
            return true; // not positioned correctly, but this is the general idea
        }
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