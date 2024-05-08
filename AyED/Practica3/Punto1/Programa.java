package Punto1;

import java.util.List;
import java.util.LinkedList;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(10);
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(20);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(25);
		GeneralTree<Integer> hijo3 = new GeneralTree<Integer>(33);
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(1);
		
		raiz.addChild(hijo1);
		raiz.getChildren().add(hijo2);
		raiz.getChildren().add(hijo3);
		hijo1.addChild(hijo11);
		
		raiz.preOrder();
		System.out.println("-----");
		raiz.postOrder();
		
	}
}
