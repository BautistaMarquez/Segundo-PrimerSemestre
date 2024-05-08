package Punto6;

import Punto4.BinaryTree;


public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> getArbol() {
		return arbol;
	}
	
	public Transformacion(BinaryTree<Integer> tree) {
		this.arbol = tree;
	}
	
	private int suma(BinaryTree<Integer> a) {
		int sumar = 0;
		if (a.isLeaf()) {
			sumar = a.getData();
			a.setData(0);
			return sumar;
		}
		if (a.hasLeftChild()) {
			sumar= sumar+suma(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			sumar= sumar+suma(a.getRightChild());
		}
		int aux = a.getData();
		a.setData(sumar);
		return sumar+aux;
	}
	
	public BinaryTree<Integer> suma() {
		suma(this.getArbol());
		return this.getArbol();
	}
}
