package Punto2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Punto1.GeneralTree;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(3);
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(19);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(25);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(31);
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(7);
		
		raiz.addChild(hijo1);
		raiz.getChildren().add(hijo2);
		raiz.getChildren().add(hijo3);
		hijo1.addChild(hijo11);
		
		List<Integer> lista = new LinkedList<Integer>();
		RecorridosAG prueba = new RecorridosAG();
		
		lista = prueba.numerosImparesMayoresQuePreOrden(raiz, 1);
		
		Iterator it = lista.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
			}
		System.out.println("-------");
		List<Integer> lista2 = new LinkedList<Integer>();
		
		lista2 = prueba.numerosImparesMayoresQuePostOrden(raiz, 1);
		
		Iterator it2 = lista2.iterator();
		
		while (it2.hasNext()) {
			System.out.println(it2.next());
			}
		
		System.out.println("-------");
		
		List<Integer> lista3 = new LinkedList<Integer>();
		
		lista3 = prueba.numerosImparesMayoresQuePorNiveles(raiz, 1);
		
		Iterator it3 = lista3.iterator();
		
		while (it3.hasNext()) {
			System.out.println(it3.next());
			}
		
		System.out.println("-------");
		
		List<Integer> lista4 = new LinkedList<Integer>();
		
		lista4 = prueba.numerosImparesMayoresQueInOrden(raiz, 1);
		
		Iterator it4 = lista4.iterator();
		
		while (it4.hasNext()) {
			System.out.println(it4.next());
			}
		
		
		
	}
}
