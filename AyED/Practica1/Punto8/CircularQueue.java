package Punto8;

public class CircularQueue<T> extends Queue{
	
	 public CircularQueue() {
	        super();
	    }

	    public T shift() {
	        if(! queue.isEmpty()) {
	            T elem = (T) queue.remove(queue.size() -1);
	            queue.add(0, elem);
	            return elem;
	        }
	        return null;
	    }
}
