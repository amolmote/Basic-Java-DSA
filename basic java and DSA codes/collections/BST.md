## Binary Search Tree
```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Node{
    int val;
    Node left;
    Node right;
    int height;
    
    public Node(int val){
        this.val = val;
    }
    
    
     public int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    
   
}

class AVLTree{
    private Node root;
    
    public void insert(int val){
        this.root = insert(root,val);
    }
    public Node insert(Node node,int val){
        if(node==null){
            Node n=new Node(val);
            return n;
        }
        
        if(val<node.val){
            node.left = insert(node.left, val);
        }
        if(val>node.val){
            node.right = insert(node.right, val);
        }
        
        node.height = Math.max(node.getHeight(node.left),node.getHeight(node.right) + 1);
        return node;
    }
    
    public void disp(){
        disp(this.root);
    }
    public void disp(Node node){
        if(node==null){
            return;
        }
        disp(node.left);
        System.out.println(node.val);
        disp(node.right);
    }
     public int getHeight(){
        return getHeight(this.root);
    }
    
     public int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
}
public class Main {
    public static void main(String[] args) {
      AVLTree tree=new AVLTree();
      tree.insert(1);
      tree.insert(2);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.disp();
      System.out.println(tree.getHeight());
      
    }
}
```



<img width="429" alt="image" src="https://github.com/user-attachments/assets/ad928d21-08aa-4377-a8f2-38c00965a0f9" />
