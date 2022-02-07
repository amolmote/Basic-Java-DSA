package graph;

import java.util.Arrays;

public class UndirectionalMatrixGraph {
	int vertex;
	int[][] adjucentMatrix;
	
	public UndirectionalMatrixGraph(int vertex) {
		this.vertex=vertex;
		this.adjucentMatrix=new int[vertex][vertex];
	}

	public void addEdge(int src,int dest) {
		adjucentMatrix[src][dest]=1;
		adjucentMatrix[dest][src]=1;
	}
	
	public void print() {
		
		for(int i=0;i<vertex;i++) {
			System.out.println(Arrays.toString(adjucentMatrix[i]));
		}
	}
	public static void main(String[] args) {
		UndirectionalMatrixGraph graph=new UndirectionalMatrixGraph(4);
		
		System.out.println("empty graph");
		graph.print();
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		System.out.println("graph with vertex representation");
		graph.print();
	}

}
