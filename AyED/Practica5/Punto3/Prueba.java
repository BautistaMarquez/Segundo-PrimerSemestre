package Punto3;

import java.util.LinkedList;
import java.util.List;
import Punto1.*;
import Punto1.adjList.*;
import Punto1.adjMatrix.*;
import Punto3.mapaCiudades;

public class Prueba {
	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		Vertex vert1 = grafo.createVertex("BSAS");
		Vertex vert2 = grafo.createVertex("LaPlata");
		Vertex vert3 = grafo.createVertex("Berisso");
		Vertex vert4 = grafo.createVertex("San Juan");
		Vertex vert5 = grafo.createVertex("San Luis");
		grafo.connect(vert1, vert2,10);
		grafo.connect(vert2, vert5,99);
		grafo.connect(vert2, vert1,2);
		grafo.connect(vert2, vert3,6);
		grafo.connect(vert3, vert4,3);
		grafo.connect(vert4, vert5,7);
		List<String> r = new LinkedList<String>();
		mapaCiudades ciudades = new mapaCiudades(grafo);
		// creo que deberia usar dos listas en todos los procedimientos.
		r = ciudades.devolverCamino("LaPlata","San Juan");
		
		System.out.println(r); //de esta forma imprime todo la LinkedList, no tenia idea. 
		
		// -2-
		List<String> r2 = new LinkedList<String>();
		List<String> excepciones = new LinkedList<String>();
		excepciones.add("Berisso");
		r2 = ciudades.devolverCaminoExceptuado("LaPlata","San Luis",excepciones);
		
		System.out.println(r2); // Funciona. Es la mejor manera? Probablemente no. Pero bueno es lo que se me ocurrio a mi. Despues tendria que ver mejores formas.
		
		// -3-
		
		List<String> r3 = new LinkedList<String>();
		r3 = ciudades.caminoMasCorto("BSAS","San Luis");
		
		System.out.println(r3);
		
		// -4-
		
		List<String> r4 = new LinkedList<String>();
		r4 = ciudades.caminoSinCargarCombustible("BSAS","San Luis",150);//creo que esta quedo bastante bien, despues tendria que revisar los anteriores mejor.
		
		System.out.println(r4); //Funciona. Seguramente se pueda hacer de otra manera, y la manera que yo utilice no es la mejor. Pero esta hecho.
	}
}
