/*
* Create a class EstimateSize to estimate size of int, reference,
* Object, and String using totalMemory() and freeMemory() methods
*/

package main.java.space.harbour.java.hw2;

final class EstimateSize {

    private EstimateSize() {
        // To prevent instantiation
    }

    private static final int ARRAY_SIZE = 160_000_000;
    private static final int SLEEP_TIME = 10;

    public static void main(String[] args) throws InterruptedException {
        System.gc();
        int[] i = new int[ARRAY_SIZE];  // int
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(SLEEP_TIME);

        Integer integer = null;    // reference
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(SLEEP_TIME);

        String string = null;      // string
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(SLEEP_TIME);

        Object object = null;      // object
        System.out.println(Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory());
        Thread.sleep(SLEEP_TIME);
    }
}
