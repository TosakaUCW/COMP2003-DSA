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
		|   + enqueue(double x): Double                 |
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
public class Queue {

	private int front; // front of the queue
	private int rear; // rear of the queue
	private int counter; // Number of elements in the queue
	private Double[] values; // Array to store queue elements

	public Queue(int size) {
		values = new Double[size];
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

	public Double enqueue(double x) {
		if (isFull())
			return null;

		rear = (rear + 1) % values.length; // Move rear
		values[rear] = Double.valueOf(x);

		counter++; // Update the counter
		return values[rear];
	}

	public Double dequeue() {
		if (isEmpty())
			return null;

		// Get dequeued value
		Double dequeuedValue = values[front];

		front = (front + 1) % values.length; // Move front
		counter--; // Update the counter
		return dequeuedValue;
	}

	public void displayQueue() {
		if (isEmpty()) {
			System.out.println("Empty queue!");
			return;
		}

		System.out.print("front->");

		for (int i = 0; i < counter; i++) {

			int index = (front + i) % values.length;

			if (i == counter - 1) {
				// Indicate rear at the end of the display
				System.out.printf("\t|   %8.4f\t|<-rear\n", values[index]);
			} else {
				System.out.printf("\t|   %8.4f\t|\n", values[index]);
			}
		}
	}

	public static void main(String[] args) {
		Queue myQueue = new Queue(4);
		System.out.println(myQueue.isEmpty());
		myQueue.enqueue(-2);
		myQueue.enqueue(3);
		myQueue.enqueue(1);
		System.out.println("The queue has 3 items: -2, 3, 1");
		myQueue.displayQueue();
		myQueue.enqueue(8);
		myQueue.enqueue(6);
		System.out.println("The queue has 4 items: -2, 3, 1, 8");
		System.out.println(myQueue.isFull());
		myQueue.displayQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue has 2 items: 1, 8");
		myQueue.displayQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue is empty:");
		myQueue.displayQueue();

	}
}
