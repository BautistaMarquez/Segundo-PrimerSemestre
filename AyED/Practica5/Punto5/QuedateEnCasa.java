package Punto5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Punto1.Edge;
import Punto1.Graph;
import Punto1.Vertex;
import Punto1.adjList.AdjListGraph;

public class QuedateEnCasa {
	//No lo hago de tipo persona ya que es un paja
	public static List<String> bfs(int i, AdjListGraph<String> grafo, boolean[] marca,int grado) {
		int gradoActual = 0;
		AdjListGraph<String> grafo2 = new AdjListGraph<String>();
		List<String> resultado = new LinkedList<String>();
		 Queue<Vertex<String>> q = new LinkedList<Vertex<String>>(); //probe usando el AdjListVertex, e igualmente me sigue saltando el mismo error.No me dejaba hacer el Queue normal nose porque.
		 q.add(grafo.getVertex(i));//Vi esto de la LinkedList en StackOverFlow.
		 marca[i] = true;
		 Vertex<String> v = grafo2.createVertex(null); // Para encolar los null creo que esta seria la forma correcta, de la manera "normal" no los toma.
		 q.add(v);
		 while (!q.isEmpty() && gradoActual <= grado) { //Con la segunda parte de la condicion corto el while cuando ya llegue al grado.
		 Vertex<String> w = q.poll();
		 System.out.println(w.getData());
		 if(w.getData() != null) {
			 if(gradoActual>0 && gradoActual <= grado) {
				 resultado.add(w.getData());
			 }
				 List<Edge<String>> adyacentes = grafo.getEdges(w);
				 for (Edge<String> e: adyacentes) {
				 int j = e.getTarget().getPosition();
				 if (!marca[j]) {
				 marca[j] = true;
				 q.add(e.getTarget());
			   
			}
		 }
	  } 
	  else {
		  gradoActual = gradoActual +1;
		  if(!q.isEmpty()) //me faltaba esta condicion, por eso el loop.
			  q.add(v);
	  }
	 }
		 return resultado;
	}
	
	public static List<String> paseoEnBici(AdjListGraph<String> grafo, int empleado ,int grado){ // en la filmina solo pasa el destino, supongo que tambien tendria que pasar la ciudad 1
		List<String> resultado = new LinkedList<String>();
		boolean[] marcas = new boolean[grafo.getSize()];
		resultado = bfs(empleado,grafo,marcas,grado);
		return resultado;
	}
	
	
	
	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		
		Vertex vert1 = grafo.createVertex("Empleado");
		Vertex vert2 = grafo.createVertex("Jubilado1");
		Vertex vert3 = grafo.createVertex("Jubilado2");
		Vertex vert4 = grafo.createVertex("Jubilado3");
		Vertex vert5 = grafo.createVertex("Jubilado4");
		Vertex vert6 = grafo.createVertex("Jubilado5");
		Vertex vert7 = grafo.createVertex("Jubilado6");
		Vertex vert8 = grafo.createVertex("Jubilado7");
		Vertex vert9 = grafo.createVertex("Jubilado8");
		Vertex vert10 = grafo.createVertex("Jubilado9");
		
		
		grafo.connect(vert1, vert2);
		grafo.connect(vert1, vert3);
		grafo.connect(vert1, vert4);
		grafo.connect(vert2, vert5);
		grafo.connect(vert2, vert3);
		grafo.connect(vert3, vert4);
		grafo.connect(vert3, vert2);
		grafo.connect(vert4, vert5);
		grafo.connect(vert4, vert6);
		grafo.connect(vert5, vert7);
		grafo.connect(vert5, vert9);
		grafo.connect(vert6, vert8);
		grafo.connect(vert6, vert3);
		grafo.connect(vert7, vert2);
		grafo.connect(vert7, vert9);
		grafo.connect(vert8, vert9);
		grafo.connect(vert8, vert4);
		grafo.connect(vert9, vert10);
		
		List<String> resultado = new LinkedList<String>();
		
		resultado = paseoEnBici(grafo,0,2);
		
		System.out.println(resultado);
		//Funciona, me trabe un poco por la boludez, de olvidarme de la condicion de corte de los recorridos por niveles pero no fue tan dificil.
	}
}
