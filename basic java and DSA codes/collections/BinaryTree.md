

## Binary Tree Impl:

```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;
    
    public Node(int val){
        this.val=val;
    }
}

class BT{
    private Node root;
    
    public void insert(Scanner sc){
        System.out.println("enter the value for root node");
        int value = sc.nextInt();
        root = new Node(value);
        insert(sc,root);
    }
    public void insert(Scanner sc, Node node){
        System.out.println("want to insert left of: "+node.val);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("insert left node value for: "+node.val);
            int value = sc.nextInt();
            node.left = new Node(value);
            insert(sc, node.left);
        }
        System.out.println("want to insert right of: "+node.val);
        
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("insert right node value for: "+node.val);
            int value = sc.nextInt();
            node.right = new Node(value);
            insert(sc,node.right);
        }
        
    }
   
   public void disp(){
       disp(root);
   }
    public void disp(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        disp(node.left);
        disp(node.right);
    }
}
public class Main {
    public static void main(String[] args) {
        BT t=new BT();
        Scanner sc = new Scanner(System.in);
        t.insert(sc);
        t.disp();
    }
}
```
