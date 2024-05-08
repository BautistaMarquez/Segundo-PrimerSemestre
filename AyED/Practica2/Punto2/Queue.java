package Punto2;
import java.util.*;

public class Queue<T> extends Sequence{
	protected List<T> queue;
	
	 public Queue() {
	        queue = new ArrayList<T>();
	    }

	    public void enqueue(T data) {
	        queue.add(data);
	    }

	    public T dequeue() {
	        return queue.remove(0);
	    }

	    public T head() {
	        return queue.get(0);
	    }

	    @Override
	    public int size() {
	        return queue.size();
	    }

	    @Override
	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }

	    public String toString() {
	        String str = "[ ";
	        for(T d : queue)
	            str += d + ", ";
	        str = str.substring(0, str.length()-2) + " ]";
	        return str;
	    }
}

