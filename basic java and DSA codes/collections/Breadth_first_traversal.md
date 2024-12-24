

## Breadth First Treversal(BFT or BFS)

```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    
    public Node(int val){
        this.val=val;
    }
}

class BFSDemo{
    
    private Node root;
    
    public void insert(int val){
        this.root = insert(root,val);
    }
    public Node insert(Node node, int val){
        if(node==null){
            Node n=new Node(val);
            return n;
        }
        if(val< node.val){
            node.left = insert(node.left, val);
        }
        
        if(val> node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }
    
    public void BFT(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(node.val);
            if(node.left!=null){
                q.add(node.left);
            }
            
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BFSDemo tree = new BFSDemo();
        tree.insert(10);
        tree.insert(5);
         tree.insert(8);
        tree.insert(1);
        tree.insert(15);
        tree.insert(12);
         tree.insert(17);
        tree.BFT();
    }
}
```

## BST Return List(Level order)
```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    
    public Node(int val){
        this.val=val;
    }
}

class BFSDemo{
    
    private Node root;
    
    public void insert(int val){
        this.root = insert(root,val);
    }
    public Node insert(Node node, int val){
        if(node==null){
            Node n=new Node(val);
            return n;
        }
        if(val< node.val){
            node.left = insert(node.left, val);
        }
        
        if(val> node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }
    
    public List<List<Integer>> BFT(){
        List<List<Integer>> list= new ArrayList<>();
        if(root==null){
            return list;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
             int levelSize = q.size();
             List<Integer> subList = new ArrayList<>(levelSize);
           for(int i=0;i<levelSize;i++){
                Node node = q.poll();
               subList.add(node.val);
                if(node.left!=null){
                q.add(node.left);
               }
            
              if(node.right!=null){
                q.add(node.right);
              }
           }
              list.add(subList);
        }
        
        return list;
    }
}
public class Main {
    public static void main(String[] args) {
        BFSDemo tree = new BFSDemo();
        tree.insert(10);
        tree.insert(5);
         tree.insert(8);
        tree.insert(1);
        tree.insert(15);
        tree.insert(12);
         tree.insert(17);
       System.out.println(tree.BFT());
    }
}
```
output
```
[[10], [5, 15], [1, 8, 12, 17]]
```
