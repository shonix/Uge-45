//Simple binary tree class that includes methods to construct a
//tree of ints, to print the structure, and to print the data
//using a preorder, inorder or postorder traversal.  The trees
//built have nodes numbered starting with 1 and numbered
//sequentially level by level with no gaps in the tree.  The
//documentation refers to these as "sequential trees."
import java.util.*;

public class IntTree {
	private IntTreeNode overallRoot;

	public void print() {

		hPrint(overallRoot);
		System.out.println();

	};

	private void hPrint(IntTreeNode t) {
		if (!(t == null)) {
			hPrint(t.left);
			System.out.print(t.data + ", ");
			hPrint(t.right);
		}

	};

	// pre : max > 0
	// post: constructs a sequential tree with given number of
	// nodes
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}
	}

	// post: returns a sequential tree with n as its root unless
	// n is greater than max, in which case it returns an
	// empty tree
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode((int) (Math.random() * 100), buildTree(
					2 * n, max), buildTree(2 * n + 1, max));
		}
	}

	public void add(IntTreeNode currNode, int valueToAdd) {
		if (overallRoot == null) {
			overallRoot = new IntTreeNode(valueToAdd);
		} else if (currNode.data == valueToAdd) {
			System.out.println("u dun goofed");
		} else if (currNode.data < valueToAdd) {
			if (currNode.right == null) {
				currNode.right = new IntTreeNode(valueToAdd);
			} else {
				add(currNode.right, valueToAdd);
			}
		} else if (currNode.data > valueToAdd) {
			if (currNode.left == null) {
				currNode.left = new IntTreeNode(valueToAdd);
			} else {
				add(currNode.left, valueToAdd);
			}
		}
	}

	public IntTreeNode getMin(){
		if(overallRoot == null){
			throw new NoSuchElementException();
		}
		return getMin(overallRoot);
		}
	
	public IntTreeNode getMin(IntTreeNode root){
		if(root.left == null){
			return root.left;
		}else{
			return root.right;
		}
	}
	
	
	// post: prints the tree contents using a preorder traversal
	public void printPreorder() {
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}

	// post: prints the tree contents using a preorder traversal
	// post: prints in preorder the tree with given root
	private void printPreorder(IntTreeNode root) {
		if (root != null) {
			System.out.print(" " + root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// post: prints the tree contents using a inorder traversal
	public void printInorder() {
		System.out.print("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntTreeNode r) {
		if (r != null) {
			printInorder(r.left);
			// exercise 17.4
			// if (!(r.left == null && r.right == null)) {
			// if (r.data % 2 == 0)
			System.out.print(" " + r.data);
			// }
			printInorder(r.right);
		}
	}

	// post: prints the tree contents using a postorder traversal
	public void printPostorder() {
		System.out.print("postorder:");
		printPostorder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the tree with given root
	private void printPostorder(IntTreeNode root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" " + root.data);
		}
	}

	// post: prints the tree contents, one per line, following an
	// inorder traversal and using indentation to indicate
	// node depth; prints right to left so that it looks
	// correct when the output is rotated.
	public void printSideways() {
		printSideways(overallRoot, 10);
	}

	// post: prints in reversed inorder the tree with given
	// root, indenting each line to the given level
	private void printSideways(IntTreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}
	public IntTreeNode getOverallRoot(){
		return overallRoot;
	}
}