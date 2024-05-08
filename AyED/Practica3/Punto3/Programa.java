package Punto3;

import Punto1.GeneralTree;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(3);
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(19);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(25);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(31);
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(7);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(28);
		GeneralTree<Integer> hijo31 = new GeneralTree<Integer>(312);
		GeneralTree<Integer> hijo22 = new GeneralTree<Integer>(22);
		GeneralTree<Integer> hijo32 = new GeneralTree<Integer>(22);
		GeneralTree<Integer> hijo33 = new GeneralTree<Integer>(22);
		GeneralTree<Integer> hijo34 = new GeneralTree<Integer>(22);
		GeneralTree<Integer> hijo35 = new GeneralTree<Integer>(22);
		raiz.addChild(hijo1);
		raiz.getChildren().add(hijo2);
		raiz.getChildren().add(hijo3);
		hijo1.addChild(hijo11);
		hijo2.addChild(hijo21);
		hijo2.addChild(hijo22);
		hijo3.addChild(hijo31);
		hijo3.addChild(hijo32);
		hijo3.addChild(hijo33);
		hijo3.addChild(hijo34);
		hijo3.addChild(hijo35);
		
		int altura;
		
		altura = raiz.altura();
		
		System.out.println(altura);
		
		int nivel;
		
		nivel = raiz.nivel(31);
		
		System.out.println(nivel);
		
		int amplitud;
		
		amplitud = raiz.ancho(); 
		
		System.out.println(amplitud);
		//funcionan todos.
	}
}
