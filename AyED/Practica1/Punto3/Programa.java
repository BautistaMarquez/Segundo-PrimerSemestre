/*
 d. Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los
respectivos métodos setters.

e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y otro en la
línea donde itera sobre los profesores

f. Ejecute la clase Test en modo debug y avance paso a paso visualizando si el
estudiante o el profesor recuperado es lo esperado. 
*/
package Punto3;

public class Programa{
	
	public static void main(String[] args) {
		Estudiante alumno = new Estudiante("Juan","Rodriguez",3,"juan.Rodriguez@gmail.com","112y521");
		Profesor profe = new Profesor("Pepe","Sanchez","Pepe.Sanchez@gmail.com",3,"Informatica");
		Estudiante [] alumnos = new Estudiante[2];
		Profesor [] profesores = new Profesor[3];
		alumnos[0] = alumno;
		alumnos[1] = alumno;
		profesores[0] = profe;
		profesores [1] = profe;
		profesores [2] = profe;
		int i;
		for(i=0;i<2;i++) {
			System.out.println(alumnos[i].tusDatos());
		}
		
		for(i=0;i<3;i++) {
			System.out.println(profesores[i].tusDatos());
		}
		
	}
}