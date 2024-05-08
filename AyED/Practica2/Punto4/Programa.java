package Punto4;

import Punto4.BinaryTree;
import Punto4.RedBinariaLlena;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Programa {
	public static void main(String[]args) {
		BinaryTree<Integer> arbol = new BinaryTree(10);
		BinaryTree<Integer> arbol2 = new BinaryTree(2);
		BinaryTree<Integer> arbol3 = new BinaryTree(3);
		BinaryTree<Integer> arbol4 = new BinaryTree(5);
		BinaryTree<Integer> arbol5 = new BinaryTree(4);
		BinaryTree<Integer> arbol6 = new BinaryTree(9);
		BinaryTree<Integer> arbol7 = new BinaryTree(8);
		BinaryTree<Integer> arbol8 = new BinaryTree(7);
		BinaryTree<Integer> arbol9 = new BinaryTree(8);
		BinaryTree<Integer> arbol10 = new BinaryTree(5);
		BinaryTree<Integer> arbol11 = new BinaryTree(6);
		BinaryTree<Integer> arbol12 = new BinaryTree(12);
		BinaryTree<Integer> arbol13 = new BinaryTree(8);
		BinaryTree<Integer> arbol14 = new BinaryTree(2);
		BinaryTree<Integer> arbol15 = new BinaryTree(1);
		arbol.addLeftChild(arbol2);
		arbol.addRightChild(arbol3);
		arbol.getLeftChild().addLeftChild(arbol4);
		arbol2.addRightChild(arbol5);
		arbol4.addLeftChild(arbol8);
		arbol4.addRightChild(arbol9);
		arbol5.addLeftChild(arbol10);
		arbol5.addRightChild(arbol11);
		arbol3.addLeftChild(arbol6);
		arbol3.addRightChild(arbol7);
		arbol6.addLeftChild(arbol12);
		arbol6.addRightChild(arbol13);
		arbol7.addLeftChild(arbol14);
		arbol7.addRightChild(arbol15);
		
		
		RedBinariaLlena red = new RedBinariaLlena(arbol);
		int valor;
		valor = red.RetardoReenvio();
		System.out.print(valor);
		//Funciona !!!
	}
}
