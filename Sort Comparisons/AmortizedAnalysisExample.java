import java.util.ArrayList;

public class AmortizedAnalysisExample {

    public static void main(String[] args) {
        ArrayList<Integer> dynamicArray = new ArrayList<>(1);
        int n = 100000; // Number of elements to add

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dynamicArray.add(i);
        }
        long endTime = System.nanoTime();

        System.out.println("Total time to add " + n + " elements: " + (endTime - startTime) + " ns");
        
        // Analyze amortized time
        double amortizedTime = (endTime - startTime) / (double) n;
        System.out.println("Amortized time per add operation: " + amortizedTime + " ns");
    }
}
