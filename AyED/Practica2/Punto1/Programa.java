package Punto1;


public class Programa {
	public static void main(String[]args) {
		BinaryTree<Integer> arbol = new BinaryTree();
		BinaryTree<Integer> arbol2 = new BinaryTree();
		BinaryTree<Integer> arbol3 = new BinaryTree();
		BinaryTree<Integer> arbol4 = new BinaryTree();
		System.out.println(arbol.isEmpty());
		arbol.addRightChild(arbol2);
		System.out.println(arbol.hasRightChild());
		System.out.println(arbol.hasLeftChild());
		arbol.setData(1);
		arbol.getRightChild().setData(2);
		System.out.println(arbol.getData());
		System.out.println(arbol.getRightChild().getData());
	}
}
