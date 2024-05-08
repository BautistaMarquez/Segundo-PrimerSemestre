package Punto2;

public class Calcular {
	public static void devolver (int n) {
		int j,valor;
		for(j=1;j<=n;j++) {
			valor = n;
			valor = valor * j;
			System.out.println(valor);
			System.out.println("-");
		}
	}
}
