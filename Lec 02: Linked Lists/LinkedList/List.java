/* Requirement:
	(1) UML of List(02 Linked Lists.pptx, page 15):
		|-----------------------------------------------|
		|					 List                       |
		|-----------------------------------------------|
		|   - head: Node                                |
		|-----------------------------------------------|
		|   + List()                                    |
		|   + isEmpty(): boolean                        |
		|   + insertNode(int index, double x): Node     |
		|   + findNode(double x): Node                  |
		|   + removeNode(double x): Node                |
		|   + displayList(): void                       |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in List.java, Node.java
	(3) You are NOT allowed to modify the filename of List.java, Node.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in List.java:
	
		true
		Data of head: 1.0
		1.0
		1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		2.0
		3.0 -> 2.0
		3.0 -> 2.0
		
	*/

public class List {

	private Node head;

	public List() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node insertNode(int index, double x) {
		// illegle input
		if (index < 0) {
			return null;
		}

		// try to find the position to insert
		int curIndex = 1;
		Node curNode = this.head;
		while (curNode != null && index > curIndex) {
			curNode = curNode.getNext();
			curIndex++;
		}
		
		// the node does not exist
		if (index > 0 && curNode == null) {
			return null;
		}

		Node newNode = new Node(x);

		if (index == 0) {
			// insert as a new head
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			// insert after curNode
			newNode.setNext(curNode.getNext());
			curNode.setNext(newNode);
		}

		return newNode;
	}

	public void displayList() {
		Node cur = head;
		
		// traverse the LinkedList
		while (cur != null) {
			System.out.print(cur.getData());
			
			if (cur.getNext() != null) {
				System.out.print(" -> ");
			}
			
			cur = cur.getNext();
		}
		
		System.out.println();
	}
	
	public Node findNode(double x) {
		Node cur = head;
		
		// try to find the node
		while (cur != null) {
			if (cur.getData() == x) {
				return cur;
			}
			cur = cur.getNext();
		}
		
		// no such node exists
		return null;
	}
	
	public Node removeNode(double x) {
		
		// ... -> pre -> cur -> ...
		Node pre = null;
		Node cur = head;
		
		// try to find the position to remove
		while (cur != null) {
			
			if (cur.getData() == x) {
				if (pre == null) {
					head = cur.getNext();
				} else {
					pre.setNext(cur.getNext());
				}
				return cur;
			}
			
			pre = cur;
			cur = cur.getNext();
		}
		
		// no such node exists
		return null;
	}

	public static void main(String[] args) {
		List myList = new List();
		System.out.println(myList.isEmpty());
		myList.insertNode(0, 1);
		System.out.println("Data of head: " + myList.head.getData());
		myList.displayList();
		myList.insertNode(1, 2);
		myList.displayList();
		myList.insertNode(0, 3);
		myList.displayList();
		myList.insertNode(4, 4);
		myList.displayList();
		myList.insertNode(-4, 5);
		myList.displayList();
		System.out.println(myList.findNode(2).getData());
		myList.removeNode(1);
		myList.displayList();
		myList.removeNode(4);
		myList.displayList();
	}

}
