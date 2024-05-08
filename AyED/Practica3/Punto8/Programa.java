package Punto8;

import Punto1.GeneralTree;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(14);
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(13);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(25);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(10);
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(4);
		GeneralTree<Integer> hijo12 = new GeneralTree<Integer>(7);
		GeneralTree<Integer> hijo13 = new GeneralTree<Integer>(5);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(6);
		GeneralTree<Integer> hijo22 = new GeneralTree<Integer>(10);
		GeneralTree<Integer> hijo23 = new GeneralTree<Integer>(18);
		GeneralTree<Integer> hijo31 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> hijo32 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hijo33 = new GeneralTree<Integer>(19);
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		raiz.addChild(hijo3);
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		hijo1.addChild(hijo13);
		hijo2.addChild(hijo21);
		hijo2.addChild(hijo22);
		hijo2.addChild(hijo23);
		hijo3.addChild(hijo31);
		hijo3.addChild(hijo32);
		hijo3.addChild(hijo33);
		
		Navidad prueba = new Navidad(raiz);
		
		System.out.println(prueba.esAbeto());
		//Funciona!!
		//Entendi mal el ejercicio, lo estuve leyendo y no entiendo como seria. Es confuso.
		//Todo nodo que no sae HOJA tiene que TENER tres hijos o MAS que sean HOJA. => Con esta data ya supongo que voy a poder hacer el ejercicio.
		
	}
}
