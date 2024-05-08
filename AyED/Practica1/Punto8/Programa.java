/*
a. Implemente en JAVA la clase Queue de acuerdo con la especificación dada en el
diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● Queue() Constructor de la clase
● enqueue(dato: T): Inserta el elemento al final de la cola
● dequeue():T Elimina el elemento del frente de la cola y lo retorna. Si la cola
está vacía se produce un error.
● head(): T Retorna el elemento del frente de la cola. Si la cola está vacía se
produce un error.
● isEmpty(): boolean Retorna verdadero si la cola no tiene elementos y falso en
caso contrario
● size():int Retorna la cantidad de elementos de la cola.
● toString(): String Retorna los elementos de la cola en un String
b. Implemente en JAVA las clase CircularQueue de acuerdo con la especificación dada en
el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento
encolado.
c. Implemente en JAVA la clase DoubleEndedQueue de acuerdo con la especificación
dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
● enqueueFirst():void Permite encolar al inicio. 
*/
package Punto8;


public class Programa {
	public static void main(String[] args) {

        // ------------------ CircularQueue:
        System.out.println("-------- Circular Queue --------");
        CircularQueue<Integer> valores = new CircularQueue<>();
        valores.enqueue(4);
        valores.enqueue(8);
        valores.enqueue(90);
        valores.enqueue(23);
        valores.enqueue(7);
        valores.enqueue(1);
        valores.enqueue(33);
        Integer elem = (Integer) valores.shift();
        System.out.println("Dequeue: " + elem);
        System.out.println("Nueva cola: " + valores.toString());

        System.out.println();

        // ------------------ DoubleEndedQueue:
        System.out.println("-------- Double Ended Queue --------");
        DoubleEndedQueue valoresD = new DoubleEndedQueue<>();

        // agrego adelante:
        valoresD.enqueueFirst(8);
        valoresD.enqueueFirst(4);
        valoresD.enqueueFirst(22);
        valoresD.enqueueFirst(7);

        // agrego atras:
        valoresD.enqueue(30);
        valoresD.enqueue(50);

        System.out.println(valoresD.toString());
    }
}
