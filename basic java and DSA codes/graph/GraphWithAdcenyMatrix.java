package graph;

import java.util.Arrays;

public class GraphWithAdcenyMatrix {

	int[][] adjucentMatrix;
	int vertex;
	
	public  GraphWithAdcenyMatrix(int vertex) {
		this.vertex=vertex;
		this.adjucentMatrix=new int[vertex][vertex];
	}
	
	public void addEdge(int src,int dest) {
		adjucentMatrix[src][dest]=1;
		adjucentMatrix[dest][src]=1;
	}
	
	public void display() {
//		for(int i=0;i<vertex;i++) {
//			for(int j=0;j<vertex;j++) {
//				System.out.print(adjucentMatrix[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
		for(int i=0;i<vertex;i++) {
			System.out.println(Arrays.toString(adjucentMatrix[i]));       //toString method
		}
	}
	
	public static void main(String[] args) {
		GraphWithAdcenyMatrix graph=new GraphWithAdcenyMatrix(6);
		graph.display();
		graph.addEdge(0, 1);
		System.out.println();
		
		//graph.addEdge(0, 3);
		graph.display();

	}

}
