package Punto7;
import Punto4.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public void setArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol;
	}
	
	public int calculoFinal(BinaryTree<Integer> ab) { //aca tengo el mismo error ya que no puedo pasar el valor e actualizarlo, me esta faltando alguna data
		int valor = 0; //con esto ya esta funcionando !!!
		if((ab.hasLeftChild())||(ab.hasRightChild())) {
			valor = valor+1;
		}
		if(ab.hasLeftChild()) {
			valor = valor+calculoFinal(ab.getLeftChild());
		}
		if(ab.hasRightChild()) {
			valor = valor+calculoFinal(ab.getRightChild());
		}
		return valor;
	}
	
	public int calculo(BinaryTree<Integer> a) {//hice que todos devuelvan INT menos el "primero" que es el que el ejercicio pide que devuelva boolean
		if((a.isEmpty())||(a.isLeaf())) {
			return 0;
		}else {
			int izq = 0;
			int der = 0;
			if(a.hasLeftChild()) {
				izq = calculoFinal(a.getLeftChild());
			}else {
				izq = -1;
			}
			if(a.hasRightChild()) {
				der = calculoFinal(a.getRightChild());
			}else {
				der = -1;
			}
			System.out.print("El valor de IZQUIERDA es ");
			System.out.println(izq);
			System.out.print("El valor de DERECHA es ");
			System.out.println(der);
			
			if(izq>der) {
				return 1;
			}else return 0;

		}

	}
	
	public int recorrido (BinaryTree<Integer> a, int num) { //me falta acomodar esto
		int r = 0;
		if(a.getData() == num) {
			r = calculo(a);
			System.out.print("El resultado es ");
			System.out.println(r);
			return r;
			
		}else {
			if(a.hasLeftChild()) {
				r = r+recorrido(a.getLeftChild(),num);
			}
			if(a.hasRightChild()) {
				r = r+recorrido(a.getRightChild(),num);
			}
			return r;
		}
	}
	
	
	
	
	public boolean isLeftTree (int num) {
		int retorno;
		boolean resultado;
		retorno = recorrido(this.arbol,num); //SI RETORNO = 1 devuelvo TRUE, sino FALSE.
		if(retorno < 1) {
			resultado = false;
		}	else resultado = true;
		return resultado;
	}
}
