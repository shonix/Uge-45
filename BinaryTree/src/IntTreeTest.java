public class IntTreeTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntTree iT =new IntTree(15);
		for(int i = 0; i<15; i++){
		iT.add(iT.getOverallRoot(),(int)(Math.random()*100));}
//		iT.print();
		
		iT.printInorder();
		iT.printPostorder();
		iT.printPreorder();
		iT.printSideways();
	}

}
