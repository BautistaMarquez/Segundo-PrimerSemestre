package Punto6;


import Punto4.BinaryTree;

public class Programa {

	public static void main(String[] args) {
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
		arbol2.addRightChild(arbol4);
		arbol3.addLeftChild(arbol5);
		arbol3.addRightChild(arbol6);
		arbol5.addLeftChild(arbol7);
		arbol5.addRightChild(arbol8);
		
		
		Transformacion trans = new Transformacion(arbol);
		trans.getArbol().porNiveles();
		trans.suma();
		System.out.println("suma:");
		trans.getArbol().porNiveles();

	}

}