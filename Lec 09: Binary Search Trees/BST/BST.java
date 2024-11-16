/* Requirement:
	(1) Complete the following codes, and you may add auxiliary functions if necessary
	(2) You are NOT allowed to modify the code originally given in BST.java, Node.java and BinaryTreePrinter.java 
	(3) You are NOT allowed to modify the filename of BST.java, Node.java and BinaryTreePrinter.java 
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in BST.java:
	
		The initial tree is empty:
		Empty tree!

		After inserting 10:
		  10  

		After inserting 5:
			 10     
		   ┌──┘     
		   5        

		After inserting 15:
			 10     
		   ┌──┴──┐  
		   5    15  

		After inserting another 15 (which should fail):
			 10     
		   ┌──┴──┐  
		   5    15  

		After inserting 9, 13:
				   10           
			  ┌─────┴─────┐     
			  5          15     
			  └──┐     ┌──┘     
				 9    13        

		After inserting 2, 6, 12, 14:
							   10                       
					┌───────────┴───────────┐           
					5                      15           
			  ┌─────┴─────┐           ┌─────┘           
			  2           9          13                 
					   ┌──┘        ┌──┴──┐              
					   6          12    14              

		Searching for 10, 6, 13, 14, 1, 3, 11, 16:
		true
		true
		true
		true
		true
		true
		true
		true

		After deleting 12 (which has no children):
							   10                       
					┌───────────┴───────────┐           
					5                      15           
			  ┌─────┴─────┐           ┌─────┘           
			  2           9          13                 
					   ┌──┘           └──┐              
					   6                14              

		After deleting 13 (which has a right child):
							   10                       
					┌───────────┴───────────┐           
					5                      15           
			  ┌─────┴─────┐           ┌─────┘           
			  2           9          14                 
					   ┌──┘                             
					   6                                

		After deleting 9 (which has a left child):
				   10           
			  ┌─────┴─────┐     
			  5          15     
		   ┌──┴──┐     ┌──┘     
		   2     6    14        

		After deleting 5 (which has two children):
				   10           
			  ┌─────┴─────┐     
			  6          15     
		   ┌──┘        ┌──┘     
		   2          14        

		After deleting 10 (which has two children):
				   14           
			  ┌─────┴─────┐     
			  6          15     
		   ┌──┘                 
		   2                    

		
	*/
public class BST {
	Node root;

	public BST() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insertNode(int x) {
		root = insertNode(root, x);
	}

	protected Node insertNode(Node root, int x) {
		/**
		 * insertNode inserts a key "x" into a subtree whose root is "root" 
		 * input: 
		 * root - the root of the subtree 
		 * x - the key to be inserted 
		 * output: 
		 * the (updated) root of the subtree
		 */
		/*YOUR CODE HERE*/
		return root;
	}

	public Node findNode(int x) {
		return findNode(root, x);
	}

	protected Node findNode(Node root, int x) {
		/**
		 * findNode returns a node whose key is "x" in a subtree whose root is "root"
		 * input: 
		 * root - the root of the subtree 
		 * x - the key to be found 
		 * output: 
		 * a node whose key is "x", or null if "x" is not found
		 */
		/*YOUR CODE HERE*/
		return root;
	}

	public void deleteNode(int x) {
		root = deleteNode(root, x);
	}

	protected Node deleteNode(Node root, int x) {
		/**
		 * deleteNode deletes the node whose key is "x" from a subtree whose root is
		 * "root" 
		 * input: 
		 * root - the root of the subtree 
		 * x - the key of the node to be deleted
		 * output:
		 * the (updated) root of the subtree
		 */
		/*YOUR CODE HERE*/
		return root;
	}

	public static void main(String[] args) {
		BST bst = new BST();
		System.out.println("The initial tree is empty:");
		BinaryTreePrinter.printTree(bst);

		System.out.println("After inserting 10:");
		bst.insertNode(10);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 5:");
		bst.insertNode(5);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 15:");
		bst.insertNode(15);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting another 15 (which should fail):");
		bst.insertNode(15);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 9, 13:");
		bst.insertNode(9);
		bst.insertNode(13);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter inserting 2, 6, 12, 14:");
		bst.insertNode(2);
		bst.insertNode(6);
		bst.insertNode(12);
		bst.insertNode(14);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nSearching for 10, 6, 13, 14, 1, 3, 11, 16:");
		System.out.println(bst.findNode(10) != null && bst.findNode(10).getKey() == 10 ? "true" : "false");
		System.out.println(bst.findNode(6) != null && bst.findNode(6).getKey() == 6 ? "true" : "false");
		System.out.println(bst.findNode(13) != null && bst.findNode(13).getKey() == 13 ? "true" : "false");
		System.out.println(bst.findNode(14) != null && bst.findNode(14).getKey() == 14 ? "true" : "false");
		System.out.println(bst.findNode(1) == null ? "true" : "false");
		System.out.println(bst.findNode(3) == null ? "true" : "false");
		System.out.println(bst.findNode(11) == null ? "true" : "false");
		System.out.println(bst.findNode(16) == null ? "true" : "false");

		System.out.println("\nAfter deleting 12 (which has no children):");
		bst.deleteNode(12);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 13 (which has a right child):");
		bst.deleteNode(13);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 9 (which has a left child):");
		bst.deleteNode(9);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 5 (which has two children):");
		bst.deleteNode(5);
		BinaryTreePrinter.printTree(bst);

		System.out.println("\nAfter deleting 10 (which has two children):");
		bst.deleteNode(10);
		BinaryTreePrinter.printTree(bst);
	}
}
