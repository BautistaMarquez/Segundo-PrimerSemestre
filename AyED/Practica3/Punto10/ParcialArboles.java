package Punto10;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Punto1.*;
public class ParcialArboles {
	
	/*public static void DevolverLista(GeneralTree<Integer> e,List<Integer> r, int miAlt) {
		if() {
			
		}
		if(e.hasChildren()) {
			List<GeneralTree<Integer>> children = e.getChildren();
			for (GeneralTree<Integer> child: children) {
				r.add(child.getData() * miAlt);
				DevolverLista(child,r,miAlt+1);
				r.remove(r.size()-1);
			}
		}
	}*/
	
	public static void preResolver(GeneralTree<Integer> a, int alt,List<Integer> resultado) {
		int max = 0;
		System.out.println(1);
		 List<GeneralTree<Integer>> children = a.getChildren();
		 for (GeneralTree<Integer> child: children) { //voy a generar una lista por cada hijo que tenga la raiz y adentro del for voy a ir calculando cual es la que sume mas para finalmente devolver esta, es bastante quilombo pero siento que el ejercicio es complejo asique no me parece que este errado.
			 List<Integer> ListaArbol = new LinkedList<Integer>();
			 if(a.getData() != 0) {
					ListaArbol.add(a.getData() * alt);
				}
			 preResolver(child,alt+1,ListaArbol); 
			 Iterator it = ListaArbol.iterator();
			 int valor = 0;
			 int i = 0;
			 while(it.hasNext()) {
				 valor = valor + ListaArbol.get(i); //Sumo los valores de la lista, esto valores no van a ser 1 ya que seran el valor multiplicado por el nivel del mismo.
				 i = i+1;
				 it.next();
			 }
			 if(valor>max) { //si el valor de la suma es mayor al valor de la suma anterior asigno a resultado la lista que acabo de sumar.
				 resultado = ListaArbol;
				 max = valor;
			 }
		 }
		 
	}
	
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> resultado = new LinkedList<Integer>();
		int alt = 0;
		preResolver(arbol,alt,resultado);
		Iterator it = resultado.iterator();
		int i = 0;
		while(it.hasNext()) {
			resultado.add(i, 1);
			i = i +1;
			it.next();
		}
		return resultado;
	}
	
	
	
	
	
	
	
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo12 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo22 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo31 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> hijo111 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo112 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo113 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo221 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo311 = new GeneralTree<Integer>(0);
		
		GeneralTree<Integer> hijo2211 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo3111 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo3112 = new GeneralTree<Integer>(0);
		
		
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		raiz.addChild(hijo3);
		
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		hijo2.addChild(hijo21);
		hijo2.addChild(hijo22);
		hijo3.addChild(hijo31);

		hijo11.addChild(hijo111);
		hijo11.addChild(hijo112);
		hijo11.addChild(hijo113);
		hijo22.addChild(hijo221);
		hijo31.addChild(hijo311);
		
		hijo221.addChild(hijo2211);
		hijo311.addChild(hijo3111);
		hijo311.addChild(hijo3112);
	
	
	List<Integer> resultado = new LinkedList<Integer>();
	
	resultado = resolver(raiz);
	
	Iterator it = resultado.iterator();

	while(it.hasNext()) {
		System.out.println(it.next());
	}
	
	}
	
}

