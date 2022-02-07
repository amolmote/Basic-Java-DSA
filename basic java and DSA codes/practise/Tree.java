package practise;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	TreeNode left,right;
	int data;
	public TreeNode(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class Tree {

	static TreeNode root;
	
	
	public static void insertNode(int data) {
		
		if(root==null) {
			root=new TreeNode(data);
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			
			if(temp.left==null) {
				temp.left=new TreeNode(data);
			}
			else {
				queue.add(temp.left);
			}
			if(temp.right==null) {
				temp.right=new TreeNode(data);
			}
			else {
				queue.add(temp.right);
			}
		}
		
	}
	public void delete(TreeNode root,int data) { //key is the node data which is deleted from tree
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			if(root.data==data) {
				root=null;
				return;
			}
			else {
				return; 						// wrong data 
			}
		}
		
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp = null;
		TreeNode keyNode=null;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			
			if(temp.data==data) {
				keyNode=temp;
				//System.out.println("keyNode= "+keyNode.data);
				
			}
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
		if(keyNode!=null) {				//keyNode=2
			int a=temp.data;//temp.data=7
			//System.out.println("keyNode= "+a);
			deleteRightMost(root,temp);
			keyNode.data=a;
			//System.out.println(keyNode.data);
		}
	}
	private void deleteRightMost(TreeNode root, TreeNode deleteNode) { //deleteNode=2;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp;
		
		//doing level order traversal
		while(!queue.isEmpty()) {
			temp=queue.poll();
			
			if(temp==deleteNode) {
				temp=null;
				return;
			}
			if(temp.left!=null) {
				if(temp.left==deleteNode) {
					temp.left=null;
					return;
				}
				else {
					queue.add(temp.left);
				}
			}
			if(temp.right!=null) {
				if(temp.right==deleteNode) {
					temp.right=null;
					return;
				}
				else {
					queue.add(temp.right);
				}
			}
		}
		
	}
	public void printInOrder(TreeNode root) {
		if(root==null) {
			//System.out.println("tree is empty");
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
	public static void main(String[] args) {
		Tree t=new Tree();
		t.root=new TreeNode(1);
		t.root.left=new TreeNode(2);
		t.root.right=new TreeNode(3);
		t.root.left.left=new TreeNode(4);
		t.root.left.right=new TreeNode(5);
		t.root.right.left=new TreeNode(6);
		t.root.right.right=new TreeNode(7);
		
		t.printInOrder(root);
		t.delete(root, 2);				//rightmost 7 replace with 2 and rightmost 7 element is become  null in deleteRightMost meth
		System.out.println();
	//	t.delete(root, 4);
		t.printInOrder(root);
	}
}
/*
4 2 5 1 6 3 7 
4 7 5 1 6 3 7 
*/
