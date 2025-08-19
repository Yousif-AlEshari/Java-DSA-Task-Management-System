import java.util.Arrays;
import java.util.Random;
public class EnhancedSelectionSort {

	public static void enhancedSelectionSort(int[] arr) {
        int n = arr.length;
        
        //initialize left and right pointers which define the range of the unsorted section.
        int left = 0, right = n - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            //find the minimum and maximum items in the unsorted section.
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }

            //swap min element with the element at the current left index.
            swap(arr, minIndex, left);
            
            //if element at the minIndex was maximum, we need to update the maxIndex
            if (maxIndex == left) {
                maxIndex = minIndex;  // Update maxIndex to the index of min, which was swapped to left
            }

            //swap max element with element at the current right index.
            swap(arr, maxIndex, right);

            //narrow the range of the unsorted section.
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
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
    	Random random = new Random();
       int [] SmallArray = new int [1000000];
       for( int i=0; i<SmallArray.length;i++) {
    	   SmallArray[i] = random.nextInt(365) + 1;
       }
       
       System.out.println("Before "+  Arrays.toString(SmallArray));
       mergeSort(SmallArray);
       reverseArray(SmallArray);
       System.out.println("Before Selection "+  Arrays.toString(SmallArray));
       long begin = System.currentTimeMillis();
       enhancedSelectionSort(SmallArray);
       long stop = System.currentTimeMillis();
       System.out.println("After "+ Arrays.toString(SmallArray));
       long totalTime = stop - begin;
       System.out.println("Time to complete = " + totalTime);
    }
}
