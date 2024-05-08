package Punto2;

import Punto2.BinaryTree;
import Punto2.Queue;
import java.util.List;
import java.util.ArrayList;
public class Programa {
	public static void main(String[]args) {
		BinaryTree<Integer> arbol = new BinaryTree(20);
		BinaryTree<Integer> arbol2 = new BinaryTree(30);
		BinaryTree<Integer> arbol3 = new BinaryTree(6);
		BinaryTree<Integer> arbol4 = new BinaryTree(2);
		BinaryTree<Integer> arbol5 = new BinaryTree(10);
		BinaryTree<Integer> arbol6 = new BinaryTree(1);
		BinaryTree<Integer> arbol7 = new BinaryTree(0);
		int hojas = 0;
		arbol.addRightChild(arbol2);
		arbol.addLeftChild(arbol3);
		arbol.getLeftChild().addLeftChild(arbol4);
		arbol.getLeftChild().addRightChild(arbol5);
		arbol.getLeftChild().getLeftChild().addLeftChild(arbol6);
		arbol.getLeftChild().getLeftChild().getLeftChild().addLeftChild(arbol7);
		//System.out.println(arbol.contarHojas()); //punto A funciona !!!
		
		BinaryTree<Integer> arbolCopia = new BinaryTree();
		
		//arbolCopia = arbol.espejo(); //punto B
		
		//arbol.preOrden(); //Verificacion punto B
		
		//arbolCopia.preOrden(); //Verificacion punto B
		// funciona !!!
		
		//arbol.porNiveles();
		arbol.entreNiveles(1,3); //funciona!
	}
}
