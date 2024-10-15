/* Requirement:	
	(1) Complete the following codes, and auxiliary methods may be defined.
	(2) You are NOT allowed to modify the code originally given in Sorting2.java
	(3) You are NOT allowed to modify the filename of Sorting2.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
		
	*/

import java.util.*;

public class Sorting2 { /*Comparison of 2 sorting algorithms*/
	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;

            // Move elements of A[0 ... i-1] that are greater than key
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            // Place the key after the element just smaller than it.
            A[j + 1] = key;
        }
	}
	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int left, int right) {
		if (left < right) {
            // Find the mid to divide the array into two halves
            int mid = left + (right - left) / 2;

            // Sort the first and second halves
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);

            // Merge the sorted halves
            merge(A, left, mid, right);
        }
	}
	
	private static void merge(int[] A, int left, int center, int right) {
		// Calculate lengths of the two subarrays
        int n1 = center - left + 1;
        int n2 = right - center;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(A, left, L, 0, n1);
        System.arraycopy(A, center + 1, R, 0, n2);

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;

        // Merge the temporary arrays back into A[left..right]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }

        // Copy any remaining elements
        while (i < n1) {
            A[k++] = L[i++];
        }
        while (j < n2) {
            A[k++] = R[j++];
        }
	}	
	
	public static void main(String[] args) {
		/*YOUR CODE HERE, 
		1. GeneratGenerate an array A1 consisting of 10^5 random integers which are in range [0, 999]
		2. Generate another array A2 which is identical to A1
		3. Sort A1 using insertionSort and A2 using mergeSort
		4. Print the elapsed time in milliseconds during which both search functions run, respectively*/
		
        final int SIZE = 100000;
        final int RANGE = 1000;

        Random rand = new Random();

        int[] A1 = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            A1[i] = rand.nextInt(RANGE);
        }

        int[] A2 = Arrays.copyOf(A1, A1.length);

        long st1 = System.currentTimeMillis();
        insertionSort(A1);
        long ed1 = System.currentTimeMillis();
        long tim1 = ed1 - st1;

        long st2 = System.currentTimeMillis();
        mergeSort(A2);
        long ed2 = System.currentTimeMillis();
        long tim2 = ed2 - st2;

        System.out.println("Insertion Sort elapsed time: " + tim1 + " ms");
        System.out.println("Merge Sort elapsed time: " + tim2 + " ms");
	}

}