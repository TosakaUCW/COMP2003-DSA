/* Requirement:
	(1) UML of Queue(04 Queues.pptx, page 21):
		|-----------------------------------------------|
		|                    Queue                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - front: int                                |
		|   - rear: int                                 |
		|   - counter: int                              |		
		|-----------------------------------------------|
		|   + Queue(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + enqueue(Double x): Double                 |
		|   + dequeue(): Double                         |
		|   + displayQueue(): void                      |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in Queue.java
	(3) You are NOT allowed to modify the filename of Queue.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Queue.java:
	
		true
		The queue has 3 items: -2, 3, 1
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|<-rear
		The queue has 4 items: -2, 3, 1, 8
		true
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|
			    |	  8.0000	|<-rear
		The queue has 2 items: 1, 8
		front->	|	  1.0000	|
			    |	  8.0000	|<-rear
		The queue is empty:
		Empty queue!
		
	*/
public class CircularDeque {

	private int front; // front of the queue
	private int rear; // rear of the queue
	private int counter; // Number of elements in the queue
	private Integer[] values; // Array to store queue elements

	public CircularDeque(int size) {
		values = new Integer[size];
		front = 0;
		rear = -1;
		counter = 0;
	}

	public boolean isEmpty() {
		// Queue is empty if counter is 0
		return counter == 0;
	}

	public boolean isFull() {
		// Queue is full if counter equals array size
		return counter == values.length;
	}

	public Integer insertFront(int x) {
		if (isFull()) {
			// if full, cannot insert element
			return null;
		}

		front = (front - 1 + values.length) % values.length; // update the front position
		values[front] = x; // insert element
		counter++; // update counter
		return values[front];
	}

	public Integer insertLast(int x) {
		if (isFull()) {
			// if full, cannot insert element
			return null;
		}

		rear = (rear + 1) % values.length; // update the rear position
		values[rear] = x; // insert element
		counter++; // update counter
		return values[rear];
	}

	public Integer deleteFront() {
		if (isEmpty()) {
			// if empty, cannot delete
			return null;
		}

		Integer dequeuedValue = values[front];
		front = (front + 1) % values.length; // update the front position
		counter--; // update counter
		return dequeuedValue;
	}

	public Integer deleteLast() {
		if (isEmpty()) {
			// if empty, cannot delete
			return null;
		}

		Integer dequeuedValue = values[rear];
		rear = (rear - 1 + values.length) % values.length; // update the rear position
		counter--; // update counter
		return dequeuedValue;
	}

	public void displayCircularDeque() {
		if (isEmpty()) {
			System.out.println("Empty queue!");
			return;
		}

		System.out.print("front->");

		for (int i = 0; i < counter; i++) {

			int index = (front + i) % values.length;

			if (i == counter - 1) {
				// Indicate rear at the end of the display
				System.out.printf("\t|%8d\t|<-rear\n", values[index]);
			} else {
				System.out.printf("\t|%8d\t|\n", values[index]);
			}
		}
	}

	public static void main(String[] args) {
		CircularDeque myDeque = new CircularDeque(4);

		// test insert
		myDeque.insertLast(3);
		myDeque.insertLast(5);
		myDeque.insertFront(2);
		myDeque.insertFront(7);
		System.out.println("The deque has 4 items: 7, 2, 3, 5");
		myDeque.displayCircularDeque();
		System.out.println();

		// test delete
		myDeque.deleteFront();
		myDeque.deleteLast();
		System.out.println("The deque has 2 items: 2, 3");
		myDeque.displayCircularDeque();
		System.out.println();

		// continue test delete
		myDeque.deleteFront();
		myDeque.deleteLast();
		System.out.println("The deque is empty:");
		myDeque.displayCircularDeque();

	}
}
