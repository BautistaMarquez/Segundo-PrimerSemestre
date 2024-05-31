package Punto2;

import Punto1.Edge;
import Punto1.Graph;
import Punto1.Vertex;
import Punto1.adjList.*;

import java.util.*;
import java.util.List;
import java.util.Queue;


public class Recorridos<T> {
	
	public LinkedList<T> dfs(Graph<T> grafo) {
		 LinkedList<T> resultado = new LinkedList<T>();
		 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
		 for (int i = 0; i < grafo.getSize(); i++) {
		 if (!marca[i]) { //si el vertice de la pos I no esta marcado
		 dfs(i, grafo, marca,resultado); //ingresa al dfs
		 }
	  }
		 return resultado;
	}
		private void dfs(int i, Graph<T> grafo, boolean[] marca, List<T> r) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i); //me guardo el vertice
		r.add(v.getData()); //guardo el valor en la lista
		List<Edge<T>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
		for (Edge<T> e: adyacentes){ //itero las adyacencias
		 int j = e.getTarget().getPosition();
		 if (!marca[j]) { //si no lo visite 
		 dfs(j, grafo, marca,r); //hago el dfs "interno"
		 }
	  }
	}
		
	
	public LinkedList<T> bfs(Graph<T> grafo) {
		LinkedList<T> resultado = new LinkedList<T>();
		 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
		 for (int i = 0; i < grafo.getSize(); i++) {
		 if (!marca[i]) { //si el vertice de la pos I no esta marcado
		 bfs(i, grafo, marca,resultado); //ingresa al bfs
		 }
	  }
		 return resultado;	
	}
	
	private void bfs(int i, Graph<T> grafo, boolean[] marca,List<T> r) {
		 Queue<Vertex<T>> q = new LinkedList<Vertex<T>>(); //probe usando el AdjListVertex, e igualmente me sigue saltando el mismo error.
		 q.add(grafo.getVertex(i));//Vi esto de la LinkedList en StackOverFlow.
		 marca[i] = true;
		 while (!q.isEmpty()) {
		 Vertex<T> w = q.poll();
		 r.add(w.getData());
		 List<Edge<T>> adyacentes = grafo.getEdges(w);
		 for (Edge<T> e: adyacentes) {
		 int j = e.getTarget().getPosition();
		 if (!marca[j]) {
		 marca[j] = true;
		 q.add(e.getTarget());
	   }
	  }
	 }
	}
	
}



