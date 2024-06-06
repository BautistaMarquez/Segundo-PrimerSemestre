package Punto3;
import java.util.LinkedList;
import java.util.List;
import Punto1.*;
import Punto1.adjList.*;
import Punto1.adjMatrix.*;

/* 
 1- devolverCamino (String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).

 2- devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).

 3- caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).

 4- caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.

 5- caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
retorna la lista vacía. 

 */



public class mapaCiudades {

	private Graph<String> ciudad = new AdjListGraph<String>();
	
	public mapaCiudades(Graph<String> c) {
		this.ciudad = c;
	}
	
	public LinkedList<String> dfs(Graph<String> grafo, int i, String ciudad2) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
		 LinkedList<String> resultado = new LinkedList<String>();
		 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
		 dfs(i, grafo, marca,resultado,ciudad2); //ingresa al dfs
		 if(resultado.get(resultado.size()-1) == ciudad2) {
			 return resultado;
		 }else {
			 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
			 return resultado2;
		 }
	}
		private void dfs(int i, Graph<String> grafo, boolean[] marca, List<String> r, String ciudad2) {
		marca[i] = true;
		Vertex<String> v = grafo.getVertex(i); //me guardo el vertice
		r.add(v.getData()); //guardo el valor en la lista
		if(v.getData() != ciudad2) {
			List<Edge<String>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
			for (Edge<String> e: adyacentes){ //itero las adyacencias
			 int j = e.getTarget().getPosition();
			 if (!marca[j]) { //si no lo visite 
				 if(r.get(r.size()-1) != ciudad2) { //es la manera que se me ocurrio para cortar la recursion. Ya que podria pasar que yo ya alla agregado ciudad2 pero como el vertice anterior tenia mas adyacencias haga devuelta el dfs y me carge mas ciudades.
				 dfs(j, grafo, marca,r,ciudad2); //hago el dfs "interno"
				 }
			 }
		}
	  }
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> resultado = new LinkedList<String>();
		List<Vertex<String>> ciudades = new LinkedList<Vertex<String>>();
		ciudades = ciudad.getVertices();
		int i;
		int comprobacion = 0;
		int pos1 = 0;
		for(i = 0; i<ciudades.size();i++) {
			if(ciudades.get(i).getData() == ciudad1 || ciudades.get(i).getData() == ciudad2) { //compruebo que esten las dos ciudades
				comprobacion = comprobacion + 1;
				if(ciudades.get(i).getData() == ciudad1) { //me guardo la posicion de la ciudad 1 para arrancar desde ese punto. No dice nada de que se tenga que recorrer el grafo una vez.
					pos1 = i;
				}
			}
		}
		if(comprobacion < 2) {
			return resultado;
		}
		resultado = dfs(ciudad,pos1,ciudad2);
		return resultado;
	}

// -2-

public LinkedList<String> dfsExceptuado(Graph<String> grafo, int i, String ciudad2,List<String> exc) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
	 LinkedList<String> resultado = new LinkedList<String>();
	 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
	 dfsExceptuado(i, grafo, marca,resultado,ciudad2,exc); //ingresa al dfsExceptuado
	 if(resultado.get(resultado.size()-1) == ciudad2) {
		 return resultado;
	 }else {
		 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
		 return resultado2;
	 }
}
	private void dfsExceptuado(int i, Graph<String> grafo, boolean[] marca, List<String> r, String ciudad2, List<String> exc) {
	int ind;
	Vertex<String> v = grafo.getVertex(i); //me guardo el vertice
	boolean puede = true;
	 for(ind = 0; ind<exc.size();ind++) {
		 if(v.getData() == exc.get(ind)) { //comparo la ciudad actual con las excepciones. 
			 puede = false;
		 }
	 }
	if(puede) { //si puede, osea que no esta en la lista de la excepciones
		marca[i] = true; 
		r.add(v.getData()); //guardo el valor en la lista
		if(v.getData() != ciudad2) { //aca empezaria el dfs normal = al anterior. ---
			List<Edge<String>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
			for (Edge<String> e: adyacentes){ //itero las adyacencias
			 int j = e.getTarget().getPosition();
			 if (!marca[j]) { //si no lo visite 
				 if(r.get(r.size()-1) != ciudad2) { //es la manera que se me ocurrio para cortar la recursion.
				  dfsExceptuado(j, grafo, marca,r,ciudad2,exc); //hago el dfs "interno"
				 }
			 }
		}
	 }	
  }
}

