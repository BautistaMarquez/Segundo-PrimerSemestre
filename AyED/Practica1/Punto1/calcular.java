package Punto1;

public class calcular {
	
	public static void calculoA (int inicio, int fin) {
		int i;
		for(i=inicio;i<=fin;i++) {
			System.out.println(i);
		}
	}
	
	public static void calculoB (int inicio, int fin) {
		int i = inicio;
		while(i <= fin){
			System.out.println(i);
			i = i + 1;
		}
	}
	
	public static void calculoC (int inicio, int fin) {
		int i = inicio;
		int f = fin;
		if (i<f) {
			System.out.println(i);
			i = i++;
			calculoC(i,f);
		}
	}
	
}
