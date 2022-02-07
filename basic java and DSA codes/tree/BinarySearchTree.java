package tree;

import singlywithConstructor.LinkedList;
import java.util.*;
import java.util.Map.Entry;
//TreeNode class is already declared in package
public class BinarySearchTree {

	
static	TreeNode root;
        
       public static TreeNode insertRec(TreeNode root,int data) {
    	   if(root==null) {
    		   root=new TreeNode(data);
    		   return root;									//insert by recursion
    	   }
    	   if(data<root.data) {
    		   root.left=insertRec(root.left, data);
    	   }
    	   else {
    		   root.right=insertRec(root.right, data);
    	   }
    	   
    	   
    	   return root;
       }


       				

	public static void insert(int data) {
		TreeNode newNode=new TreeNode(data);
		if(root==null) {
			root=new TreeNode(data);					//insert by travesering
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
					
			}else {
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
	public static TreeNode deleteAllLeafNode(TreeNode root) {
		
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			
			return null;
		}
		root.left=deleteAllLeafNode(root.left);
		root.right=deleteAllLeafNode(root.right);
		return root;
	}
	
	 public static TreeNode deletePerticularLeaf(TreeNode root,int data) {
//		 if(root.data==data) {
//			 return root=null;    //we can't delete root element directly
//		 }
		
		 if(data<root.data) {
			 if(root.left.data==data) {
				 return root.left=null;
			 }
			 else {
				 return root.left=deletePerticularLeaf(root.left, data);
			 }
		 }else {
			 if(root.right.data==data) {
				 return root.right=null;
				 
			 }else {
				 return root.right=deletePerticularLeaf(root.right, data);
			 }
		 }
		 
	 }
	 public static void deleteMid(int data) {
		 deleteByRec(root,data);
	 }
	private static TreeNode deleteByRec(TreeNode root, int data) {
	    
		if(root==null) {
			return root;
		}
		if(data<root.data) {
			return root.left=deleteByRec(root.left, data);       //only for search
		}
		else if(data>root.data) {
			return root.right=deleteByRec(root.right, data);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;                                //replacement of successer mean element
			}												     //from right side most then left min node
			}
			root.data=findSuccesser(root.right);   
			root.right=deleteByRec(root.right, root.data);      //deletion of replaced element
		return root;
	}
	


          
        /*        10
         *      /   \ 
         *      9    12(delete element)
         *     /\     /\
         *    7  8   11  13 
         *         (replacement)
         */       
	private static int findSuccesser(TreeNode root) {
		
		int min=root.data;
		while(root.left!=null) {
			min=root.left.data;
			root=root.left;               //traverse
		}
		return min;                                     
	}


	public static int height(TreeNode root) {
      	if(root==null){
              return -1;
          }
         int leftDepth=height(root.left);
         int rightDepth=height(root.right);
         if(leftDepth>rightDepth) {
        	 return leftDepth+1;
         }
         else {
        	  return rightDepth+1;
         }
    }
	public static void topViewPrint(TreeNode root) {
	      class QueueObj{
	    	  TreeNode node;
	    	  int hd;
	    	  public QueueObj(TreeNode node,int data) {
			     this.node=node;
			     this.hd=hd;
			}
	      }
	    	 Queue<QueueObj> queue=new java.util.LinkedList<QueueObj>();
	    	 
	    	 Map<Integer, TreeNode> topView=new TreeMap<Integer, TreeNode>();
	    	 
	    	 if(root==null) {
	    		 return;
	    	 }
	    	 else {
	    		 queue.add(new QueueObj(root,0));
	    	 }
	    	 
	    	 while(queue.isEmpty()) {
	    		 QueueObj tempNode=queue.poll();
	    		 if(!topView.containsKey(tempNode.hd)) {
	    			 topView.put(tempNode.hd,tempNode.node);
	    		 }
	    		 if(tempNode.node.left!=null) {
	    			 queue.add(new QueueObj(tempNode.node,tempNode.hd-1));
	    		 }
	    		 if(tempNode.node.right!=null) {
	    			 queue.add(new QueueObj(tempNode.node,tempNode.hd+1));
	    		 }
	    	 }
	    	 for(Entry<Integer, TreeNode> entry:topView.entrySet())
	    	 {
	    		 System.out.println(entry.getValue().data);
	    	 }
	     
	}

    public static void levelOrderTravesel(TreeNode root) {
    	TreeNode temp=root;
    	if(root==null) {
			System.out.println("empty");
			return;
		}
    	
    	
		Queue<TreeNode> queue=new java.util.LinkedList<TreeNode>();
		queue.add(root);
	
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
	public static void printInOrder(TreeNode root) {
		if(root==null) {
			//System.out.println("tree is empty");
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
	public static void main(String[] args) {
//		 insert(10);
//		 insert(9);
//		 insert(11);
//		 insert(8);
		 insert(11);
		 insertRec(root, 10);
		 insertRec(root, 9);
		 insertRec(root, 7);
		 insertRec(root, 8);
		 insertRec(root, 12);
		 insertRec(root, 13);
		 printInOrder(root);           
         System.out.println();         
        //deleteAllLeafNode(root);       //delete all leaf node
         
        //deletePerticularLeaf(root,13);  //delete perticular element
         
      deleteMid(12);            //required to replace 12 with 11 then leftmost element required to do null
        printInOrder(root);
       System.out.println();
        //int ans=height(root);
       // System.out.println("height of the tree is "+ans);
       
        //System.out.println("topview of tree is");
       
        // topViewPrint(root);
      // printInOrder(root);
         levelOrderTravesel(root);
	}

}
