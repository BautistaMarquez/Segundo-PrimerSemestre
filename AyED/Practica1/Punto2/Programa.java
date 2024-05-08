package Punto2;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Calcular c = new Calcular();
		Scanner s = new Scanner(System.in) ;
		c.devolver(s.nextInt());
	}
}
