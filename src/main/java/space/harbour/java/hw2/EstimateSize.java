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
        int[] i = new int[160_000_000];  // int
        int sleepTime = 10;
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(sleepTime);

        Integer integer = null;    // reference
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(sleepTime);

        String string = null;      // string
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(sleepTime);

        Object object = null;      // object
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(sleepTime);
    }
}
