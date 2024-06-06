package Punto2;

import java.util.Iterator;
import java.util.LinkedList;

import Punto1.Vertex;
import Punto1.adjList.AdjListGraph;
import Punto2.Recorridos;

public class Prueba<T> {
	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		Vertex vert1 = grafo.createVertex("BSAS");
		Vertex vert2 = grafo.createVertex("LaPlata");
		Vertex vert3 = grafo.createVertex("Berisso");
		Vertex vert4 = grafo.createVertex("San Juan");
		Vertex vert5 = grafo.createVertex("San Luis");
		grafo.connect(vert1, vert2,10);
		grafo.connect(vert1, vert5,99);
		grafo.connect(vert2, vert1,2);
		grafo.connect(vert2, vert3,6);
		grafo.connect(vert3, vert4,3);
		grafo.connect(vert4, vert5,7);
		
		LinkedList r = new LinkedList();
		LinkedList r2 = new LinkedList();
		
		Recorridos recorrido = new Recorridos();
		r = recorrido.bfs(grafo);
		
		System.out.println(r.get(4)); //San Juan
		
		r2 = recorrido.dfs(grafo);
		
		System.out.println(r2.get(4)); //San Luis
		
	}
}
