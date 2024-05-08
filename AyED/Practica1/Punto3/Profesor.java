/*
 Cree una clase llamada Profesor con los atributos especificados abajo y sus
correspondientes métodos getters y setters (haga uso de las facilidades que brinda
eclipse)
● nombre
● apellido
● email
● catedra
● facultad
 
Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la
clase Profesor, que retorne un String con los datos de los atributos de las mismas.
Para acceder a los valores de los atributos utilice los getters previamente
definidos.

*/
package Punto3;

public class Profesor {
	private String nombre;
	private String apellido;
	private String email;
	private int catedra;
	private String facultad;
	
	public Profesor(String n, String a, String e, int c, String f) {
		this.nombre = n;
		this.apellido = a;
		this.email = e;
		this.catedra = c;
		this.facultad = f;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCatedra() {
		return catedra;
	}

	public void setCatedra(int catedra) {
		this.catedra = catedra;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String retorno ="Nombre "+this.getNombre()+" Apellido "+this.getApellido()+" Facultad "+this.getFacultad()+" Email "+this.getEmail()+" Catedra "+this.getCatedra();
		return retorno;
	}
	
}
