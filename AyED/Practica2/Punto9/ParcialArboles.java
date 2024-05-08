package Punto9;
import Punto4.*;
public class ParcialArboles {

	public int suma(BinaryTree<Integer> a, BinaryTree<Integer> a2, int num){
		num = num + a.getData();
		a2.setData(num);
		if(a.hasLeftChild()) {
			a2.addLeftChild(new BinaryTree<Integer>());
			suma(a.getLeftChild(),a2.getLeftChild(),num);
		}
		if(a.hasRightChild()) {
			a2.addRightChild(new BinaryTree<Integer>());
			suma(a.getRightChild(),a2.getRightChild(),num);
		}
		return num;
	}
	
	public void dif(BinaryTree<Integer> a2,BinaryTree<Integer> a3) {
		int num;
		if(a2.hasLeftChild()) {
			a3.addLeftChild(new BinaryTree<Integer>());
			num = a2.getLeftChild().getData() - a2.getData();
			a3.getLeftChild().setData(num);
			dif(a2.getLeftChild(),a3.getLeftChild());
		}
		if(a2.hasRightChild()) {
			a3.addRightChild(new BinaryTree<Integer>());
			num = a2.getRightChild().getData() - a2.getData() ;
			a3.getRightChild().setData(num);
			dif(a2.getRightChild(),a3.getRightChild());
		}
	}
	
	public void carga(BinaryTree<Integer> a2,BinaryTree<Integer> a3,BinaryTree<vector> r) {
		r.getData().setContenidoParcial(0, a2.getData());
		r.getData().setContenidoParcial(1, a3.getData());
		if(a2.hasLeftChild()) {
			r.addLeftChild(new BinaryTree<vector>());
			carga(a2.getLeftChild(),a3.getLeftChild(),r.getLeftChild());
		}
		if(a2.hasRightChild()) {
			r.addRightChild(new BinaryTree<vector>());
			carga(a2.getRightChild(),a3.getRightChild(),r.getRightChild());
		}
	}
	
	public BinaryTree<vector> sumAndDif(BinaryTree<Integer> arbol){
		int num = 0; //var que uso a la hora de sumar
		BinaryTree<vector> retorno = new BinaryTree<vector>();
		BinaryTree<Integer> retorno1 = new BinaryTree<Integer>();//arbol con la suma
		BinaryTree<Integer> retorno2 = new BinaryTree<Integer>();//arbol con la diferencia
		suma(arbol,retorno1,num);
		retorno1.porNiveles();
		retorno2.setData(retorno1.getData()); //seteo el primer valor del arbol de diferencia ya que es el mismo valor que el de suma
		dif(arbol,retorno2);
		retorno2.porNiveles();
		carga(retorno1,retorno2,retorno);//cargo los dos arboles en el arbol vector
		return retorno;// retorno el BinaryTree<vector> que seria el conjunto de retorno1 y retorno2, pero nose como realizarlo asique queda asi.
	}
}
