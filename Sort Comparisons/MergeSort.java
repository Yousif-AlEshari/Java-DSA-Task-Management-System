import java.util.Arrays;
import java.util.Random;
public class MergeSort {

	
	
	public static void merge(int [] L, int [] R, int [] Arr) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i<L.length && j< R.length) {
			if(L[i] < R[j]) {
				Arr[k++] = L[i++];
			} else {
				Arr[k++] = R[j++];
			}
		}
		
		while (j<R.length) {
			Arr[k++] = R[j++];
		}
		
		while(i<L.length) {
			Arr[k++] = L[i++];
		}
	}
	
	
	public static void mergeSort(int [] A) {
		if(A.length<2)
			return;
		
		int mid = A.length/2;
		int [] L = new int[mid];
		int [] R = new int[A.length - mid]; //sometimes the size of the array is odd
		
		//fill the left array 
		for( int i=0; i < mid; i++) {
			L[i] = A[i];
			
		}
		
		// fill the right array
		for( int j =mid; j<A.length; j++) {
			R [j-mid] = A[j];
		}
		
		mergeSort(L);
		mergeSort(R);
		
		
		merge(L,R, A);
	}
	
	
	public static void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
	
	
	public static void main(String[] args) {
		
		int [] SmallArray = new int[100000];
		int [] BigArray = new int [10000000];
		
		Random random = new Random();  // Create a Random object for generating numbers

		
		for (int i = 0; i<BigArray.length; i++) {
			BigArray[i] = random.nextInt(365) + 1;
		}
		//long sum= 0;
		//for(int i=0;i<25;i++)
		{
			for (int j = 0; j < SmallArray.length; j++) {
				SmallArray[j] = random.nextInt(365) + 1;  // Random number between 1 and 365
			}
			
			System.out.println("Before "+Arrays.toString(SmallArray));
			mergeSort(SmallArray);
			reverseArray(SmallArray);
			System.out.println("Before sorting "+Arrays.toString(SmallArray));
			long begin = System.currentTimeMillis();
			mergeSort(SmallArray);
			long stop = System.currentTimeMillis();
			System.out.println("After "+Arrays.toString(SmallArray));
			long time = stop - begin;
			//sum+=time;
			System.out.println("Total time to sort the Array = " + time);
			System.out.println(" ");
		}
		//System.out.println("Average time to sort the array over 25 tries = " + sum/25);
		/*System.out.println("Before "+Arrays.toString(BigArray));
		long start = System.currentTimeMillis();
		mergeSort(BigArray);
		long finish = System.currentTimeMillis();
		System.out.println("After "+Arrays.toString(BigArray));
		long timeElapsed = finish - start;
		System.out.println("Total time to sort the Array = " + timeElapsed);
		System.out.println(" ");
		*/
	}

}
