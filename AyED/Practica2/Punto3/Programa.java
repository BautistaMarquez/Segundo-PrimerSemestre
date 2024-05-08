package Punto3;

import Punto3.BinaryTree;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/*
 Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.
*/
public class Programa {
	public static void main(String[]args) {
		BinaryTree<Integer> arbol = new BinaryTree(20);
		BinaryTree<Integer> arbol2 = new BinaryTree(30);
		BinaryTree<Integer> arbol3 = new BinaryTree(5);
		BinaryTree<Integer> arbol4 = new BinaryTree(2);
		BinaryTree<Integer> arbol5 = new BinaryTree(10);
		BinaryTree<Integer> arbol6 = new BinaryTree(1);
		BinaryTree<Integer> arbol7 = new BinaryTree(0);
		arbol.addRightChild(arbol2);
		arbol.addLeftChild(arbol3);
		arbol.getLeftChild().addLeftChild(arbol4);
		arbol.getLeftChild().addRightChild(arbol5);
		arbol.getLeftChild().getLeftChild().addLeftChild(arbol6);
		arbol.getLeftChild().getLeftChild().getLeftChild().addLeftChild(arbol7);
		List<Integer> lista1 = new ArrayList();
		List<Integer> lista2 = new ArrayList();
		ContadorArbol cont = new ContadorArbol (arbol);
		lista1 = cont.numerosPares1();
		lista2 = cont.numerosPares2();
		Iterator it = lista1.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
			}
		System.out.println();
		Iterator it2 = lista2.iterator();
	
	while (it2.hasNext()) {
		System.out.println(it2.next());
	}	
	}	
}
//Funciona !!!
