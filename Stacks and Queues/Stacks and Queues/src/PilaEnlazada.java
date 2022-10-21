
public class PilaEnlazada<E> implements Stack<E> {
	//Tributes
	protected Nodo<E> head;
	protected int tamaño;
	
	
	public class Nodo<E>{
		private E elemento;
		private Nodo<E> siguiente;
		
		public Nodo(E item, Nodo<E> sig) {
			elemento= item;
			siguiente= sig;
		}
		public Nodo(E item) {
			this(item, null);
		}
		
		public void setElemento(E elemento) {
			this.elemento= elemento;
		}
		public void setSiguiente(Nodo<E> sig) {
			siguiente= sig;
		}
		
		public E getElemento() {
			return elemento;
		}
		public Nodo<E> getSiguiente(){
			return siguiente;
		}
	}
	
	//Constructor
	public PilaEnlazada() {
		head= null;
		tamaño= 0;
	}
	
	//Interface Methods
	public int size() {
		return tamaño;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public E top()throws EmptyStackException{
		if(tamaño==0)
			throw new EmptyStackException("Pila vacía");
		else {
			return head.getElemento();
		}
	}
	public void push(E element) {
		Nodo<E> aux= new Nodo<E>(element);
		aux.setElemento(element);
		aux.setSiguiente(head);
		head= aux;
		tamaño++;
	}
	public E pop() throws EmptyStackException{
		E aux;
		if(isEmpty())
			throw new EmptyStackException("Pila vacía");
		else {
			aux= head.getElemento();
			head= head.getSiguiente();
			tamaño--;
			return aux;
		}
	}
	
}

