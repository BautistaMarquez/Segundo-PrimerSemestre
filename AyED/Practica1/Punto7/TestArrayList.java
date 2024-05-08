package Punto7;

import java.util.List;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Iterator;

public class TestArrayList {
	
	public static ArrayList<Estudiante> crear(){ //d1
		ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
		Estudiante e = new Estudiante("Juan","Rodriguez",2,"gmail","110y320");
		Estudiante e2 = new Estudiante("Juani","Rodriguez",2,"gmail","110y320");
		Estudiante e3 = new Estudiante("Juan","castro",2,"gmail","110y320");
		lista.add(e);
		lista.add(e2);
		lista.add(e3);
		return lista;
	}
	public static boolean capicua(List<Integer> a) {
		boolean b = false;
		int capi=0;
		int cua=0;
		
		Iterator ite = a.iterator();
		
		int i = 0;
		
		while(ite.hasNext()) { //iiv capaz es medio cavernicola 
			if(i==0) {
				capi = a.get(i);
			}else {
				cua = a.get(i);
			}
			ite.next();
			i = i+1;
		}
		if(capi == cua) {
			b = true;
		}
		return b;
	}
	
		
	public static void invertirArrayList(ArrayList<Integer> lista) { //h
		int fin = lista.size();
		int i=0;
		for(i=0;i<fin;i++) {
			int pos = fin-i;
			pos = pos-1;
			Integer valor2=lista.get(pos);
			Integer valor1=lista.get(i);
			lista.set(pos, valor1);
			lista.set(i, valor2); 
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		List<Integer> lista2 = new LinkedList<Integer>();
		List<Estudiante> lista3 = new ArrayList<Estudiante>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		
		lista2.add(5);
		lista2.add(2);
		lista2.add(1);
		lista2.add(0);
		lista2.add(9);
		
		
		Iterator it = lista.iterator();
		

		for (Integer i:lista2) { /*  Punto C  */
				System.out.println(i);
		}
		
		
		lista3.addAll(crear()); //ii copio la lista que crea el metodo.
		
		lista3.get(2).setNombre("Albert");//iv modifico un apellido. En realidad lo que me pide seria modificar un valor de la primera lista y obviamente eso me modificaria la segunda ya que esta es una copia de la primera.
		

	
		
		Iterator ite = lista3.iterator();
		int i = 0;
		
		while(ite.hasNext()) { //iiv capaz es medio cavernicola 
			System.out.println(lista3.get(i).tusDatos());
			ite.next();
			i = i+1;
		}
		//v formas de copiar una lista: con el addAll o copiando campo a campo.
		
		
		//punto e: => para esto voy a modificar el equals.(No puedo modificar el equals, preguntar)
	
		//punto f
		
		System.out.println(capicua(lista)); //Funciona. Podria ser mejor y usar una sola variable? Seguro.
		
		
		
		//Punto h
		invertirArrayList(lista);
		
		while (it.hasNext()) {
			System.out.println(it.next());
			}
		
	}
}
