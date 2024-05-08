package Punto8;

public class DoubleEndedQueue<T> extends Queue{

    public DoubleEndedQueue() {
        super();
    }

    public void enqueueFirst(T data) {
        queue.add(0, data);
    }
}
