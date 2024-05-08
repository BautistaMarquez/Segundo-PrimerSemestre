package Punto8;
import java.util.List;

import Punto1.*;
public class Navidad {
	public GeneralTree<Integer> arbol = new GeneralTree<Integer>();
	
	public Navidad(GeneralTree<Integer> a) {
		this.arbol = a;
	}
	
	public boolean esAbeto() {
		boolean res = true;
		int cant = 0;
		GeneralTree<Integer> tree_aux = new GeneralTree<Integer>();
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		 queue.enqueue(this.arbol);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 tree_aux = queue.dequeue();
			 if(tree_aux != null) {
				 cant = cant + 1;
				 List<GeneralTree<Integer>> children = tree_aux.getChildren();
				 for (GeneralTree<Integer> child: children) {
					 	queue.enqueue(child);
				 }
			 }else {
				 System.out.println(cant);
				 if(cant % 3 != 0) {
					 return false;
				 }
				 if((!queue.isEmpty())) {
					 queue.enqueue(null); 
					 cant = 0; 
				 }
			 }
			 
		 }
		 return res;
	}
	
}