public List<String> devolverCaminoExceptuado(String ciudad1, String ciudad2,List<String> ciudades){
	List<String> resultado = new LinkedList<String>();
	List<Vertex<String>> camino = new LinkedList<Vertex<String>>();
	camino = ciudad.getVertices();
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
	resultado = dfsExceptuado(ciudad,pos1,ciudad2,ciudades);
	return resultado;
}

// -3-


public LinkedList<String> dfsCorto(Graph<String> grafo, int i, String ciudad2) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
	 LinkedList<String> camino = new LinkedList<String>();
	 LinkedList<String> resultado = new LinkedList<String>();
	 int peso = 0;
	 int min = 9999;
	 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
	 dfsCorto(i, grafo, marca,camino,resultado,min,peso,ciudad2); //ingresa al dfs
	 System.out.println("1");
	 if(resultado.get(resultado.size()-1) == ciudad2) { //verifico que el ultimo campo sea el DESTINO.
		 return resultado;
	 }else {
		 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
		 return resultado2;
	 }
}
	private void dfsCorto(int i, Graph<String> grafo, boolean[] marca, List<String> r,List<String> rMin,int min,int peso, String ciudad2) {
	marca[i] = true;
	Vertex<String> v = grafo.getVertex(i); 
	System.out.println(v.getData());
	r.add(v.getData()); 
	if(v.getData() != ciudad2) {
		List<Edge<String>> adyacentes = grafo.getEdges(v); 
		for (Edge<String> e: adyacentes){
		 int j = e.getTarget().getPosition();
		 if (!marca[j]) {
			 peso = peso+e.getWeight(); //voy sumando los pesos
			 dfsCorto(j, grafo, marca,r,rMin,min,peso,ciudad2); 
			 
			 peso = peso-e.getWeight(); //despues de la recursion, lo resto
			 r.remove(r.size()-1); //elimino el elemento visitado postRecursion.
		 }
	}
 } else { //aca sino deberia calcular el peso del recorrido que tengo guardado como rMin, ya que la var INT la pierdo por la recursion, seria una opcion pero nose si seria la correcta. 
	 	if(peso<min) { //si el peso del camino actual es menor al minimo
	 		min = peso;
	 		System.out.println(min);
	 		rMin.addAll(r);
	 		marca[i] = false; //Esto funciona. Pero nose como guardame el valor minimo, ya que lo pierdo por la recursion.
	 	}
	 }
}


public List<String> caminoMasCorto(String ciudad1, String ciudad2){
	List<String> resultado = new LinkedList<String>();
	List<Vertex<String>> ciudades = new LinkedList<Vertex<String>>();
	ciudades = ciudad.getVertices();
	int i;
	int comprobacion = 0;
	int pos1 = 0;
	for(i = 0; i<ciudades.size();i++) {
		if(ciudades.get(i).getData() == ciudad1 || ciudades.get(i).getData() == ciudad2) { //compruebo que esten las dos ciudades
			comprobacion = comprobacion + 1;
			if(ciudades.get(i).getData() == ciudad1) {
				pos1 = i;
			}
		}
	}
	if(comprobacion < 2) {
		return resultado;
	}
	resultado = dfsCorto(ciudad,pos1,ciudad2);
	return resultado;
 }

// -4-


