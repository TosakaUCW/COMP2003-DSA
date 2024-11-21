public class Node{
	private int key;
	private int height;
	private Node left, right;
	public Node(int key) {
		this.key = key;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	

	public int getKey() {return key;}
	public int getHeight() {return height;}
	public Node getLeft() {return left;}
	public Node getRight() {return right;}
	public static int getHeight(Node node) {return node==null?-1:node.height;}	

	public void updateHeight() {
		int lheight = left==null?-1:left.height;
		int rheight = right==null?-1:right.height;
		height = (lheight>rheight?lheight:rheight)+1;
	}
	public void setkey(int key) {this.key= key;}
	public void setLeft(Node node) {left = node;}
	public void setRight(Node node) {right= node;}

    /** Get text to be printed */
	public String getText() {return String.valueOf(key)+"|"+String.valueOf(height);}
}