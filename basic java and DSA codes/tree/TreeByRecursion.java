package tree;

import java.util.Scanner;

class Node
{
	Node left,right;
	int data;
	public Node(int data) {
		this.data=data;
	}
	
}
public class TreeByRecursion {
static 	Node root;

	
	public static Node createTree() {
		Scanner sc=new Scanner(System.in);
		Node root=null;
		System.out.println("enter data");
		
	       int data=sc.nextInt();
		
		if(data==-1) return null;
		
		root=new Node(data);
		System.out.println("enter left for "+data);
		root.left=createTree();
		System.out.println("enter right for "+data);
		root.right=createTree();
		
			
		return root;
	}
	
	public static void printInOrder(Node root) {
		if(root==null)
			return;
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}
	public static void main(String[] args) {
		 Node root=createTree();
		
			printInOrder(root); 

	}

}
