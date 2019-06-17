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
		VertexInfo v = new VertexInfo();
		
		for(int i = 0; i < order; i++) {
			v.setState(noGrafo);
			v.setDegree(0);
			vertices.add(v);
		}
		for(int i = 0; i < size; i++) {
			v = vertices.get(edges.get(i).getFirst());
			v.setDegree(v.getDegree()+1);
			vertices.set(edges.get(i).getFirst(), v);
				
			v = vertices.get(edges.get(i).getSecond());
			v.setDegree(v.getDegree()+1);
			vertices.set(edges.get(i).getSecond(), v);
		}
		
		return vertices;
	}
	
	static int minDegreeVertex(ArrayList<VertexInfo> vertices, int order) {
		int minDegree = 0;
		int minVertex = -1;
		
		for(int i = 0; i < order; i++) {
			if(vertices.get(i).getState() == noGrafo && (minDegree == 0 || vertices.get(i).getDegree() < minDegree)) {
				minDegree = vertices.get(i).getDegree() ;
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
	
	static ArrayList<Integer> createMIS(ArrayList<VertexInfo> vertices, int order, int m) {
		ArrayList<Integer> mis = new ArrayList<Integer>();
		m = 0;
		
		for(int v = 0; v < order; v++) {
			if(vertices.get(v).getState() == noMIS) {
				mis.add(v);
			}
		}

		return mis;
	}
	
	static int maximumIndependentSet(ArrayList<Edge> edges, int size, int order, ArrayList<Integer> mis) {
		int m = 0;
		ArrayList<VertexInfo> vertices = new ArrayList<VertexInfo>();
		boolean finished = false;
		
		vertices = createVertices(edges, size, order);
		
		while(!finished) {
			int v = minDegreeVertex(vertices, order);
			if(v != -1) {
				moveVertex(vertices, order, edges, size, v, noMIS);
				m++;
				
				for(int i = 0; i < size; i++) {					
					if(edges.get(i).getFirst() == v && vertices.get(edges.get(i).getSecond()).getState() == noGrafo) {
						moveVertex(vertices, order, edges, size, edges.get(i).getSecond(), descartado);
					} else if(edges.get(i).getSecond() == v && vertices.get(edges.get(i).getFirst()).getState() == noGrafo) {
						moveVertex(vertices, order, edges, size, edges.get(i).getSecond(), descartado);
					}
				}
			}
			else {
				finished = true;
			}
		}
		
		mis = createMIS(vertices, order, m);
		printa(vertices, order);
		if(mis == null)
			m = 0;
		
		return m;
	}
	
	static int wheelGraph(int n, ArrayList<Edge> edges) {
		int size = 2 * n - 2, i;
		Edge e = new Edge();
		
		for(i = 0; i < n - 2; i++) {
			e.setFirst(i);
			e.setSecond(i + 1);
			System.out.printf("i: %d | %d  %d\n", i, e.getFirst(), e.getSecond());
			edges.add(e);
			System.out.printf("i: %d | %d  %d\n", i, edges.get(i).getFirst(), edges.get(i).getSecond());
		}
		e.setFirst(n - 2);
		e.setSecond(0);
		edges.add(e);
		System.out.printf("\ni: %d | %d  %d\n\n", i, edges.get(i).getFirst(), edges.get(i).getSecond());
		for(i = 0; i < n - 1; i++) {
			e.setFirst(i);
			e.setSecond(n - 1);
			System.out.printf("i: %d | %d  %d\n", i, e.getFirst(), e.getSecond());
			edges.add(e);
			System.out.printf("i: %d | %d  %d\n", i, edges.get(i).getFirst(), edges.get(i).getSecond());
		}
		System.out.printf("\n\n\n");
		for(i = 0; i < size; i++) {
			System.out.printf("i: %d | %d  %d\n", i, edges.get(i).getFirst(), edges.get(i).getSecond());
		}
		
		return size;
	}
	/*
	static void printaWheelGraph(ArrayList<Edge> edges, int size) {
		for(int i = 0; i < size; i++) {
			System.out.printf("i: %d | %d  %d\n", i, edges.get(i).getFirst(), edges.get(i).getSecond());
		}
	}
	*/
	static void printMIS(ArrayList<Integer> mis, int m) {
		for(int x : mis) {
			System.out.printf("%d ", x);
		}
		System.out.printf("\n");
	}	
	
	static void printa(ArrayList<VertexInfo> vertices, int order) {
		int mis[] = new int[order];
		int count = 0;
		
		for(int v = 0; v < order; v++) {
			if(vertices.get(v).getState() == noMIS) {
				mis[v] = v+1;
				System.out.printf("%d ", mis[v]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int order = 7;
		
		ArrayList<Integer> mis = new ArrayList<Integer>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		int size = wheelGraph(order, edges);
		
		//printaWheelGraph(edges, size);
		
		int m = maximumIndependentSet(edges, size, order, mis);
		
		printMIS(mis, m);
	}
}
