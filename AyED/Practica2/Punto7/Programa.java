package Punto7;

import Punto4.BinaryTree;

/*
 Los siguientes ejercicios fueron tomados en parciales, en los últimos años. Tenga en cuenta que:
1. No puede agregar más variables de instancia ni de clase a la clase ParcialArboles.
2. Debe respetar la clase y la firma del método indicado.
3. Puede definir todos los métodos y variables locales que considere necesarios.
4. Todo método que no esté definido en la sinopsis de clases debe ser implementado.
5. Debe recorrer la estructura solo 1 vez para resolverlo.
6. Si corresponde, complete en la firma del método el tipo de datos indicado con signo de “?”.

Ejercicio 7
Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
public boolean isLeftTree (int num)
El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
contrario. Consideraciones:
● Si “num” no se encuentra en el árbol, devuelve false.
● Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay
-1 árboles con único hijo.

*/
public class Programa {
	public static void main(String []args) {
		BinaryTree<Integer> arbol = new BinaryTree(1);
		BinaryTree<Integer> arbol2 = new BinaryTree(2);
		BinaryTree<Integer> arbol3 = new BinaryTree(3);
		BinaryTree<Integer> arbol4 = new BinaryTree(4);
		BinaryTree<Integer> arbol5 = new BinaryTree(5);
		BinaryTree<Integer> arbol6 = new BinaryTree(6);
		BinaryTree<Integer> arbol7 = new BinaryTree(7);
		BinaryTree<Integer> arbol8 = new BinaryTree(8);
		arbol.addLeftChild(arbol2);
		arbol.addRightChild(arbol3);
		arbol2.addLeftChild(arbol4);
		arbol3.addLeftChild(arbol5);
		arbol3.addRightChild(arbol6);
		arbol5.addLeftChild(arbol7);

		
		ParcialArboles prueba = new ParcialArboles();
		
		prueba.setArbol(arbol);
		
		boolean resultado;
		resultado = prueba.isLeftTree(5);
		System.out.print("Este es el resultado de la var cuando sale, no puedo hacer que sea TRUE => ");
		System.out.print(resultado);
		System.out.print(" ---Ya esta solucionado, ahora si funciona !!!--- ");
		//No se como retornar el valor para que me quede la var en true, pero el algoritmo funciona !!!
		//No se como pasar los valores en los metodos ya que se me desactualizan, necesitaria saber como mantener el valor.
		//Lo hice, manejandome con metodos que devulevan INT porque si queria devolver BOOLEAN se me rompia todo
		// FUNCIONA !!!
	}
}
