package tree;

import java.util.*;


public class QueueTree {
	TreeNode root;
	
	public void insert(int data) {
		if(root==null) {
			root=new TreeNode(data);
			return;
		}
		
		Queue<TreeNode>	 queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			if(temp.left==null) {
				temp.left=new TreeNode(data);
				break;
			}else
			{
				queue.add(temp.left);
			}
			if(temp.right==null) {
				temp.right=new TreeNode(data);
				break;
			}
			else {
				queue.add(temp.right);
			}
		}
		
	}
	public void delete(TreeNode root,int data)
	{   
		if (root==null)
		{
			System.out.println("Tree is Empty");
			return;
		}
		Queue<TreeNode>queue=new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp=null,foundNode=null;
		while (!queue.isEmpty()) 
		{
			temp=queue.poll();
			if (temp.data==data)
			{
				foundNode=temp;
				
			}
			if (temp.left!=null) 
				queue.add(temp.left);

			if (temp.right!=null) 
			queue.add(temp.right);

		}
		if(foundNode!=null) {
			int a=temp.data;
			deleteDeep(root,temp);
			foundNode.data=a;
		}
	}
	private void deleteDeep(TreeNode root2, TreeNode temp) {
		
		
	}
	private void printInOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data+ " ");
		printInOrder(root.right);
		
		
	}
	private void printPreOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		printInOrder(root.left);
		
		printInOrder(root.right);
		
		
	}
	private void printPostOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		
		printInOrder(root.left);
		
		printInOrder(root.right);
		
		System.out.print(root.data+" ");
	}

	public static void main(String[] args) {
		QueueTree binaryTree = new QueueTree();
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(5);
        binaryTree.root.right.left = new TreeNode(6);
		
//		binaryTree.insert(1);
//		binaryTree.insert(2);
//		binaryTree.insert(3);
//		binaryTree.insert(4);
//		binaryTree.insert(5);
//		
//		
//        
//        System.out.println(binaryTree.root.data);
//        System.out.println(binaryTree.root.right.data);
       
        
        System.out.println("In order");
        binaryTree.printInOrder(binaryTree.root);//left-->root-->right
       
        //binaryTree.insert(7);
          System.out.println();
         System.out.println("pre order");
         
        binaryTree.printPreOrder(binaryTree.root);//root-->left-->right
        
        
        System.out.println();
        System.out.println("post order");
        binaryTree.printPostOrder(binaryTree.root);  //left-->right-->root


	}

	

}
