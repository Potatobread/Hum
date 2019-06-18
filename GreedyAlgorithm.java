package Greedy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreedyAlgorithm {

	// Estados do Vertice
	static int presenteGrafo = 0;
	static int conjIndepent = 1;
	static int descartado = 2;
	
	
	static ArrayList<Vertice> criarVertices(ArrayList<Aresta> arestas, int totalArest, int totalVert){
		
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		
		for(int i = 0; i < totalVert; i++) {
			Vertice v = new Vertice();		// Objeto vertice, apresenta dois elementos:
			v.setEstado(presenteGrafo);		// Estado, representa a situação em que o vértice se encontra;
			v.setGrau(0);					// Grau, quantidade de aresta que saem do vértice; 		
			vertices.add(v);				// Inclusão na lista;
		}
		for(int i = 0; i < totalArest; i++) {
			Vertice vert = new Vertice();		// Com a ajuda de um vertice auxiliar, definimos o grau corresponde de cada vértice do grafo;	
			
			vert = vertices.get(arestas.get(i).getPrimeiro());  
			vert.setGrau(vert.getGrau()+1);
			vertices.set(arestas.get(i).getPrimeiro(), vert); // vertices[aresta[i].Primeiro].grau++;
				
			vert = vertices.get(arestas.get(i).getSegundo());
			vert.setGrau(vert.getGrau()+1);
			vertices.set(arestas.get(i).getSegundo(), vert); // vertices[aresta[i].Segundo].grau++;
		}
		
		return vertices;
	}
	
	static int menorGrauVertice(ArrayList<Vertice> vertices, int totalVert) {
		
		int menorGrau = 0;
		int menorVertice = -1;
		
		for(int i = 0; i < totalVert; i++) {
			if(vertices.get(i).getEstado() == presenteGrafo && (menorGrau == 0 || vertices.get(i).getGrau() < menorGrau)) {
				menorGrau = vertices.get(i).getGrau();
				menorVertice = i;
			}
		}
		
		return menorVertice;
	}
	
	static void moverVertice(ArrayList<Vertice> vertices, int totalVert, ArrayList<Aresta> arestas, int totalArest, int v, int estado) {
		
		vertices.get(v).setEstado(estado); // Alteração do estado atual do vertice;
		
		for(int e = 0; e < totalArest; e++) {
		//  if(aresta[e].primeiro == v && vertice[aresta[e].segundo].Estado == presenteGrafo)
			if(arestas.get(e).getPrimeiro() == v && vertices.get(arestas.get(e).getSegundo()).getEstado() == presenteGrafo) { 
			//  vertice[aresta[e].segundo].grau--;
				vertices.get(arestas.get(e).getSegundo()).setGrau(vertices.get(arestas.get(e).getSegundo()).getGrau()-1);
				
			} else if(arestas.get(e).getSegundo() == v && vertices.get(arestas.get(e).getPrimeiro()).getEstado() == presenteGrafo) { //  if(aresta[e].segindo == v && vertice[aresta[e].primeiro].Estado == presenteGrafo)
			//  vertice[aresta[e].segundo].grau--;	
				vertices.get(arestas.get(e).getPrimeiro()).setGrau(vertices.get(arestas.get(e).getPrimeiro()).getGrau()-1);
			}	
		}
	}
	
	static void conjuntoIndependenteMaximo(ArrayList<Aresta> arestas, int totalArest, int totalVert) {

		ArrayList<Vertice> vertices = new ArrayList<Vertice>();	// Lista dos vertices; 
		boolean fim = false; // Boolean que ira manter o controle de verificação dos vértices, até chegar ao último possível;
		
		vertices = criarVertices(arestas, totalArest, totalVert); // Criação de um vertice e inserção dentro da Lista;

		while(!fim) {
			int v = menorGrauVertice(vertices, totalVert); // Retorna o vertice de menor grau do grafo;
			if(v != -1) { // Condicional de parada;
				moverVertice(vertices, totalVert, arestas, totalArest, v, conjIndepent); // Começa a formação do conjuntoIndependente, apartir do vertice de menor grau;
				// Basicamente muda o estado de vertice, e diminiu o seu grau, pois o grau dos demais para manter a propriedade de conjunto independente;
				
				for(int i = 0; i < totalArest; i++) { // Mesma verificação do metodo moverVertice, so que com o objetivo de eliminar os vertices que não podem
					// fazer parte dos conjunto independente devido as suas arestas adjacentes;
					if(arestas.get(i).getPrimeiro() == v && vertices.get(arestas.get(i).getSegundo()).getEstado() == presenteGrafo) {
						moverVertice(vertices, totalVert, arestas, totalArest, arestas.get(i).getSegundo(), descartado);
						
					} else if(arestas.get(i).getSegundo() == v && vertices.get(arestas.get(i).getPrimeiro()).getEstado() == presenteGrafo) {
						moverVertice(vertices, totalVert, arestas, totalArest, arestas.get(i).getPrimeiro(), descartado);
						
					}
				}
			}
			else {
				fim = true;
			}
		}
		
		MIS(vertices, totalVert); // Verificação da Lista de vertices pela procura dos vertices que tem o estado correspondente ao conjIndepent 
	}
	
	static void MIS(ArrayList<Vertice> vertices, int totalVert) {
		for(int i = 0; i < totalVert; i++)
			if(vertices.get(i).getEstado() == conjIndepent) {
				System.out.printf("%d " ,i);
			}
	}
	
	static int Graph(int n, ArrayList<Aresta> arestas) {
		int totalArest = 0; 
		
		int mat[][] = carregarTxt();  // Recebe a matriz de adjacencia de um arquivo
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {	// Verificação da aresta do grafo
				if(mat[i][j] == 1) {		// Se encontrado uma aresta, zera o seu complemento, ex: [0][1] = 1 > [1][0] = 0 
					mat[j][i] = 0;			
					Aresta a = new Aresta(); // Objeto aresta que tem dois elementos
					a.setPrimeiro(i);	// Primeiro (para receber o vertice q sai aresta)
					a.setSegundo(j);    // Segundo (vertice q recebe)
					arestas.add(a);		// Colocado dentro de uma lista de arestas;
					totalArest++;		// quantidade total de arestas incrementada;
				}
			}
		}
		
		return totalArest;
	}
		
	
	public static int[][] carregarTxt(){
	     int vertices = 0;
	        try {
	               BufferedReader arquivo = new BufferedReader(new FileReader("entrada.txt"));
	               Scanner scanner = new Scanner(arquivo);
	               while ((arquivo.readLine()) != null) {
	                    vertices++;
	                }
	        } catch (IOException e) {
	                e.getMessage();
	        }
	        
	        int matriz[][];
	        matriz = new int[vertices][vertices];
	        Scanner entrada;
	        
	        try{
	            entrada = new Scanner(new File("entrada.txt"));
	            for(int i = 0; i < vertices; i++){
	                for(int j = 0; j < vertices; j++){
	                    matriz[i][j] = entrada.nextInt();
	                }
	            }
	            System.out.println("Arquivo carregado");

	        }catch(FileNotFoundException e ){
	            System.out.println(e.getMessage());
	        }
	        
	        return matriz;
	}
	
	public static void main(String[] args) {
		int totalVert = 14;
		
		ArrayList<Aresta> arestas = new ArrayList<Aresta>(); // Lista de aresta do grafo;
		
		int totalArest = Graph(totalVert, arestas);
						
		conjuntoIndependenteMaximo(arestas, totalArest, totalVert);
	}
}
