import java.util.*;
class BinaryTree
{
	private Node root;
	private static class Node{
		private int val;
		private Node left,right;
		private Node(int val){
			this.val=val;
			this.left=null;
			this.right=null;
		}
	}
	public void insert(Scanner sc) {
		System.out.println("Enter the root element : " );
		int val=sc.nextInt();
	     Node root=new Node(val);
	     this.root=root;
	     insert(sc,root);
	    
	}
	private void insert(Scanner sc,Node node) 
	{
		System.out.println("Do you want to insert at left of :  "+node.val +" : ");
		boolean left=sc.nextBoolean();
		if(left) 
		{
			System.out.println("Enter the left element : " );
			int val=sc.nextInt();
			Node lf=new Node(val);
			node.left=lf;
			insert(sc,lf);
		}
		System.out.println("Do you want to insert at right of :  "+node.val +" : ");
		boolean right=sc.nextBoolean();
		if(right) 
		{
			System.out.println("Enter the right element : " );
			int val=sc.nextInt();
			Node rt=new Node(val);
			node.right=rt;
			insert(sc,rt);
		}
	}
	public void display() {
		display(this.root);
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
	
}
public class BinaryTreeImplementation {
 public static void main(String args[]) {
	 Scanner sc=new Scanner(System.in);
	BinaryTree bt=new BinaryTree();
	 bt.insert(sc);
	 bt.display();
 }
}
