package Punto9;

import Punto4.BinaryTree;

/*
Escribir en una clase ParcialArboles el método público con la siguiente firma:
public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol)
El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada
nodo dos tipos de información:
● La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
● La diferencia entre el número almacenado en el nodo original y el número almacenado en el
nodo padre.
*/
public class Programa {
	public static void main(String []args) {
		BinaryTree<Integer> arbol = new BinaryTree(20);
		BinaryTree<Integer> arbol2 = new BinaryTree(5);
		BinaryTree<Integer> arbol3 = new BinaryTree(30);
		BinaryTree<Integer> arbol4 = new BinaryTree(-5);
		BinaryTree<Integer> arbol5 = new BinaryTree(50);
		BinaryTree<Integer> arbol6 = new BinaryTree(-9);
		BinaryTree<Integer> arbol7 = new BinaryTree(4);
		BinaryTree<Integer> arbol8 = new BinaryTree(6);
		arbol.addLeftChild(arbol2);
		arbol.addRightChild(arbol3);
		arbol2.addLeftChild(arbol4);
		arbol3.addLeftChild(arbol5);
		arbol3.addRightChild(arbol6);
		arbol5.addRightChild(arbol7);
		arbol7.addRightChild(arbol8);
		
		BinaryTree<vector> arbolSuma = new BinaryTree<vector>();//el tipo vector es clase que yo cree para guardar los dos arboles.
		ParcialArboles prueba = new ParcialArboles();
		
		arbolSuma = prueba.sumAndDif(arbol); //para poder ver el arbol vector creo que deberia hacer un metodo especial, pero ya fue.
		
		
	}
}
