package Punto3;
import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	private void inOrden (BinaryTree<Integer> a,List<Integer> l) {
		if(a.hasLeftChild()) {
			this.inOrden(a.getLeftChild(), l);
		}
		if(a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		if(a.hasRightChild()) {
			this.inOrden(a.getRightChild(), l);
		}
	}
	
	public List<Integer> numerosPares1(){
		List<Integer> l = new ArrayList();
		this.inOrden(this.arbol,l);
		return l;
	}
	
	private void postOrden (BinaryTree<Integer> a,List<Integer> l) {
		if(a.hasLeftChild()) {
			this.postOrden(a.getLeftChild(), l);
		}
		if(a.hasRightChild()) {
			this.postOrden(a.getRightChild(), l);
		}
		if(a.getData() % 2 == 0) {
			l.add(a.getData());
		}
	}
	
	public List<Integer> numerosPares2(){
		List<Integer> l = new ArrayList();
		this.postOrden(this.arbol, l);
		return l;
	}
}
