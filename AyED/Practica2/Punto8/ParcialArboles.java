package Punto8;
import Punto4.*;
public class ParcialArboles {

	public int recorrido (BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		int valor = 0;
		if(a2.getData() == a1.getData()) {
			if((a2.hasLeftChild())&&(a1.hasLeftChild())) {
				valor = valor+recorrido(a1.getLeftChild(),a2.getLeftChild());
			}
			if(a2.hasRightChild()&&(a1.hasRightChild())) {
				valor = valor+recorrido(a1.getRightChild(),a2.getRightChild());
			}
		}else {
			valor = valor + 1;
		
		}
		System.out.println(valor);
		return valor;
	}
	
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean resultado;
		int valorFinal;
		valorFinal = recorrido(arbol1,arbol2);
		System.out.print("El valor final es ");
		System.out.println(valorFinal);
		if(valorFinal == 0) {
			resultado = true;
		}else {
			resultado = false;
		}
		return resultado;
	}
}
