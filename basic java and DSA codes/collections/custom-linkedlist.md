
# Singly LinkedList

## Insert First Node Impl


<img width="321" alt="image" src="https://github.com/user-attachments/assets/2093e762-4cee-42f2-9cce-f5473ad9750d" />



```
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }
    public Node(int val, Node next){
        this.val=val;
        this.next=next;
    }
}
class LL{
    Node head;
    
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
    }
    
    
    public void disp(){
        Node node=head;
        while(node!=null){
            System.out.print(node.val+"-> ");
            node=node.next;
        }
        System.out.println("END");
    }
}
public class Main {
    public static void main(String[] args) {
            LL list=new LL();
            list.insertFirst(30);
            list.insertFirst(20);
            list.insertFirst(10);
            list.disp();
            list.insert(1,2);
            list.disp();
        }
}
```

## Insert Using Recursion


<img width="466" alt="image" src="https://github.com/user-attachments/assets/460a5d11-0016-4441-9d4e-2a07a45a4ee8" />


```
   public void insert(int val, int index){
        Node node=head;
       Node head= insert(val,index,node);
    }
    public Node insert(int val, int idx, Node currNode){
        if(idx==0){
          Node newNode=new Node(val,currNode);
          return newNode;
        }
        
        Node preNode=currNode;
        prevNode.next=insert(val,idx-1,currNode.next);
        return prevNode;
    }
```


