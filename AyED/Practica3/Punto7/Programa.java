package Punto7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Punto1.GeneralTree;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(17);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(9);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(15);
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(10);
		GeneralTree<Integer> hijo12 = new GeneralTree<Integer>(6);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(8);
		GeneralTree<Integer> hijo31 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> hijo32 = new GeneralTree<Integer>(18);
		GeneralTree<Integer> hijo121 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> hijo311 = new GeneralTree<Integer>(16);
		GeneralTree<Integer> hijo312 = new GeneralTree<Integer>(7);
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		raiz.addChild(hijo3);
		
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		
		hijo2.addChild(hijo21);
		
		hijo3.addChild(hijo31);
		hijo3.addChild(hijo32);
		
		hijo12.addChild(hijo121);
		
		hijo31.addChild(hijo311);
		hijo31.addChild(hijo312);
		
		Caminos prueba = new Caminos(raiz);
		
		List<Integer> camino = new LinkedList<Integer>();
		
		camino = prueba.caminoAHojaMasLejana();
		
		Iterator it = camino.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			
		}
		
	}
}
//Funciona.
//Actualizado en clase, ya que estaba mal que se use la funcion altura(); ya que esta recorre el arbol para obtener la altura y la idea es solo recorrer el arbol una vez.
