package Punto3;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}
	
	public void preOrden() {
		System.out.println(this.getData());
		if(this.hasLeftChild()) {
			this.getLeftChild().preOrden();
		}
		if(this.hasRightChild()) {
			this.getRightChild().preOrden();
		}
	}
	
	public void postOrden() {
		if(this.hasLeftChild()) {
			this.getLeftChild().preOrden();
		}
		if(this.hasRightChild()) {
			this.getRightChild().preOrden();
		}
		System.out.println(this.getData());
	}
	
	
	public int contarHojas() {
	      int leftC =0; 
	      int rightC = 0;
	      if (this.isEmpty()) return 0;
	      else if(this.isLeaf()) return 1;
	      else {
	          if(this.hasLeftChild()) 
	              leftC = this.getLeftChild().contarHojas();
	          if(this.hasRightChild()) 
	              rightC = this.getRightChild().contarHojas();
	          return leftC + rightC;
	      }
	}	
	
	public void recorridoCopia(BinaryTree<T> copiar) {
		if(this.isEmpty()) {
    		copiar = null;
    	}else copiar.setData(this.getData());
    	if(this.hasLeftChild()) {
    		copiar.addRightChild(new BinaryTree<T>());
    		this.getLeftChild().recorridoCopia(copiar.getRightChild());
    	}
    	if(this.hasRightChild()) {
    		copiar.addLeftChild(new BinaryTree<T>());
    		this.getRightChild().recorridoCopia(copiar.getLeftChild());
    	}
	}
				 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> copia = new BinaryTree<T>();
    	this.recorridoCopia(copia);
 	    return copia;
    }
    

		
}

