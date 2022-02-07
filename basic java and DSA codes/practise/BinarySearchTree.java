package practise;

import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

	static TreeNode root;
	public static void insert(int data) {
		TreeNode newNode=new TreeNode(data);
		if(root==null) {
			root=newNode;
			return;
		}
		TreeNode temp=root;
		while(temp!=null) {
			if(data<temp.data) {
				if(temp.left==null) {
					temp.left=newNode;
					break;
				}
				else {
					temp=temp.left;
				}
			}
			else {
				if(temp.right==null) {
					temp.right=newNode;
					break;
					
				}
				else {
					temp=temp.right;
				}
			}
		}
	}
//	public static TreeNode deletePerticular(TreeNode root,int data) {
//		
//		if(data<root.data) {
//			if(root.left.data==data) {
//				return root.left=null;
//			}
//			else {
//				return root.left=deletePerticular(root.left,data);
//			}
//		}
//		if(data>root.data) {
//			if(root.right.data==data) {
//				return root.right=null;
//			}
//			else {
//				return root.right=deletePerticular(root.right, data);
//			}
//		}
//	
//		
//	}
	
	public static void deleteAtMid(int data) {
		deleteByRec(root,data);
	}
	private static TreeNode deleteByRec(TreeNode root, int data) {
	
		if(root==null) {
			return null;
		}
		if(data<root.data) {
			if(root.left.data==data) {
				return root.left=null;
			}
			else {
				root.left=deleteByRec(root.left, data);
			}
		}
		else if(data>root.data) {
			if(root.right.data==data) {
				return root.right=null;
			}
			else {
				root.right=deleteByRec(root.right, data);
			}
		}
		root.data=findSuccessor(root.right);
		root.right=deleteByRec(root.right, data);
	return root;
}
	private static int findSuccessor(TreeNode root) {
		int min=root.data;
		while(root.left!=null) {
			min=root.left.data;
			root=root.left;
		}
		return min;
	}
	public static void printLevelOrder(TreeNode root) {
		if(root==null) {
			System.out.println("tree is empty");
			return;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
		
	}
	public static void main(String[] args) {
		insert(10);
		insert(12);
		insert(8);
		insert(6);
		insert(7);
         insert(11);
        insert(13);
//         insert(16);
         printLevelOrder(root);
         
       // deletePerticular(root, 13);
        System.out.println();
       deleteAtMid(12);
        
        printLevelOrder(root);

	}

}
