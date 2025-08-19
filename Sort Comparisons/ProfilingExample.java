import java.util.Random;

public class ProfilingExample {

    public static void merge(int[] L, int[] R, int[] A) {
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < L.length) {
            A[k++] = L[i++];
        }
        while (j < R.length) {
            A[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] A) {
        if (A.length < 2)
            return;
        
        int mid = A.length / 2;
        int[] L = new int[mid];
        int[] R = new int[A.length - mid];

        for (int i = 0; i < mid; i++) {
            L[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            R[i - mid] = A[i];
        }

        long startTime = System.nanoTime(); // Profiling: start time for sorting left part
        mergeSort(L);
        long endTime = System.nanoTime();
        System.out.println("Time to sort left part: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime(); // Profiling: start time for sorting right part
        mergeSort(R);
        endTime = System.nanoTime();
        System.out.println("Time to sort right part: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime(); // Profiling: start time for merging
        merge(L, R, A);
        endTime = System.nanoTime();
        System.out.println("Time to merge: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(365) + 1;
        }

        long startTime = System.currentTimeMillis();
        mergeSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time to sort the array: " + (endTime - startTime) + " ms");
    }
}
