package Punto6;

import Punto1.GeneralTree;

public class Programa {
	public static void main(String[]args) {
		GeneralTree<Character> raiz = new GeneralTree<Character>('A');
		GeneralTree<Character> hijo1 = new GeneralTree<Character>('B');
		GeneralTree<Character> hijo2 = new GeneralTree<Character>('C');
		GeneralTree<Character> hijo3 = new GeneralTree<Character>('D');
		GeneralTree<Character> hijo4 = new GeneralTree<Character>('E');
		GeneralTree<Character> hijo20 = new GeneralTree<Character>('F');
		GeneralTree<Character> hijo21 = new GeneralTree<Character>('G');
		GeneralTree<Character> hijo30 = new GeneralTree<Character>('H');
		GeneralTree<Character> hijo31 = new GeneralTree<Character>('I');
		GeneralTree<Character> hijo32 = new GeneralTree<Character>('J');
		GeneralTree<Character> hijo33 = new GeneralTree<Character>('K');
		GeneralTree<Character> hijo34 = new GeneralTree<Character>('P');
		GeneralTree<Character> hijo210 = new GeneralTree<Character>('L');
		GeneralTree<Character> hijo320 = new GeneralTree<Character>('M');
		GeneralTree<Character> hijo321 = new GeneralTree<Character>('N');
		
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		raiz.addChild(hijo3);
		raiz.addChild(hijo4);
		
		hijo2.addChild(hijo20);
		hijo2.addChild(hijo21);
		
		hijo3.addChild(hijo30);
		hijo3.addChild(hijo31);
		hijo3.addChild(hijo32);
		hijo3.addChild(hijo33);
		hijo3.addChild(hijo34);
		
		hijo21.addChild(hijo210);
		
		hijo32.addChild(hijo320);
		hijo32.addChild(hijo321);
		
		RedDeAguaPotable prueba = new RedDeAguaPotable(raiz);
		
		double resultado = prueba.minimoCaudal(1000);
		
		System.out.println("El resultado es: ");
		System.out.print(resultado);
		//O me devuelve el resultado mal, ya que al usar la var se va como actualizando el valor y me termina dando un valor mas chico
		//O hago el recorrido bien, pero no puedo devolver el valor minimo si no lo guardo en una lista.
		//Tiene que haber una forma de yo haciendo el recorrido bien devuelva el ULTIMO valor. 
		
		//SOLUCIONADO EN CLASE. Me faltaba pasar la var min como parametro.
		
		//Funciona.
		
	}
}
