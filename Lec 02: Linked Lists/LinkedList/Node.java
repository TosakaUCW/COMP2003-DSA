
public class Node {
	private double data;
	private Node next;
	
	public Node(double data) {
		this.data = data;
		this.next = null;
	}
	
	public double getData() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

}
