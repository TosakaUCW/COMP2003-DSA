/*Part 2*/
public class AVLTree extends BST{
	/*Your code here.*/
	Node root;

	public AVLTree() {
		super();
	}

    // Get the balance factor of a node
    private int getBalance(Node node) {
        return node == null ? 0 : Node.getHeight(node.getLeft()) - Node.getHeight(node.getRight());
    }
	
	private Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.updateHeight();
        x.updateHeight();

        return x;
    }
	
	private Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.updateHeight();
        y.updateHeight();

        return y;
    }
	
	private Node rebalance(Node root) {
		int balance = getBalance(root);
		
		// If balanced, return
		if (-2 < balance && balance < 2) {
			return root;
		}
		
		// If unbalanced, perform rotations
		if (balance > 1 && getBalance(root.getLeft()) >= 0) { // Left-Left case
            return rotateRight(root);
        }
        if (balance > 1 && getBalance(root.getLeft()) < 0) { // Left-Right case
            root.setLeft(rotateLeft(root.getLeft()));
            root = rotateRight(root);
        }
        if (balance < -1 && getBalance(root.getRight()) <= 0) { // Right-Right case
            return rotateLeft(root);
        }
        if (balance < -1 && getBalance(root.getRight()) > 0) { // Right-Left case
            root.setRight(rotateRight(root.getRight()));
            root = rotateLeft(root);
        }
		
		return root;
	}

	public Node insertNode(Node root, int x) {
		/**
		 * insertNode inserts a key "x" into a subtree whose root is "root" 
		 * input:	root - the root of the subtree
		 * 			x - the key to be inserted
		 * output: the (updated) root of the subtree
		 */
		root = super.insertNode(root, x);
		
		// Update the height of the current node
		root.updateHeight();
		
		// Rebalance the tree
		root = rebalance(root);
		
		return root;
	}

	public Node deleteNode(Node root, int x) {
		/**
		 * deleteNode deletes the node whose key is "x" from a subtree whose root is "root"
		 * input: 	root - the root of the subtree 
		 * 			x - the key of the node to be deleted
		 * output: the (updated) root of the subtree
		 */
		root = super.deleteNode(root, x);
		
		if (root != null) {
			root.updateHeight();
			root = rebalance(root);
		}
		
		return root;
	}
}