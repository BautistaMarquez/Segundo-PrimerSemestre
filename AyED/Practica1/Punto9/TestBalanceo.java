/*
 9. Considere un string de caracteres S, el cual comprende únicamente los caracteres: (,),[,],{,}.
Decimos que S está balanceado si tiene alguna de las siguientes formas:
S = "" S es el string de longitud cero.
S = "(T)"
S = "[T]"
S = "{T}"
S = "TU"
Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero
"( [ ) ]" no lo está.
a. Indique qué estructura de datos utilizará para resolver este problema y cómo la
utilizará.
b. Implemente una clase llamada tp1.ejercicio9.TestBalanceo, cuyo objetivo es
determinar si un String dado está balanceado. El String a verificar es un parámetro de
entrada (no es un dato predefinido).
*/
package Punto9;

public class TestBalanceo {

	public static boolean estaBalanceado(String S) { // No se como anidar condiciones!!!
		boolean b = true;
		Stack<Character> stack = new Stack<Character>();
		int i;
		for(i=0;i<S.length();i++) {
			Character caracter = S.charAt(i);
			if(caracter == '('){
				stack.push(caracter);
			}else if(stack.isEmpty()) {
				b = false;
				return b;
			}else {
				stack.pop();
			}
		}	
		return b;
	}
	
	public static void main(String[]args) {
		String s = "()";
		System.out.println(estaBalanceado(s));
		
	}
	
}
