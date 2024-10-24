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

	// Begin Programming Assignment 1

	public int removeNodes(double x) {
		// ... -> pre -> cur -> ...
		Node pre = null;
		Node cur = head;
		int counter = 0;

		// try to find the position to remove
		while (cur != null) {

			if (cur.getData() == x) {
				if (pre == null) {
					head = cur.getNext();
				} else {
					pre.setNext(cur.getNext());
				}

				cur = cur.getNext();
				counter++;

				continue;
			}

			pre = cur;
			cur = cur.getNext();
		}

		return counter;
	}

	public void removeDuplicates() {
		if (head == null) {
			return; // 如果链表为空，直接返回
		}

		// create a vitrual head node
		Node dummy = new Node(0);
		dummy.setNext(head);

		Node prev = dummy;
		Node cur = head;

		while (cur != null) {
			boolean isDuplicate = false;

			while (cur.getNext() != null && cur.getData() == cur.getNext().getData()) {
				cur = cur.getNext();
				isDuplicate = true;
			}

			// if isDuplicate, then skip the node
			if (isDuplicate) {
				prev.setNext(cur.getNext());
			} else {
				prev = cur;
			}

			cur = cur.getNext();
		}

		head = dummy.getNext();
	}

	public void ReverseList() {
		if (head == null || head.getNext() == null) {
			return; // 如果链表为空或者只有一个节点，直接返回
		}

		Node prev = null; // 前一个节点，初始化为 null
		Node cur = head; // 当前节点，初始化为头节点
		Node next = null; // 下一个节点的指针

		while (cur != null) {
			next = cur.getNext(); // 保存下一个节点
			cur.setNext(prev); // 将当前节点的next指向前一个节点
			prev = cur; // 将prev移动到当前节点
			cur = next; // 继续遍历下一个节点
		}

		head = prev; // 反转结束后，prev是新的头节点
	}

	// End Programming Assignment 1

	public static void main(String[] args) {
		List myList = new List();
		// System.out.println(myList.isEmpty());
		// myList.insertNode(0, 1);
		// System.out.println("Data of head: " + myList.head.getData());
		// myList.displayList();
		// myList.insertNode(1, 2);
		// myList.displayList();
		// myList.insertNode(0, 3);
		// myList.displayList();
		// myList.insertNode(4, 4);
		// myList.displayList();
		// myList.insertNode(-4, 5);
		// myList.displayList();
		// System.out.println(myList.findNode(2).getData());
		// myList.removeNode(1);
		// myList.displayList();
		// myList.removeNode(4);
		// myList.displayList();

		// === removeNodes ===
		System.out.println("=== removeNodes ===");

		// test 1
		System.out.println("--- test1 ---");
		myList = new List();
		myList.insertNode(0, 2);
		myList.insertNode(1, 6);
		myList.insertNode(2, 5);
		myList.insertNode(3, 6);
		myList.displayList();
		System.out.println(myList.removeNodes(6));
		myList.displayList();

		// test 2
		System.out.println("--- test2 ---");
		myList = new List();
		myList.displayList();
		System.out.println(myList.removeNodes(6));
		myList.displayList();

		// test 3
		System.out.println("--- test3 ---");
		myList = new List();
		myList.insertNode(0, 6);
		myList.insertNode(1, 6);
		myList.insertNode(2, 6);
		myList.displayList();
		System.out.println(myList.removeNodes(6));
		myList.displayList();

		// === removeDuplicates ===
		System.out.println("=== removeDuplicates ===");

		// test 1
		System.out.println("--- test1 ---");
		myList = new List();
		myList.insertNode(0, 1);
		myList.insertNode(1, 2);
		myList.insertNode(2, 2);
		myList.insertNode(3, 4);
		myList.insertNode(4, 6);
		myList.insertNode(5, 6);
		myList.displayList();
		myList.removeDuplicates();
		myList.displayList();

		// test 2
		System.out.println("--- test2 ---");
		myList = new List();
		myList.displayList();
		myList.removeDuplicates();
		myList.displayList();

		// test 3
		System.out.println("--- test3 ---");
		myList = new List();
		myList.insertNode(0, 6);
		myList.insertNode(1, 6);
		myList.insertNode(2, 6);
		myList.insertNode(3, 7);
		myList.insertNode(4, 7);
		myList.displayList();
		myList.removeDuplicates();
		myList.displayList();

		// === reverseList ===
		System.out.println("=== reverseList ===");

		// test 1
		System.out.println("--- test1 ---");
		myList = new List();
		myList.insertNode(0, 1);
		myList.insertNode(1, 2);
		myList.insertNode(2, 3);
		myList.insertNode(3, 4);
		myList.insertNode(4, 5);
		myList.displayList();
		myList.ReverseList();
		myList.displayList();
		
		// test 2
		System.out.println("--- test2 ---");
		myList = new List();
		myList.displayList();
		myList.ReverseList();
		myList.displayList();
		
		// test 3
		System.out.println("--- test3 ---");
		myList = new List();
		myList.insertNode(0, 1);
		myList.displayList();
		myList.ReverseList();
		myList.displayList();
	}

}
