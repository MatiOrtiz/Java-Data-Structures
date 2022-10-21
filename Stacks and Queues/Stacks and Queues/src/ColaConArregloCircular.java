
public class ColaConArregloCircular<E> implements Queue<E> {
	//Tributes
	private int r, f, cont;
	private E[] arreglo;
	//Constructor
	public ColaConArregloCircular(int max) {
		E[] arreglo= (E[]) new Object[max];
		f=0;
		r=0;
		cont=0;
	}
	
	//Interface Methods
	public int size() {
		return ((cont-f+r) % cont);
	}
	public boolean isEmpty() {
		return f==r;
	}
	public E front() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException("Cola vacía");
		else {
			return arreglo[f];
		}
	}
	public void enqueue(E element) throws FullQueueException {
		if(size()==cont-1)
			throw new FullQueueException("Cola llena");
		else {
			arreglo[r]= element;
			r= (r+1) % cont;
		}
			
	}
	public E dequeue() throws EmptyQueueException{
		E aux;
		if(isEmpty())
			throw new EmptyQueueException("Pila vacía");
		else {
			aux= arreglo[f];
			arreglo[f]= null;
			f= (f+1) % cont;
			return aux;
		}
	}
}


