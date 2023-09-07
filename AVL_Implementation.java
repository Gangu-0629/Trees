import java.util.Scanner;



class AVL
{
	private Node root;
	private static class Node{
		private int val;
		private int height;
		private Node left,right;
		private Node(int val){
			this.val=val;
			this.left=null;
			this.right=null;
			this.height=0;
		}
	}
	public void insert(Scanner sc) {
		boolean bol=false;
		do{
	         System.out.println("Enter the element : ");
	         int val=sc.nextInt();
	         this.root=insert(this.root,val);
	         System.out.println("DO you want to insert another elemnet : ");
	         bol=sc.nextBoolean();
		}while(bol);
	}
	private Node insert(Node node,int val) 
	{
		if(node==null) {
			Node newnode=new Node(val);
			return newnode;
		}
		if(val<node.val) {
			node.left=insert(node.left,val);
		}
		if(val>node.val) {
			node.right=insert(node.right,val);
		}
		node.height=Math.max(height(node.left),height(node.right))+1;
		return rotate(node);
	}
    private Node rotate(Node node) 
    {
    	if(node.left.height-node.right.height >1) 
    	{
    		//left heavy
    		if( node.left.left.height-node.left.right.height > 0 ) {
    			//case-I left-left
    			return rightrotate(node);
    		}
    		if( node.left.left.height-node.left.right.height < 0 ) {
    			//case-II left-right
    			node.left=leftrotate(node.left);
    			return rightrotate(node);
    		}
    	}
    	if(node.left.height-node.right.height <-1) 
    	{
    		//left heavy
    		if( node.right.left.height-node.right.right.height < 0 ) {
    			//case-III right-right
    			return leftrotate(node);
    		}
    		if( node.left.left.height-node.left.right.height > 0 ) {
    			//case-IV right-left
    			node.right=rightrotate(node.right);
    			return leftrotate(node);
    		}
    	}
    	return  node;
    }
	private Node rightrotate(Node node) 
	{
		
		Node newroot=node.left;
		node.left=newroot.right;
		newroot.right=node;
		node.height=Math.max(node.left.height, node.right.height)+1;
		newroot.height=Math.max(newroot.left.height,newroot.right.height)+1;
		return newroot;
	}
	private Node leftrotate(Node node)
	{
		Node newroot=node.right;
		node.right=newroot.left;
		newroot.left=node;
		return newroot;
	}
	private int height(Node node) {
		if(node==null) return -1;
		else {
			return node.height;
		}
	}
	public void display() {
		display(this.root);
	    System.out.print("/n Inorder : ");
	    inorder(this.root);
	    System.out.print("/n Preorder : ");
	    preorder(this.root);
	    System.out.print("/n Postorder : ");
	    postorder(this.root);
	}
	private void display(Node temp) {
		if(temp==null) {
			return;
		}
		else {
			display(temp.left);
			System.out.print(temp.val+" --> ");
			display(temp.right);
			
		}
	}
	private void preorder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.val+" ");
		preorder(node.left);
		preorder(node.right);
	}
	private void postorder(Node node) {
		if(node==null) {
			return;
		}
	
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val+" ");
	}
	
	private void inorder(Node node) {
		if(node==null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.val+" ");
		inorder(node.right);
	}
	public boolean balanced() {
		return balanced(this.root);
	}
	private boolean balanced(Node node) {
		if(node==null) return true;
		return Math.abs(node.left.height-node.right.height)<=1 && balanced(node.left)&& balanced(node.right);
	}
	
	
}
public class AVL_Implementation {
	 public static void main(String args[]) {
		 Scanner sc=new Scanner(System.in);
		 AVL bt=new AVL();
		 bt.insert(sc);
		 bt.display();
	 }
}
