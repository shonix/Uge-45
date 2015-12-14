public class IntSearchTree {
	private IntSearchTree(){
		System.out.println(buildTree(1,100));
	}
	private IntTreeNode buildTree(int n, int max){
		if(n>max){
			return null;
		}else{
			return new IntTreeNode((int)Math.random()*100,buildTree(2*n,max),buildTree(2*n+1,max));
			
		}
	}
}