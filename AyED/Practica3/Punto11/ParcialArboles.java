package Punto11;
import java.util.LinkedList;
import java.util.List;

import Punto1.*;
public class ParcialArboles {
	
	public static boolean crecientePorNiveles(GeneralTree<Integer> arbol) {
		boolean resultado = true;
		int nivel = 0;
		int sigNivel = 0;
		Queue<GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>>();
		GeneralTree<Integer> actual = new GeneralTree<Integer>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			actual = cola.dequeue();
			if(actual != null) {
				sigNivel = sigNivel +1;
				List<GeneralTree<Integer>> lista = actual.getChildren();
				for(GeneralTree<Integer> hijo: lista) {
					cola.enqueue(hijo);
				}
			}else {
				if(sigNivel == nivel+1) {
					nivel = nivel+1;
					sigNivel = 0;
				}else return false;
				if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		
		return resultado;
	}
	
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean resultado = crecientePorNiveles(arbol);
		return resultado;
	}
	
	
	
	
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(1);
		
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(0);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(1);
		
		
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo12 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(1);

		
		GeneralTree<Integer> hijo111 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo112 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo113 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo221 = new GeneralTree<Integer>(0);

		
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);

		
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		hijo2.addChild(hijo21);


		hijo11.addChild(hijo111);
		hijo11.addChild(hijo112);
		hijo11.addChild(hijo113);
		hijo21.addChild(hijo221);
		
		System.out.println(resolver(raiz));
		//Funciona. De este si que no tengo ninguna duda, supongo que esta resuelto de la forma correcta.
	
	}
}
