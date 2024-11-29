/*Part 2*/
public class BST{
	/*Your code here.*/
	Node root;

	public BST() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insertNode(Student x) {
		root = insertNode(root, x);
	}

	protected Node insertNode(Node root, Student x) {
		/**
		 * insertNode inserts a key "x" into a subtree whose root is "root" input: root
		 * - the root of the subtree x - the key to be inserted output: the (updated)
		 * root of the subtree
		 */
		// Note that the root here is a parameter, not the class member "root"

		if (root == null) { // insert the new node right here
			return new Node(x);
		}
		if (x.id < root.getKey()) // try to insert in the left subtree
			root.setLeft(insertNode(root.getLeft(), x));
		else if (x.id > root.getKey())// try to insert in the right subtree
			root.setRight(insertNode(root.getRight(), x));
		// note that if x==root.getKey(), nothing is done
		return root;
	}

	public Node findNode(int x) {
		return findNode(root, x);
	}

	protected Node findNode(Node root, int x) {
		/**
		 * findNode returns a node whose key is "x" in a subtree whose root is "root"
		 * input: root - the root of the subtree x - the key to be found output: a node
		 * whose key is "x", or null if "x" is not found
		 */
		if (root == null)
			return null;
		if (x < root.getKey())
			return findNode(root.getLeft(), x);
		if (x > root.getKey())
			return findNode(root.getRight(), x);
		return root;
	}

	public void deleteNode(int x) {
		root = deleteNode(root, x);
	}

	protected Node deleteNode(Node root, int x) {
		/**
		 * deleteNode deletes the node whose key is "x" from a subtree whose root is
		 * "root" input: root - the root of the subtree x - the key of the node to be
		 * deleted output: the (updated) root of the subtree
		 */
		// Return if the tree is empty
		if (root == null)
			return root;
		if (x < root.getKey()) // try to delete in the left subtree
			root.setLeft(deleteNode(root.getLeft(), x));
		else if (x > root.getKey()) // try to delete in the right subtree
			root.setRight(deleteNode(root.getRight(), x));
		else {
			// delete the root
			if (root.getLeft() == null) // root has no left child, pass the right child to grandparent
				return root.getRight();
			if (root.getRight() == null) // root has no right child, pass the left child to grandparent
				return root.getLeft();
			// root has two children, replace root with the minimum node in its left subtree
			root.setStudent(minStudent(root.getRight()));
			// delete the minimum node in its left subtree
			root.setRight(deleteNode(root.getRight(), root.getKey()));
		}
		return root;
	}

	public Student minStudent(Node root) {
		// returns the minimum key in a subtree whose root is "root"
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root.getStudent();
	}
}