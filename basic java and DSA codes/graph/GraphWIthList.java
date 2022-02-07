package graph;

import java.util.ArrayList;

public class GraphWIthList {

	ArrayList<ArrayList<Integer>> adjList;
	int vertex;
	public GraphWIthList(int vertex) {
		this.vertex=vertex;
		this.adjList=new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<vertex;i++) {
			this.adjList.add(new ArrayList<Integer>());
		}
		
	}
	
	public void addEdge(int src,int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src);
	}
	
	public void display() {
		adjList.forEach(a->{
			System.out.println(a);
		});
	}
	
	public static void main(String[] args) {
		GraphWIthList graph=new GraphWIthList(6);
		graph.display();
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 3);
	   System.out.println();
		graph.display();

	}

}
