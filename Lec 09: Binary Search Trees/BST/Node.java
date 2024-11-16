public class Node{
	private int key;
	private Node left, right;
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	

	public int getKey() {return key;}
	public Node getLeft() {return left;}
	public Node getRight() {return right;}

	public void setkey(int key) {this.key= key;}
	public void setLeft(Node node) {left = node;}
	public void setRight(Node node) {right= node;}

    /** Get text to be printed */
	public String getText() {return String.valueOf(key);}
}