package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class AdjucentListGraph {

	
	private int vertex;
	LinkedList<Integer>[] adjList;
	public AdjucentListGraph(int vertex) {
		this.vertex=vertex;
		this.adjList=new LinkedList[vertex];
		
		for(int i=0;i<vertex;i++) {
			this.adjList[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src,int dest) {
		this.adjList[src].add(dest);
		this.adjList[dest].add(src);
	}

	


	@Override
	public String toString() {
		return "AdjucentListGraph [vertex=" +vertex + ", adjList=" + Arrays.toString(adjList) + "]";
	}

	public static void main(String[] args) {
		AdjucentListGraph graph=new AdjucentListGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		System.out.println(graph.toString());

	}

}
