package Punto4;

import java.util.LinkedList;
import java.util.List;

import Punto1.Edge;
import Punto1.Graph;
import Punto1.Vertex;
import Punto1.adjList.AdjListGraph;

public class VisitaOslo {
	
	
	public static LinkedList<String> dfsExceptuado(Graph<String> grafo, int i, String ciudad2,List<String> exc,int tiempo) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
		 LinkedList<String> resultado = new LinkedList<String>();
		 LinkedList<String> camino = new LinkedList<String>();
		 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
		 dfsExceptuado(i, grafo, marca,resultado,camino,ciudad2,exc,tiempo); //ingresa al dfsExceptuado
		 if(resultado.size() > 0 && resultado.get(resultado.size()-1) == ciudad2) {
			 return resultado;
		 }else {
			 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
			 return resultado2;
		 }
	}
		private static void dfsExceptuado(int i, Graph<String> grafo, boolean[] marca, List<String> r,List<String> camino, String ciudad2, List<String> exc, int tiempo) {
	   System.out.println(tiempo);
	   Vertex<String> v = grafo.getVertex(i); //me guardo el vertice
	   camino.add(v.getData()); //guardo el valor en la lista
	   if(tiempo > 0) {
		int ind;
		boolean puede = true;
		 for(ind = 0; ind<exc.size();ind++) {
			 if(v.getData() == exc.get(ind)) { //comparo la ciudad actual con las excepciones. 
				 puede = false;
			 }
		 }
		 if(puede) { //si puede, osea que no esta en la lista de la excepciones
			marca[i] = true; 
			if(v.getData() != ciudad2) { //aca empezaria el dfs normal = al anterior. ---
				List<Edge<String>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
				for (Edge<String> e: adyacentes){ //itero las adyacencias
				 int j = e.getTarget().getPosition();
				 if (!marca[j]) { //si no lo visite 
					 if(r.size() == 0) { //es la manera que se me ocurrio para cortar la recursion.
						 tiempo = tiempo - e.getWeight();
					  dfsExceptuado(j, grafo, marca,r,camino,ciudad2,exc,tiempo); //hago el dfs "interno"
					  	tiempo = tiempo + e.getWeight();
					  	camino.remove(camino.size()-1);
					 }
				 }
			}
		 } else {
			 r.addAll(camino);
		 }
	  }
	}
  }

	public static List<String> paseoEnBici(AdjListGraph<String> grafo, String ciudad1, String ciudad2,List<String> ciudades, int tiempo){ // en la filmina solo pasa el destino, supongo que tambien tendria que pasar la ciudad 1
		List<String> resultado = new LinkedList<String>();
		List<Vertex<String>> camino = new LinkedList<Vertex<String>>();
		camino = grafo.getVertices();
		int i;
		int comprobacion = 0;
		int pos1 = 0;
		for(i = 0; i<camino.size();i++) {
			if(camino.get(i).getData() == ciudad1 || camino.get(i).getData() == ciudad2) { //compruebo que esten las dos ciudades
				comprobacion = comprobacion + 1;
				if(camino.get(i).getData() == ciudad1) {
					pos1 = i;
				}
			}
		}
		if(comprobacion < 2) {
			return resultado;
		}
		resultado = dfsExceptuado(grafo,pos1,ciudad2,ciudades,tiempo);
		return resultado;
	}
	
	
	
	
	
	
	
	

	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		Vertex vert1 = grafo.createVertex("Holmenkollen");
		Vertex vert2 = grafo.createVertex("Parque Vigeland");
		Vertex vert3 = grafo.createVertex("FolkMuseum");
		Vertex vert4 = grafo.createVertex("Museo Fram");
		Vertex vert5 = grafo.createVertex("Museo Del Barco Polar");
		Vertex vert6 = grafo.createVertex("Museo Vikingo");
		Vertex vert7 = grafo.createVertex("Palacio Real");
		Vertex vert8 = grafo.createVertex("Akker Brigge");
		Vertex vert9 = grafo.createVertex("Galeria Nacional");
		Vertex vert10 = grafo.createVertex("Parque Botanico");
		Vertex vert11 = grafo.createVertex("Museo Munch");
		Vertex vert12 = grafo.createVertex("Ayuntamiento");
		Vertex vert13 = grafo.createVertex("El Tigre");
		Vertex vert14 = grafo.createVertex("La Opera");
		//tengo que hacerlos de ida y vuelta
		grafo.connect(vert1, vert2,30);
		grafo.connect(vert2, vert1,30);
		
		grafo.connect(vert2, vert3,20);
		grafo.connect(vert3, vert2,20);
		
		grafo.connect(vert2, vert9,10);
		grafo.connect(vert9, vert2,10);
		
		grafo.connect(vert3, vert4,5);
		grafo.connect(vert4, vert3,5);
		
		grafo.connect(vert3, vert7,5);
		grafo.connect(vert7, vert3,5);
		
		grafo.connect(vert3, vert8,30);
		grafo.connect(vert8, vert3,30);
		
		grafo.connect(vert4, vert5,5);
		grafo.connect(vert5, vert4,5);
		
		grafo.connect(vert5, vert6,5);
		grafo.connect(vert6, vert5,5);
		
		grafo.connect(vert6, vert8,30);
		grafo.connect(vert8, vert6,30);
		
		grafo.connect(vert7, vert12,5);
		grafo.connect(vert12, vert7,5);
		
		grafo.connect(vert8, vert12,20);
		grafo.connect(vert12, vert8,20);
		
		grafo.connect(vert9, vert10,15);
		grafo.connect(vert10, vert9,15);
		
		grafo.connect(vert10, vert11,1);
		grafo.connect(vert11, vert10,1);
		
		grafo.connect(vert10, vert12,10);
		grafo.connect(vert12, vert10,10);
		
		grafo.connect(vert11, vert13,15);
		grafo.connect(vert13, vert11,15);
		
		grafo.connect(vert12, vert13,15);
		grafo.connect(vert13, vert12,15);
		
		grafo.connect(vert13, vert14,5);
		grafo.connect(vert14, vert13,5);
		
		List<String> excepciones = new LinkedList<String>();
		excepciones.add("Akker Brigge");
		excepciones.add("Palacio Real");
		
		List<String> resultado = new LinkedList<String>();
		
		resultado = paseoEnBici(grafo, "Ayuntamiento", "Museo Vikingo", excepciones, 120);
		
		System.out.println(resultado);
		
		// Funciona !!!
	}
}
