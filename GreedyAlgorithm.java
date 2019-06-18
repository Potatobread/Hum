package Greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GreedyAlgorithm {

	// Estados do Vertice
	static int noGrafo = 0;
	static int noMIS = 1;
	static int descartado = 2;
	
	
	static ArrayList<VertexInfo> createVertices(ArrayList<Edge> edges, int size, int order){
		
		ArrayList<VertexInfo> vertices = new ArrayList<VertexInfo>();
		
		for(int i = 0; i < order; i++) {
			VertexInfo v = new VertexInfo();
			v.setState(noGrafo);
			v.setDegree(0);
			vertices.add(v);
		}
		for(int i = 0; i < size; i++) {
			VertexInfo vert = new VertexInfo();
			
			vert = vertices.get(edges.get(i).getFirst());
			vert.setDegree(vert.getDegree()+1);
			vertices.set(edges.get(i).getFirst(), vert);
				
			vert = vertices.get(edges.get(i).getSecond());
			vert.setDegree(vert.getDegree()+1);
			vertices.set(edges.get(i).getSecond(), vert);
		}
		
		return vertices;
	}
	
	static int minDegreeVertex(ArrayList<VertexInfo> vertices, int order) {
		
		int minDegree = 0;
		int minVertex = -1;
		
		for(int i = 0; i < order; i++) {
			if(vertices.get(i).getState() == noGrafo && (minDegree == 0 || vertices.get(i).getDegree() < minDegree)) {
				minDegree = vertices.get(i).getDegree();
				minVertex = i;
			}
		}
		
		return minVertex;
	}
	
	static void moveVertex(ArrayList<VertexInfo> vertices, int order, ArrayList<Edge> edges, int size, int v, int state) {
		
		vertices.get(v).setState(state);
		
		for(int e = 0; e < size; e++) {
			if(edges.get(e).getFirst() == v && vertices.get(edges.get(e).getSecond()).getState() == noGrafo) {
				
				vertices.get(edges.get(e).getSecond()).setDegree(vertices.get(edges.get(e).getSecond()).getDegree()-1);
				
			} else if(edges.get(e).getSecond() == v && vertices.get(edges.get(e).getFirst()).getState() == noGrafo) {
				
				vertices.get(edges.get(e).getFirst()).setDegree(vertices.get(edges.get(e).getFirst()).getDegree()-1);
				
			}	
		}
	}
	
	static void maximumIndependentSet(ArrayList<Edge> edges, int size, int order) {

		ArrayList<VertexInfo> vertices = new ArrayList<VertexInfo>();
		boolean finished = false;
		
		vertices = createVertices(edges, size, order);

		while(!finished) {
			int v = minDegreeVertex(vertices, order);
			if(v != -1) {
				moveVertex(vertices, order, edges, size, v, noMIS);
				
				for(int i = 0; i < size; i++) {					
					if(edges.get(i).getFirst() == v && vertices.get(edges.get(i).getSecond()).getState() == noGrafo) {
						moveVertex(vertices, order, edges, size, edges.get(i).getSecond(), descartado);
						
					} else if(edges.get(i).getSecond() == v && vertices.get(edges.get(i).getFirst()).getState() == noGrafo) {
						moveVertex(vertices, order, edges, size, edges.get(i).getFirst(), descartado);
						
					}
				}
			}
			else {
				finished = true;
			}
		}
		
		MIS(vertices, order);
	}
	
	static void MIS(ArrayList<VertexInfo> vertices, int order) {
		for(int i = 0; i < order; i++)
			if(vertices.get(i).getState() == noMIS) {
				System.out.printf("%d " ,i);
			}
	}
	
	static int Graph(int n, ArrayList<Edge> edges) {
		int size = 2 * n - 2, i;
		
		int mat[][] = new int[n][n];
		
		mat[0][0] = 0;
		mat[0][1] = 1;
		mat[0][2] = 0;
		mat[0][3] = 0;
		mat[0][4] = 0;
		mat[0][5] = 1;
		mat[0][6] = 1;
		
		mat[1][0] = 1;
		mat[1][1] = 0; 
		mat[1][2] = 1;
		mat[1][3] = 0;
		mat[1][4] = 0;
		mat[1][5] = 0;
		mat[1][6] = 1;			
			
		mat[2][0] = 0;
		mat[2][1] = 1;
		mat[2][2] = 0;
		mat[2][3] = 1; 
		mat[2][4] = 0;
		mat[2][5] = 0;
		mat[2][6] = 1;
		
		mat[3][0] = 0;
		mat[3][1] = 0;
		mat[3][2] = 1;
		mat[3][3] = 0;
		mat[3][4] = 1;
		mat[3][5] = 0;
		mat[3][6] = 1;
													
		mat[4][0] = 0;
		mat[4][1] = 0;
		mat[4][2] = 0;
		mat[4][3] = 1;
		mat[4][4] = 0;
		mat[4][5] = 1;
		mat[4][6] = 1;
		
		mat[5][0] = 1;
		mat[5][1] = 0;
		mat[5][2] = 0;
		mat[5][3] = 0;
		mat[5][4] = 1;
		mat[5][5] = 0;
		mat[5][6] = 1;
		
		mat[6][0] = 1;
		mat[6][1] = 1;
		mat[6][2] = 1;
		mat[6][3] = 1;
		mat[6][4] = 1;
		mat[6][5] = 1;
		mat[6][6] = 0;
		
		for(i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 1) {
					mat[j][i] = 0;
					Edge e = new Edge();
					e.setFirst(i);
					e.setSecond(j);
					edges.add(e);
				}
			}
		}
		
		return size;
	}
	
	
	public static void main(String[] args) {
		int order = 7;
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		int size = Graph(order, edges);
						
		maximumIndependentSet(edges, size, order);
	}
}
