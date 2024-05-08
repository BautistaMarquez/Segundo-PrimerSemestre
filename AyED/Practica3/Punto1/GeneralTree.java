package Punto1;

import java.util.Iterator;
import java.util.LinkedList;

import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public void preOrder() {
		 System.out.println(getData());
		 List<GeneralTree<T>> children = this.getChildren();
		 for (GeneralTree<T> child: children) {
		 child.preOrder();
		 }
	}

	
	public void postOrder() {
		 List<GeneralTree<T>> children = this.getChildren();
		 for (GeneralTree<T> child: children) {
		 child.postOrder();
		 }
		 System.out.println(getData());
	}
	
	public void postAltura(List<Integer> niveles,int nivel) {
		if(this.isLeaf()) {
			niveles.add(nivel);
		}
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
		 child.postAltura(niveles,nivel+1);
		 }
	}
	
	public int porNivelesAltura(GeneralTree<T> tree) {
		int alt = 0;
		GeneralTree<T> tree_aux = new GeneralTree<T>();
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		 queue.enqueue(tree);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 tree_aux = queue.dequeue();
			 if(tree_aux != null) {
				 List<GeneralTree<T>> children = tree_aux.getChildren();
				 for (GeneralTree<T> child: children) {
			
					 	queue.enqueue(child);
				 }
			 }else {
				 if(!queue.isEmpty()) {
					alt = alt + 1;
					queue.enqueue(null); 
				 }
			 }
		 }
		 return alt;
	}
	
	public int altura() {	 
		int alt = 0;
		alt = porNivelesAltura(this);
		return alt;
	} 
	
	public int porNivelesNivel(GeneralTree<T> tree,T dato) {
		int alt = 0;
		GeneralTree<T> tree_aux = new GeneralTree<T>();
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		 queue.enqueue(tree);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 tree_aux = queue.dequeue();
			 if((tree_aux != null) && (tree_aux.getData() != dato)) {
				 List<GeneralTree<T>> children = tree_aux.getChildren();
				 for (GeneralTree<T> child: children) {
			
					 	queue.enqueue(child);
				 }
			 }else {
				 if(tree_aux == null) {
				 if(!queue.isEmpty()) {
						alt = alt + 1;
						queue.enqueue(null); 
					} 
				 }else {
					 return alt;
				 }
				 
			 }
		}
		return -1;
	}
	
	public int nivel(T dato){
		int niv = 0;
		niv = porNivelesNivel(this,dato);
		return niv;
	  }
	
	public int porNivelesAncho(GeneralTree<T> tree) {
		int ancho = 0;
		int max = 0;
		GeneralTree<T> tree_aux = new GeneralTree<T>();
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		 queue.enqueue(tree);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 tree_aux = queue.dequeue();
			 if(tree_aux != null) {
				 List<GeneralTree<T>> children = tree_aux.getChildren();
				 for (GeneralTree<T> child: children) {
					 	ancho = ancho + 1;
					 	queue.enqueue(child);
				 }
			 }else {
				 if(!queue.isEmpty()) {
					if(ancho > max) {
						max = ancho;
					}
					ancho = 0;
					queue.enqueue(null); 
				 }
			 }
		 }
		 return max;
	}

	public int ancho(){
		if(this.isEmpty()) {
			return 0;
		}else if(this.isLeaf()) {
			return 1;
		}
		int ancho = porNivelesAncho(this);
		return ancho;
	}
	
	public GeneralTree<T> porNivelesAncestro(GeneralTree<T> a, T dato) {
		GeneralTree<T> a_aux = new GeneralTree<T>();
		a_aux = null;//le asigno valor null asi si el arbol anterior fue null, le vuelvo a asignar null al resultado y no un arbol vacio.
		if(a != null) { //agrego esta condicion ya que cuando ingresa un arbol que es null, por algun motivo se me rompe el programa. Asi si funciona y solo agregue esta linea. 
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		 queue.enqueue(a);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 a_aux = queue.dequeue();
			 if(a_aux != null) {
				 if(a_aux.getData() == dato) {
					 return a_aux;
				 }
				 List<GeneralTree<T>> children = a_aux.getChildren();
				 for (GeneralTree<T> child: children) {
					 	queue.enqueue(child);
				 }
			 }else {
				 if(!queue.isEmpty()) {
					queue.enqueue(null); 
				 }
			 }
		 }
		}
		 return a_aux;
	}
	
	public boolean esAncestro(T a, T b) { //punto 5
		boolean res = true;
		GeneralTree<T> arbol;
		arbol = this.porNivelesAncestro(this, a);
		arbol = this.porNivelesAncestro(arbol, b); //podria agregar una condicion para que si ya el primer recorrido fue null, este no lo haga pero tendria que usar un par de ifs y siento que de esta forma queda mas limpio el codigo.
		if(arbol == null) {
			res = false;
		}
		return res;
	}
}