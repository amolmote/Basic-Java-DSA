package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2{
	int data;
	Node2 left,right;
	Node2(int data){
		this.data=data;
		this.left=this.right=null;
		
	}
}
public class TreeInArray {

	
      static Node2 root;

	public static Node2 insert(int data) {
		Node2 temp=new Node2(data);
		temp.data=data;
		temp.left=temp.right=null;
		return temp;
		
	}
	public static Node2 tree(int[] arr,Node2 root,int index,int data) {
		
		  if(index==arr.length-1) {
			  return root;
		  }
		  if(root==null) {
			
			
			 return root=insert(data);
			  
		  }
		  if(root.left==null) {
			
			  root.left=tree(arr, root.left, index+1,data);
			  
		  }else {
		     return root.left;
		  }
		  if(root.right==null){
		
			
			  root.right=tree(arr, root.right, index+1,data);
		  }else
		  {
			  return root.right;
		  }
		 
		 
		
		  return root;
	  }
public static void print(Node2 root) {
	if(root==null) {
		System.out.println("tree is empty");
		return;
	}
	
	Queue<Node2> queue=new LinkedList<Node2>();
	queue.add(root);
	while(!queue.isEmpty()) {
		Node2 tempNode=queue.poll();
		System.out.println(tempNode.data+" ");
		if(tempNode.left!=null) {
			queue.add(tempNode.left);
		}
		if(tempNode.right!=null) {
			queue.add(tempNode.right);
		}
	}
	
}
	
	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        int size=6;
        
		int[] arr=new int[size];
		int index=0;
 
		int data;
		  insert(10);
		 tree(arr,root,index,10);
		 tree(arr, root, index, 12);
	}

}
