package Punto7;

import java.util.List;

import java.util.ArrayList;


import java.util.Iterator;

public class EjercicioSucesion {
	public static List<Integer> calcularSucesion (int n) {
			List<Integer> l = new ArrayList();
			if(n != 1) {
				if(n % 2 != 0){
					n = (n * n)+1;
				}else {
					n = n/2;
				}
				l=calcularSucesion(n);
				l.add(n);
			}
			System.out.println("a");
			return l;
		}
	public static void main(String[] args) {
		List<Integer> l2 = new ArrayList();
		l2.addAll(calcularSucesion(4));
		
		Iterator it = l2.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
			}
		
		
	}
}
