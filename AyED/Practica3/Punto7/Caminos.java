package Punto7;
import java.util.LinkedList;
import java.util.List;

import Punto1.*;
//Primero tengo que saber cual es el nivel maximo del arbol. Lo puedo hacer con el metodo altura que traen por default los arboles.NO, no lo puedo hacer yaque este metodo recorre el arbol.
//Luego recorrerlo contado el nivel en el que estoy y guardando en la lista el primer recorrido que llegue a ese nivel maximo. Al final no lo hice de esta forma ya que para saber el nivel MAX se tiene que recorrer el arbol,igual la idea no estaba mal pero no habia pensado que recorria mas de una vez el arbol.
public class Caminos {
	public GeneralTree<Integer> estructura = new GeneralTree<Integer>();
	
	public Caminos(GeneralTree<Integer> e) {
		this.estructura = e;
	}
	//No se puede usar el estructura.altura entonces tendria que usar dos listas y despues comparar el largo de la lista.
	//Hay lo hice sin usar la altura, comparando el largo de las listas.
	public void postCamino(GeneralTree<Integer> e,List<Integer> c, List<Integer> r) {
		if(!e.hasChildren()){
			if(c.size()>r.size()) { //Si el camino es mas largo que la lista resultado.
				r.removeAll(r); //elimino lo que tenia la lista.
				r.addAll(c); //cargo la nueva lista. 
			}
		}
		List<GeneralTree<Integer>> children = e.getChildren();
		for (GeneralTree<Integer> child: children) {
			c.add(child.getData());
			postCamino(child,c,r);
			c.remove(c.size()-1);
		}
	}
	//De esta forma recorro todo el arbol, pero eso no es un problema. Esta bien que recorra todo el arbol.
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino = new LinkedList<Integer>();
		camino.add(this.estructura.getData());
		List<Integer> Resultado = new LinkedList<Integer>();
		postCamino(this.estructura,camino,Resultado);
		return Resultado;
	}
}
