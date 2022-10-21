
public class PilaArreglo<E> implements Stack<E> {
	//Tributes
	protected E[] elements;
	protected int sizearr;
	
	//Constructor
	public PilaArreglo(int max){
		elements= (E[]) new Object [max];
		sizearr= 0;
	}
	
	//Methods 
	public int size() {
		return sizearr;
	}
	public boolean isEmpty() {
		return sizearr==0;
	}
	public E top() throws EmptyStackException{
		if(sizearr==0)
			throw new EmptyStackException("Pila vacía");
		else {
			return elements[sizearr-1];
		}
	}
	public void push(E element) {
		elements[sizearr]= element;
		sizearr++;
	}
	public E pop() throws EmptyStackException{
		E aux;
		if(sizearr==0)
			throw new EmptyStackException("Pila vacía");
			else {
				aux= elements[sizearr-1];
				elements[sizearr-1]= null;
				sizearr= sizearr-1;
				return aux;
			}
	}
	
	//Methods
	
	//Fuera del TDA--> se trabaja con el que se recibe por paramétro
	public void invertir(PilaArreglo<E> p){
			Stack<E> aux1= new PilaArreglo<E>(size());
			Stack<E> aux2= new PilaArreglo<E>(size());
			
			try {
				while(!p.isEmpty())
					aux1.push(p.pop());
				while(!aux1.isEmpty())
					aux2.push(aux1.pop());
				while(!aux2.isEmpty())
					p.push(aux2.pop());
				} catch(EmptyStackException e){
					e.printStackTrace();
				}
			}
			
	//Dentro del TDA --> Se trabaja con el que recibe el mensaje.
	public void invertir() {
			E[] aux= (E[]) new Object[elements.length];
			int j=0; 
			int i;
				
			for(i=sizearr-1; i>=0; i--) {
				aux[j]= elements[i];
				j++;
				}
			elements= aux;
			}
	
	public void invertirPersonas(PilaArreglo<Persona> p) {
			p.invertir();
			}
	
	/*public Stack<Integer> pilaEnteros(PilaArreglo<Integer> p){
		
	}*/
}


