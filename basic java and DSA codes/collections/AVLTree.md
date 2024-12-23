
## Self Balancing Tree(AVL Tree)

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
        
        node.height = Math.max(node.getHeight(node.left),node.getHeight(node.right))+1;
        
        return rotateToBalance(node);
    }
    
    public Node rotateToBalance(Node node){
        if(node.getHeight(node.left) - node.getHeight(node.right) > 1){
            //left heavy case
            if(node.getHeight(node.left.left) - node.getHeight(node.left.right) > 0){
                //left_left case - right rotate at p
                return rightRotate(node);
            
            }
             if(node.getHeight(node.left.left) - node.getHeight(node.left.right) < 0){
                //left_right case - left rotate at c and then right rotate at p
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        
        if(node.getHeight(node.left) - node.getHeight(node.right) < -1){
            //left heavy case
            if(node.getHeight(node.right.right) - node.getHeight(node.right.left) > 0){
                //right_right case - left rotate at p
                return leftRotate(node);
            
            }
             if(node.getHeight(node.right.right) - node.getHeight(node.right.left) < 0){
                //right_left case - right rotate at c and then right rotate at p
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        
        return node;
    }
     private Node rightRotate(Node p){
        Node c = p.left;
        Node t= c.right;
        
        c.right = p;
        p.left = t;
        
        p.height = Math.max(p.getHeight(p.left), p.getHeight(p.right) + 1);
        c.height = Math.max(c.getHeight(c.left), c.getHeight(c.right) + 1);
         
        return c; 
    }
    private Node leftRotate(Node c){
        Node p= c.right;
        Node t=p.left;
        
        p.left = c;
        c.right = t;
        
         p.height = Math.max(p.getHeight(p.left), p.getHeight(p.right) + 1);
        c.height = Math.max(c.getHeight(c.left), c.getHeight(c.right) + 1);
         
        return p; 
    }
    
    public void disp(){
        disp(this.root);
    }
    public void disp(Node node){
        if(node==null){
            return;
        }
        disp(node.left);
        System.out.print(node.val+" ");
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
    
    // for(int i=0;i<1000;i++){
    //     tree.insert(i);
    // }
      tree.disp();
      System.out.println();
      System.out.println(tree.getHeight());
    }
}
```
