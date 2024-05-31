package Punto2;

import java.util.Iterator;
import java.util.LinkedList;

import Punto1.Vertex;
import Punto1.adjList.AdjListGraph;
import Punto2.Recorridos;

public class Prueba<T> {
	public static void main(String[]args) {
		AdjListGraph grafo = new AdjListGraph<>();
		Vertex vert1 = grafo.createVertex(1);
		Vertex vert2 = grafo.createVertex(2);
		Vertex vert3 = grafo.createVertex(3);
		grafo.connect(vert1, vert2);
		grafo.connect(vert1, vert3);
		grafo.connect(vert2, vert1);
		
		LinkedList r = new LinkedList();
		
		Recorridos recorrido = new Recorridos();
		r = recorrido.bfs(grafo);
		
		System.out.println(r.get(2));
		
	}
}
