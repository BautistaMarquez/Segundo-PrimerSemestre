package Punto9;

public class vector {
	Integer[] contenido = new Integer [1];

	public Integer[] getContenido() {
		return contenido;
	}

	public void setContenido(Integer[] contenido) {
		this.contenido = contenido;
	}
	
	public Integer getContenidoParcial(int num) {
		return contenido[num];
	}

	public void setContenidoParcial(int num,Integer contenido) {
		this.contenido[num] = contenido;
	}
	
}
