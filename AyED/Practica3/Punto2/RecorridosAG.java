package Punto2;

import Punto1.GeneralTree;


import java.util.LinkedList;
import java.util.List;
import Punto1.GeneralTree;
import Punto1.Queue;


public class RecorridosAG {
	
	public void preOrder(GeneralTree <Integer> a,Integer n, List<Integer> r) {
		 if(a.getData()>n) {
			 if(a.getData() % 2 != 0) {
				 r.add(a.getData());
			 }
		 }
		 List<GeneralTree<Integer>> children = a.getChildren();
		 for (GeneralTree<Integer> child: children) {
		 	this.preOrder(child, n, r);
		 }
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){ //funciona
		List<Integer> retorno = new LinkedList<Integer>();
		this.preOrder(a, n, retorno);
		
		return retorno;
	}
	
	public void InOrder(GeneralTree <Integer> a,Integer n, List<Integer> r) {
		if(a.hasChildren()) {
			this.InOrder(a.getChildren().get(0), n, r);
		}
		 if(a.getData()>n) {
			 if(a.getData() % 2 != 0) {
				 r.add(a.getData());
			 }
		 }
		 List<GeneralTree<Integer>> children = a.getChildren();
		 int i = 0;
		 for (GeneralTree<Integer> child: children) {
			 if(i !=0) {
				 this.preOrder(child, n, r);
			 }
			 i = i+1;
		 	
		 }
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> retorno = new LinkedList<Integer>();
		this.InOrder(a, n, retorno);
		
		return retorno;
	}
	
	public void postOrder(GeneralTree <Integer> a,Integer n, List<Integer> r) {
		 List<GeneralTree<Integer>> children = a.getChildren();
		 for (GeneralTree<Integer> child: children) {
		 	this.postOrder(child, n, r);
		 }
		 if(a.getData()>n) {
			 if(a.getData() % 2 != 0) {
				 r.add(a.getData());
			 }
		 }
	}
	
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a,Integer n){
		List<Integer> retorno = new LinkedList<Integer>();
		this.postOrder(a, n, retorno);
		
		return retorno;
	}
	
	public List<Integer> traversalLevel(GeneralTree<Integer> tree, Integer n) {

		List<Integer> result = new LinkedList<Integer>();
		GeneralTree<Integer> tree_aux = new GeneralTree<Integer>();
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		 queue.enqueue(tree);
		 while (!queue.isEmpty()) {
		 tree_aux = queue.dequeue();
		 if(tree_aux.getData()>n) {
			 if(tree_aux.getData() % 2 != 0) {
				 result.add(tree_aux.getData());
			 }
		 }
		 List<GeneralTree<Integer>> children = tree_aux.getChildren();
		 for (GeneralTree<Integer> child: children) {
		 queue.enqueue(child);
		 }
		 }
		 return result;
		 }
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> retorno = new LinkedList<Integer>();
		retorno = this.traversalLevel(a, n);
		
		return retorno;
	}


}
