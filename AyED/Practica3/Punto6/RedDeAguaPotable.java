package Punto6;

import java.util.List;

import Punto1.*;

public class RedDeAguaPotable {
	public GeneralTree<Character> estructura = new GeneralTree<Character>();
	
	public RedDeAguaPotable(GeneralTree<Character> e) {
		this.estructura = e;
	}
	
	
	
	/*public int porNivelesNivel(GeneralTree<Character> tree,double dato) {
		int cant = 0;
		double res = 0;
		double min = 9999;
		GeneralTree<Character> tree_aux = new GeneralTree<Character>();
		Queue<GeneralTree<Character>> queue = new Queue<GeneralTree<Character>>();
		 queue.enqueue(tree);
		 queue.enqueue(null);
		 while (!queue.isEmpty()) {
			 tree_aux = queue.dequeue();
			 cant = cant + 1;
			 if(tree_aux != null){
				 List<GeneralTree<Character>> children = tree_aux.getChildren();
				 
				 for (GeneralTree<Character> child: children) {
					 queue.enqueue(child);
				 }
			 }else {
				 if(!queue.isEmpty()) {
						queue.enqueue(null); 
					}  
			 }
		}
		return min; este creo que no va
	}*/
	
	public double postCaudal(GeneralTree<Character> a, double caudal,double min) { //agregue la variable min que es pasada como parametro,de esta forma al hacer min = postCaudal(child,caudal,min); me devuelve bien el valor. 
		if(!a.hasChildren()){
			if(caudal<min){
				min = caudal;
			}
		}
		 List<GeneralTree<Character>> children = a.getChildren();
		 int cant = children.size();
		 if(cant > 0) {
			 System.out.println(caudal);
			 System.out.println(children.size());
			 caudal = caudal / cant;
			 System.out.println(caudal);
		 }
		 for (GeneralTree<Character> child: children) {
			  min = postCaudal(child,caudal,min);
		 }
		 return min;
	}
	//MATH.MIN(hijo1,hijo2) se podria usar, saca el minimo de los hijos. Esta bueno, tambien se podria usar un MATH.MAX.
	public double minimoCaudal(double caudal) {
		double min = caudal;
		if(estructura.isEmpty()) {
			return 0;
		}else if(estructura.isLeaf()) {
			return caudal;
		}
		return postCaudal(estructura,caudal,min);
	}
}
