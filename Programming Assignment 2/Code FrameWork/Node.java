/*Part 2*/
public class Node{
	/*Your code here.*/
	private Student student; // Holds a Student object
	private int height;
	private Node left, right;
	public Node(Student student) {
		this.student = student;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	public Node(int x) {
		this.student.id = x;
		this.height = 0;
		this.left = null;
		this.right = null;
	}
	

	public Student getStudent() {return student;}
	public int getKey() {return student.id;}
	public int getHeight() {return height;}
	public Node getLeft() {return left;}
	public Node getRight() {return right;}
	public static int getHeight(Node node) {return node==null?-1:node.height;}	

	public void updateHeight() {
		int lheight = left==null?-1:left.height;
		int rheight = right==null?-1:right.height;
		height = (lheight>rheight?lheight:rheight)+1;
	}
	public void setStudent(Student student) {this.student= student;}
	public void setLeft(Node node) {left = node;}
	public void setRight(Node node) {right= node;}

    /** Get text to be printed */
	// public String getText() {return String.valueOf(key)+"|"+String.valueOf(height);}
}