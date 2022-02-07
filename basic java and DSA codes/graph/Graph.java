package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    LinkedList<Integer>[] adj;
    
    public Graph(int vertex) {
	   adj=new LinkedList[vertex];
	   
	   for(int i=0;i<vertex;i++) {
		   adj[i]=new LinkedList<Integer>();
	   }
	}
	
    public void addEdges(int src,int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    
    public int bfs(int src,int dest) {
    	boolean[] visited=new boolean[adj.length];
    	int[] parent=new int[adj.length];
    	
    	Queue<Integer> queue=new LinkedList<Integer>();
    	queue.add(src);
    	parent[src]=-1;
    	visited[src]=true;
    	
    	while(!queue.isEmpty()) {
    		int current=queue.poll();
    	
    		if(current==dest) {
    			break;
    		}
    		for(int neighbor: adj[current]) {
    			if(!visited[neighbor]) {
    				visited[neighbor]=true;
    				queue.add(neighbor);
    				parent[neighbor]=current;
    			}
    		}
    	}
    	
    	int current=dest;
    	int distance=0;
    	while(parent[current]!=-1) {
    		System.out.print(current+"-->");
    		current=parent[current];
    		System.out.println(current);
    		distance++;
    	}
    	
    	return distance;
    }
    public boolean dfsUsingStack(int src,int dest) {
    	
    	boolean visited[]=new boolean[adj.length];
    	visited[src]=true;
    	Stack<Integer> stack =new Stack<Integer>();
    	stack.push(src);
    	
    	
    	while(!stack.isEmpty()) {
    		int current=stack.pop();
    		
    		if(current==dest) {
    			return true;
    		}
    		
    		for(int neighbor: adj[current]) {
    			if(!visited[neighbor]) {
    				visited[neighbor]=true;
    				stack.push(neighbor);
    			}
    		}
    	}
    	return false;
    }
    public boolean dfsUsingRec(int src,int dest,boolean[] visited) {
    	
    	if(src==dest) {
    		return true;
    	}
    	for(int neighbor: adj[src]) {
    		if(!visited[src]) {
    			visited[neighbor]=true;
    			boolean isConnected=dfsUsingRec(src, dest, visited);
    			if(isConnected) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
   
    public boolean dfs(int src,int dest) {
    	boolean[] visited=new boolean[adj.length];
    	visited[src]=true;
    	return dfsUsingRec(src, dest, visited);
    }
    
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the vertices and edges");
        int vertex=sc.nextInt();
        int edges=sc.nextInt();
        
        Graph graph=new Graph(vertex);
        System.out.println("enter "+edges+" edges");
        
        int src,dest;
        for(int i=0;i<edges;i++) {
        	src=sc.nextInt();
        	dest=sc.nextInt();
        	
        	graph.addEdges(src, dest);
        	
        }
        System.out.println("enter source to destiantion ");
        src=sc.nextInt();
        dest=sc.nextInt();
       // graph.bfs(src,dest);
       // System.out.println("minimun distance is "+graph.bfs(src,dest));
        
      
      // System.out.println("is their is path possible-> "+graph.dfsUsingStack(src, dest));
        System.out.println("possible using rec "+graph.dfs(src, dest));
       
	}
	 
 	
}
/*
5 
 0 1
1 2
2 3
2 4
0 4
3 4
*/
