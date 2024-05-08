package Punto9;

import java.util.List;

import Punto1.*;
public class ParcialArboles {
	
	public static int esSeleccion (GeneralTree<Integer> a){
		int min = 999;
		List<GeneralTree<Integer>> children = a.getChildren();
		 for (GeneralTree<Integer> child: children) {
			 if((!child.isEmpty()) && (child.getData() < min)) { //agregue el isEmpty porque si el hijo esta vacio, ya que eso me daba error y esto me daria false si el padre tiene contenido ya que X > vacio. Deberia preguntar si pensarlo de esta forma esta bien. Igualmente supongo que es raro que tengas un arbol con un nodo vacio.
				 min = child.getData();
			 }
		 }
		if(a.getData() == min) {
			return 0;
		}else return 1;
	}
	
	public static int preSeleccion(GeneralTree<Integer> a) {
		int resultado = 0;
		if(a.hasChildren()) {
			resultado = esSeleccion(a);
		}
		 List<GeneralTree<Integer>> children = a.getChildren();
		 for (GeneralTree<Integer> child: children) {
		 resultado = resultado + preSeleccion(child);
		 }
		 return resultado;
	}
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		int res = preSeleccion(arbol);
		System.out.println(res);
		if(res == 0) {
			return true;
		} else return false;
	}
	
	public static void main(String[]args) {
		GeneralTree<Integer> raiz = new GeneralTree<Integer>(12);
		
		GeneralTree<Integer> hijo1 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hijo2 = new GeneralTree<Integer>(25);
		
		GeneralTree<Integer> hijo11 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> hijo12 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hijo21 = new GeneralTree<Integer>(25);
		
		GeneralTree<Integer> hijo111 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> hijo121 = new GeneralTree<Integer>(14);
		GeneralTree<Integer> hijo122 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hijo123 = new GeneralTree<Integer>(33);
		
		GeneralTree<Integer> hijo1111 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> hijo1231 = new GeneralTree<Integer>(35);
		GeneralTree<Integer> hijo1232 = new GeneralTree<Integer>(83);
		GeneralTree<Integer> hijo1233 = new GeneralTree<Integer>(90);
		GeneralTree<Integer> hijo1234 = new GeneralTree<Integer>(33);
		
		
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		hijo2.addChild(hijo21);

		hijo11.addChild(hijo111);
		hijo12.addChild(hijo121);
		hijo12.addChild(hijo122);
		hijo12.addChild(hijo123);
		
		hijo111.addChild(hijo1111);
		hijo123.addChild(hijo1231);
		hijo123.addChild(hijo1232);
		hijo123.addChild(hijo1233);
		hijo123.addChild(hijo1234);
		
		
		System.out.println(esDeSeleccion(raiz)); //prueba1

		
		GeneralTree<Integer> raiz2 = new GeneralTree<Integer>(12);
		GeneralTree<Integer> hij1 = new GeneralTree<Integer>();
		
		raiz2.addChild(hij1);
		
		
		System.out.println(esDeSeleccion(raiz2));//prueba2
		
		GeneralTree<Integer> raiz3 = new GeneralTree<Integer>();
		
		System.out.println(esDeSeleccion(raiz3));//prueba3
		//Funciona, en la clase voy a ver porque seguro hay una mejor forma pero tengo que preguntar si utilizar los metodos que devuelvan int es una buena forma de realizar los ejercicios. A mi me parece una forma muy comoda ya que si tengo una sola vez que no se cumpla la condicion sumo 1 y ya con eso se que hay algun error. Devolviendo True y False esto se me cambiaria por cada llamado al metodo.
	}
}
