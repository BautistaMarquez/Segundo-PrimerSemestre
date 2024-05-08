package Punto5;
import Punto4.Queue;
import Punto4.BinaryTree;

public class ProfundidadDeArbolBinario {
	BinaryTree<Integer> arbol;
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public int sumaElementosProfundidad(int p){
		int suma = 0;
		int i = 0;
		BinaryTree<Integer> ab = null;
   	 	Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
   	 	cola.enqueue(this.arbol);
   	 	cola.enqueue(null);
   	 	while ((!cola.isEmpty()) && (i<=p)) {
   	 		ab = cola.dequeue();
   	 		if (ab != null) {
   	 			if((p == i)) {
   	 				suma = suma + ab.getData(); 
   	 			}
   	 			if (ab.hasLeftChild()) {
   	 				cola.enqueue(ab.getLeftChild());
   	 			}
   	 			if (ab.hasRightChild()) {
   	 				cola.enqueue(ab.getRightChild());
   	 			}
   	 		} else if (!cola.isEmpty()) {
   	 			System.out.println();
   	 			System.out.println(i);
	 			i = i+1;
   	 			cola.enqueue(null);
   	 } 		
   	 }
   	 	return suma;
   }
	

}