public LinkedList<String> dfsSinCarga(Graph<String> grafo, int i, String ciudad2, int tanque) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
	 LinkedList<String> resultado = new LinkedList<String>();
	 LinkedList<String> camino = new LinkedList<String>();
	 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
	 dfsSinCarga(i, grafo, marca,resultado,camino,ciudad2, tanque); //ingresa al dfs
	 if(resultado.size() > 0 && resultado.get(resultado.size()-1) == ciudad2) {
		 return resultado;
	 }else {
		 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
		 return resultado2;
	 }
}
	private void dfsSinCarga(int i, Graph<String> grafo, boolean[] marca, List<String> r,List<String> camino, String ciudad2,int tanque) {
	marca[i] = true;
	Vertex<String> v = grafo.getVertex(i); //me guardo el vertice
	System.out.println(v.getData());
	camino.add(v.getData()); //guardo el valor en la lista
	System.out.println(tanque);
	if(v.getData() != ciudad2 && tanque > 0) {
		List<Edge<String>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
		for (Edge<String> e: adyacentes){ //itero las adyacencias
		 int j = e.getTarget().getPosition();
		 if (!marca[j]) { //si no lo visite 
			 if(r.size() == 0) { //este corte es para que no siga recorriendo si ya llego pero probablemente se pueda hacer mejor.
				 tanque = tanque - e.getWeight();
				 dfsSinCarga(j, grafo, marca,r,camino,ciudad2,tanque); //hago el dfs "interno"
				 tanque = tanque + e.getWeight();
				 camino.remove(camino.size()-1);
			}
		 }
	}
 }
 else	{
	 if(v.getData() == ciudad2) {
		 marca[i] = false;
	 }
	 if(v.getData() == ciudad2 && tanque >= 0) {
		 r.addAll(camino);
		 marca[i] = true;
	 }
	 
 }
}


	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> resultado = new LinkedList<String>();
		List<Vertex<String>> ciudades = new LinkedList<Vertex<String>>();
		ciudades = ciudad.getVertices();
		int i;
		int comprobacion = 0;
		int pos1 = 0;
		for(i = 0; i<ciudades.size();i++) {
			if(ciudades.get(i).getData() == ciudad1 || ciudades.get(i).getData() == ciudad2) { //compruebo que esten las dos ciudades
				comprobacion = comprobacion + 1;
				if(ciudades.get(i).getData() == ciudad1) {
					pos1 = i;
				}
			}
		}
		if(comprobacion < 2) {
			return resultado;
		}
		resultado = dfsSinCarga(ciudad,pos1,ciudad2,tanqueAuto);
		return resultado;
 }
} // <== este habria que borrarlo.
	// -5-
	/*
	public LinkedList<String> dfsConMenorCarga(Graph<String> grafo, int i, String ciudad2, int tanque,int carga) { //seguramente se puedan mejorar muchas cosas pero por el momento es lo que se me ocurrio.
		 LinkedList<String> resultado = new LinkedList<String>();
		 LinkedList<String> camino = new LinkedList<String>();
		 boolean[] marca = new boolean[grafo.getSize()]; //creo el registro de marcas
		 dfsConMenorCarga(i, grafo, marca,resultado,camino,ciudad2, tanque,carga); //ingresa al dfs
		 if(resultado.size() > 0 || resultado.get(resultado.size()-1) == ciudad2) {
			 return resultado;
		 }else {
			 LinkedList<String> resultado2 = new LinkedList<String>(); //tambien le podria asignar valor NULL.
			 return resultado2;
		 }
	}
		private void dfsConMenorCarga(int i, Graph<String> grafo, boolean[] marca, List<String> r,List<String> camino, String ciudad2,int tanque,int carga) {
		marca[i] = true;
		Vertex<String> v = grafo.getVertex(i); //me guardo el vertice
		System.out.println(v.getData());
		camino.add(v.getData()); //guardo el valor en la lista
		System.out.println(tanque);
		if(v.getData() != ciudad2 && tanque > 0) {
			List<Edge<String>> adyacentes = grafo.getEdges(v); // creo la lista de adyacentes
			for (Edge<String> e: adyacentes){ //itero las adyacencias
			 int j = e.getTarget().getPosition();
			 if (!marca[j]) { //si no lo visite 
				 if(r.size() > 0 && r.get(r.size()-1) != ciudad2) { //este corte es para que no siga recorriendo si ya llego pero probablemente se pueda hacer mejor.
					 tanque = tanque - e.getWeight();
					 dfsConMenorCarga(j, grafo, marca,r,camino,ciudad2,tanque,carga); //hago el dfs "interno"
					 tanque = tanque + e.getWeight();
					 camino.remove(camino.size()-1);
				} else {
					if(r.size() == 0) {
						tanque = tanque - e.getWeight();
						 dfsConMenorCarga(j, grafo, marca,r,camino,ciudad2,tanque,carga); //hago el dfs "interno"
						 tanque = tanque + e.getWeight();
						 camino.remove(camino.size()-1);
					}
				}
			 }
		}
	 }
	 else	{
		 if(v.getData() == ciudad2) {
			 marca[i] = false;
		 }
		 if(v.getData() == ciudad2 && tanque >= 0) {
			 r.addAll(camino);
			 marca[i] = true;
		 }
		 
	 }
	}


		public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
			List<String> resultado = new LinkedList<String>();
			List<Vertex<String>> ciudades = new LinkedList<Vertex<String>>();
			ciudades = ciudad.getVertices();
			int i;
			int comprobacion = 0;
			int pos1 = 0;
			for(i = 0; i<ciudades.size();i++) {
				if(ciudades.get(i).getData() == ciudad1 || ciudades.get(i).getData() == ciudad2) { //compruebo que esten las dos ciudades
					comprobacion = comprobacion + 1;
					if(ciudades.get(i).getData() == ciudad1) {
						pos1 = i;
					}
				}
			}
			if(comprobacion < 2) {
				return resultado;
			}
			int cargado = tanqueAuto;
			resultado = dfsConMenorCarga(ciudad,pos1,ciudad2,tanqueAuto,cargado);
			return resultado;
	 }
}
	*/