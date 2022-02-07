package tree;

import java.util.LinkedList;
import java.util.Queue;

//class Node{
//	int data;
//	Node left,right;
//	public Node(int data) {
//		this.data=data;
//		this.left=null;
//		this.right=null;
//	}
//}
public class Tree {
    Node root;
    
    public void insertNode(int data) {
    	if(root==null) {
    		root=new Node(data);
    		return;
    	}
    	Queue<Node> queue=new LinkedList<Node>();
    	queue.add(root);
    	Node temp;
    	while(!queue.isEmpty()) {
    		temp=queue.poll();
    		if(temp.left==null) {
    			temp.left=new Node(data);
    			break;
    		}
    		else {
    			queue.add(temp.left);
    		}
    		if(temp.right==null) {
    			temp.right=new Node(data);
    		}
    		else {
    			queue.add(temp.right);
    		}
    	}
    }
    public void deleteNode(Node root,int data) {
    	if(root==null) {
    		System.out.println("tree is empty");
    		return;
    	}
    	Queue<Node> queue=new LinkedList<Node>();
    	queue.add(root);
    	Node temp=null,foundNode=null;
    	while(!queue.isEmpty()) {
    		temp=queue.poll();
    		if(temp.data==data) {
    			foundNode=temp;
    		}
    		if(temp.left!=null) {
    			queue.add(temp.left);
    		}
    		if(temp.right!=null) {
    			queue.add(temp.right);
    		}
    		
    	}
    	if(foundNode!=null) {
    		int x=temp.data;           //required to delete temp.data bcz it is deepest right element 6
    		deleteDeep(root,temp);
    		foundNode.data=x;           //replacement of temp with deleted element 2
    	}
    }
    private void deleteDeep(Node root, Node temp) {
		
		
	}
	public void printInOrder(Node root){
    	if(root==null) {
    		return;
    	}
    	printInOrder(root.left);
    	System.out.print(root.data+" ");
    	printInOrder(root.right);  	
    }
    public void printPreOrder(Node root) {
    	if(root==null) {
    		return;
    	}
    	System.out.print(root.data+ " ");
    	printPreOrder(root.left);
    	printPreOrder(root.right);
    }
    public void printPostOrder(Node root) {
    	if(root==null) {
    		return;
    	}
    	printPostOrder(root.left);
    	printPostOrder(root.right);
    	System.out.print(root.data+" ");
    }
	
	public static void main(String[] args) {
         Tree t=new Tree();
         t.root=new Node(1);
         t.root.left=new Node(2);
         t.root.right=new Node(3);
         t.root.left.left=new Node(4);
         t.root.left.right=new Node(5);
         t.root.right.left=new Node(6);
         t.root.right.right=new Node(7);
         
         t.printInOrder(t.root);
         System.out.println();
         t.printPreOrder(t.root);
         System.out.println();
         t.printPostOrder(t.root);

	}

}
