
public class ColaConPila<E> implements Queue<E>{
	protected Stack<E> pila;
	
	public ColaConPila() {
		pila= new PilaEnlazada<E>();
	}
	
	public void enqueue( E e){
		pila.push(e);
	}
	
	public E dequeue() throws EmptyQueueException{
		Stack<E> pila1= new PilaEnlazada<E>();
		E front=null;
		if(pila.isEmpty())
			throw new EmptyQueueException("Cola vacía");
		try {
			while(!pila.isEmpty()) {
				pila1.push(pila.pop());
			}
			front= pila1.pop();
			while(!pila1.isEmpty()) {
				pila.push(pila1.pop());
			}
		}
		catch(EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		return front;
	}
	
	public E front() throws EmptyQueueException{
		Stack<E> pila1= new PilaEnlazada<E>();
		E front=null;
		if(pila.isEmpty())
			throw new EmptyQueueException("Cola vacía");
		try {
			while(!pila.isEmpty()) {
				pila1.push(pila.pop());
			}
			front= pila1.top();
			while(!pila1.isEmpty()) {
				pila.push(pila1.pop());
			}
		}
		catch(EmptyStackException e) {
			System.out.println(e);
		}
		return front;
	}
	
	
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	
	public int size() {
		return pila.size();
	}
	
	public Stack<E> pilaEnCola() throws EmptyStackException{
		if(pila.size()==0)
			throw new EmptyStackException("Pila vacía");
		else return pila;
	}
	
	//Fuera del TDA porque se trabaja con los parametros:
	public Queue<Character> unirColas(ColaConPila<Character>cin1, ColaConPila<Character>cin2){
		
		Queue<Character> cout= new ColaConArregloCircular<Character>(size());
		Stack<Character> p1= new PilaEnlazada<Character>();
		
		try {
		if(cin1.size()<= cin2.size()) {
			while(!cin1.isEmpty())
				p1.push(cin1.pilaEnCola().pop());
			while(!cin2.isEmpty())
				p1.push(cin2.pilaEnCola().pop());
		}else {
			while(!cin2.isEmpty())
				p1.push(cin2.pilaEnCola().pop());
			while(!cin1.isEmpty())
				p1.push(cin1.pilaEnCola().pop());
			}
		while(!p1.isEmpty())
			cout.enqueue(p1.pop());
		}catch(EmptyStackException|FullQueueException e) {
			e.printStackTrace();
		}
		return cout;
		
	}

}
