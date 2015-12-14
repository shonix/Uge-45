public class IntTreeNode {

	public IntTreeNode left;
	public IntTreeNode right;
	public int data;


	public IntTreeNode(int newItem) {
		data = newItem;
		left = null;
		right= null;
	}
	
	public IntTreeNode(int n, IntTreeNode buildTreeL, IntTreeNode buildTreeR) {
		data = n;
		left = buildTreeL;
		right= buildTreeR;

	}

}
