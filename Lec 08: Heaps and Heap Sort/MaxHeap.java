
/* Requirement:
	(1) UML of MaxHeap(08 Heaps and Heapsort.pptx, page 40):
		|-----------------------------------------------|
		|                    MaxHeap                    |
		|-----------------------------------------------|
		|   - A: int[]                                  |
		|   - size: int                                 |
		|-----------------------------------------------|
		|   + MaxHeap(int A[])                          |
		|   + insert(int x): boolean                    |
		|   + deleteMax(): int                          |
		|   + heapSort(int A[]): static void            |
		|   + main(): static void                       |
		|-----------------------------------------------|
	* Note: Underline is always used to show methods or variables which are static in UML. But the 
	underline cannot be typed out in code editor, so we use another way to tell you about that.
	
	(2) You are NOT allowed to modify the code originally given in MaxHeap.java
	(3) You are NOT allowed to modify the filename of MaxHeap.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5) The class name, variable names and method names should STRICTLY follow the UML above
	(6)	You should add some comments and indentations to make the codes user friendly
		
	*/
import java.util.*;

public class MaxHeap {
	int A[];
	int size;

	public MaxHeap(int A[]) {
		this.A = new int[A.length];
		// this.size = A.length;

		for (int i = 0; i < A.length; i++) {
			insert(A[i]);
		}
	}

	public boolean insert(int x) {
		if (size == A.length) {
			return false; // Heap is full
		}

		// Percolate up
		// Fix the max heap property
		int hole = size++;
		while (hole > 0 && x > A[(hole - 1) / 2]) {
			A[hole] = A[(hole - 1) / 2];
			hole = (hole - 1) / 2;
		}
		A[hole] = x;
		return true;
	}

	public int deleteMax() {
		if (size <= 0) {
			return -1;
		}

		int max = A[0];
		int x = A[--size];
		int hole = 0;

		while (hole * 2 + 1 < size) { // While A[hole] has a children
			int child = hole * 2 + 1; // Left children index

			// Check if there is a right child and if it is larger
			if (child + 1 < size && A[child + 1] > A[child]) {
				child++;
			}

			// If x is larger or equal, it's done
			if (x >= A[child]) {
				break;
			}

			// Move the larger child up
			A[hole] = A[child];
			hole = child;
		}

		A[hole] = x;
		return max;
	}

	public static void heapSort(int A[]) {
		MaxHeap heap = new MaxHeap(A);

		for (int i = A.length - 1; i >= 0; i--) {
			A[i] = heap.deleteMax();
		}
	}

	public static void main(String[] args) {

		/*
		 * YOUR CODE HERE,
		 * - Generate an array A consisting of 10^5 random integers which are in range
		 * [0, 999]
		 * - Sort A using heapSort
		 * - Print the elapsed time in milliseconds during which the sort function runs
		 * .
		 */

		int n = 100000;
		int[] A = new int[n];
		Random rand = new Random();

		// Generate an array of 10^5 random integers in the range [0, 999]
		for (int i = 0; i < n; i++) {
			A[i] = rand.nextInt(1000);
		}

		// for (int i = 0; i < n; i++) {
		// System.out.println(A[i]);
		// }

		// Record start time
		long startTime = System.currentTimeMillis();

		// Sort the array using heapSort
		heapSort(A);

		// Record end time
		long endTime = System.currentTimeMillis();

		// System.out.println("------------");
		// for (int i = 0; i < n; i++) {
		// System.out.println(A[i]);
		// }

		// Print the elapsed time in milliseconds
		System.out.println("Elapsed time for heapSort: " + (endTime - startTime) + " ms");

	}

}