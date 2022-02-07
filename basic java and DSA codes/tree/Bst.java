package tree;

public class Bst {
      static TreeNode root;
	
	public static TreeNode insertRec(TreeNode root,int data) {
		if(root==null) {
			root=new TreeNode(data);
			return root;
		}
		if(data<root.data) {
			return root.left=insertRec(root.left, data);
		}
		else if(data>root.data){
			return root.right=insertRec(root.right, data);
		}
		
		return root;
	}
	
	public static void insert(int data) {
		TreeNode newNode=new TreeNode(data);
		if(root==null) {
			root=new TreeNode(data);
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
	public static TreeNode deleteAllLeaf(TreeNode root) {
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left=deleteAllLeaf(root.left);
		root.right=deleteAllLeaf(root.right);
		return root;
	}
	public static TreeNode deletePerticular(TreeNode root,int data) {
		if(root.data==data) {
			return root=null;
		}
		if(data<root.data) {
			if(root.left.data==data) {
				return root.left=null;
			}
			else {
			return	root.left=deletePerticular(root.left, data);
			}
		}
		else {
			if(root.right.data==data) {
				return root.right=null;
			}
			else {
				return root.right=deletePerticular(root.right, data);
			}
		}
			
		
	}
	public static void deleteMid(int data) {
		deleteByRec(root,data);
	}
	private static TreeNode deleteByRec(TreeNode root, int data) {
		if(root==null) {
			return null;
		}
		if(data<root.data) {
			return root.left=deleteByRec(root.left, data);
		}
		else if(data>root.data) {
			return root.right=deleteByRec(root.right, data);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null){
				return root.left;
			}
			root.data=successer(root.right);
		}
		return root;
	}

	private static int successer(TreeNode root) {    //root.right-->then to  find minimun from right
		  int min=root.data;                         //we go left side
		  while(root.left!=null) {
			  min=root.left.data;
			  root=root.left;
		  }
		return min;
	}

	public static void printInOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
	public static void printPreOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	public static void main(String[] args) {
		Bst bst=new Bst();
		insert(10); //root
//		insertRec(root,4);
//		insertRec(root,6);
//		insertRec(root,12);
//		insertRec(root,18);
//		insertRec(root,14);
		insert(4);
	
		insert(9);
		insert(12);
		insert(11);
		insert(13);
		
		
		
		
		printInOrder(root);
		System.out.println();
		//printPreOrder(root);
	//	deleteAllLeaf(root);
		//deletePerticular(root, 4);
		deleteMid(11);
		printInOrder(root);
	}

}
