/*
* Create a class EstimateSize to estimate size of int, reference,
* Object, and String using totalMemory() and freeMemory() methods
*/

package main.java.space.harbour.java.hw2;

final class EstimateSize {

    private EstimateSize() {
        // To prevent instantiation
    }

    public static void main(String[] args) {
        System.gc();
        int[] i = new int[160000000];  // int
        System.out.println(Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory());
        Thread.sleep(10);

        Integer integer = null;    // reference
        System.out.println(Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory());
        Thread.sleep(10);

        String string = null;      // string
        System.out.println(Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory());
        Thread.sleep(10);

        Object object = null;      // object
        System.out.println(Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory());
        Thread.sleep(10);
    }
}
