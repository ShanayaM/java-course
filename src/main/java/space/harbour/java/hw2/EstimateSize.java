/*
* Create a class EstimateSize to estimate size of int, reference, Object, and String using totalMemory() and freeMemory() methods.
* */

package main.java.space.harbour.java.hw2;

public final class EstimateSize {

    public static void main(String[] args) {
        System.gc();
        
        int i;  // int
        Integer integer;    // reference
        String string;      // string
        Object object;      // object

        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
