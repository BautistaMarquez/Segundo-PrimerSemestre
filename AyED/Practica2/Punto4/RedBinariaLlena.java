package Punto4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class RedBinariaLlena {
	private BinaryTree<Integer> red;
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.red = a;
	}
	
	public void recorrido(BinaryTree<Integer> reda, ArrayList<Integer> a, int valor) {
		valor = valor + reda.getData();
		if(reda.isLeaf()) {
			a.add(valor);
    	}else
    	if(reda.hasLeftChild()) {
    		this.recorrido(reda.getLeftChild(),a, valor);;
    	}
    	if(reda.hasRightChild()) {
    		this.recorrido(reda.getRightChild(), a, valor);
    	}
	}
	
	public int RetardoReenvio() {
		int max = 0;
		int valor = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		this.recorrido(this.red, a, valor);
		a.add(0); //Uso este condicion para cortar el while porque con el iterator se me rompe todo y nose porque. 
		int i = 0;
		while (a.get(i) != 0) {
			if(a.get(i) > max) {
				max = a.get(i);
			}
			i = i+1;
			}
		return max; //Fuciona, devuelve el 34 !!!!
	}
}
