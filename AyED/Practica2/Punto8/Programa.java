package Punto8;
/*
Escribir en una clase ParcialArboles el método público con la siguiente firma:
public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide
con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su
estructura. Por ejemplo, en la siguiente imagen: arbol1 ES prefijo de arbol2.
*/

import Punto4.BinaryTree;

public class Programa {
	public static void main(String []args) {
		BinaryTree<Integer> arbol = new BinaryTree(1);
		BinaryTree<Integer> arbol2 = new BinaryTree(2);
		BinaryTree<Integer> arbol3 = new BinaryTree(3);
		BinaryTree<Integer> arbol4 = new BinaryTree(4);
		BinaryTree<Integer> arbol5 = new BinaryTree(5);
		BinaryTree<Integer> arbol6 = new BinaryTree(6);
		BinaryTree<Integer> arbol7 = new BinaryTree(7);
		BinaryTree<Integer> arbol8 = new BinaryTree(8);
		arbol.addLeftChild(arbol2);
		arbol.addRightChild(arbol3);
		arbol2.addLeftChild(arbol4);
		arbol3.addLeftChild(arbol5);
		arbol3.addRightChild(arbol6);
		arbol5.addLeftChild(arbol7);
		
		
		
		BinaryTree<Integer> arboll = new BinaryTree(1);
		BinaryTree<Integer> arboll2 = new BinaryTree(2);
		BinaryTree<Integer> arboll3 = new BinaryTree(3);
		
		arboll.addLeftChild(arboll2);
		arboll.addRightChild(arboll3);
		
		ParcialArboles prueba = new ParcialArboles();
		
		boolean resultado;
		
		resultado = prueba.esPrefijo(arboll, arbol);
		
		System.out.println(resultado);
	}
}
