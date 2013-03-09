
/**
 * Clase que implementa la interfaz Lista
 * 
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 * 
 * Proyecto 4
 * Prof Lab: Juan Arocha 
 *
 * @param <E> Tipo de elemento a guardar en la lista
 */
public class MiLista<E> implements Lista<E> {

	/**
	 * Modelo de representacion: lista doblemente enlazada
	 * con un centinela.
	 * La primera "caja" esta vacia.
	 */
	private int tam = 0;
	private Caja<E> centinela = null;

	/**
	 * Constructor
	 */
	public MiLista() {
		this.tam = 0;
		this.centinela = new Caja<E>(null);
		this.centinela.cambiarAnterior(this.centinela);
		this.centinela.cambiarSiguiente(this.centinela);

	}

	/**
	 * Agrega un elemento a la lista.
	 */
	@Override
	public boolean add(E element) {


		if (element == null) {
			return false;
		}
		if (this.tam == 0) {
			this.centinela.cambiarAnterior(element);
			this.centinela.cambiarSiguiente(this.centinela.cajaAnt());
		} else {
			Caja<E> ult = this.centinela.cajaAnt();
			ult.cambiarSiguiente(element);
			ult.cajaSig().cambiarSiguiente(this.centinela);
		}
		this.tam++;
		return true;
	}

	/**
	 * Elimina todos los elementos de la lista. La lista queda
	 * como recien creada.
	 */
	@Override
	public void clear() {
		this.tam = 0;
		this.centinela = new Caja<E>(null);
		this.centinela.cambiarAnterior(this.centinela);
		this.centinela.cambiarSiguiente(this.centinela);
	}

	/**
	 * Determina si el elemento dado esta en la lista.
	 */
	@Override
	public boolean contains(Object element) {
		if (element == null) {
			return false;
		}
		Caja<E> aux = this.centinela.cajaSig();
		int i = 0;
		while (i != this.tam) {
			if (aux.elemento().equals(element)) {
				return true;
			}
			i++;
			aux = aux.cajaSig();
		}
		return false;
	}

	/**
	 *Retorna la primera "caja" de la lista
	 * @return primera caja
	 **/
	private Caja<E> getCaja() {
		if (this == null) {
			return null;
		}
		return this.centinela.cajaSig();
	}

	/**
	 * Determina si la lista dada es igual a la lista.
	 */
	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public boolean equals(Lista<E> lista) {
		boolean sent = false;

		if (this == null || lista == null) {
			return false;
		}

		if (this.tam == 0 && lista.getSize() == 0) {
			return true;
		}

		if (this.tam == lista.getSize()) {

			Caja<E> aux1 = this.centinela.cajaSig();
			Caja<E> aux2 = ((MiLista) lista).getCaja();
			//    		sent = aux1.verContenido()==aux2.verContenido();
			int i = 0;
			sent = true;
			while (i != this.tam && i != lista.getSize() && sent) {
				sent = aux1.elemento().equals(aux2.elemento());
				aux1 = aux1.cajaSig();
				aux2 = aux2.cajaSig();
				i++;
			}
		}
		return sent;
	}

	/**
	 *  Retorna el primer de la lista.
	 */
	@Override
	public E get() {
		if (this == null) {
			return null;
		}
		return this.centinela.cajaSig().elemento();
	}


	/**
	 *@return el ultimo elemento de la lista 
	 */
	@Override
	public E getLast(){
		if (this == null) {
			return null;
		}
		return this.centinela.cajaAnt().elemento();
	}

	/**
	 * Determina si la lista es vacia.
	 */
	@Override
	public boolean isEmpty() {
		return this == null || this.getSize() == 0;
	}

	/**
	 * Elimina el elemento dado de la lista. Si la lista cambia,
	 * retorna true, sino retorna false.
	 */
	@Override
	public boolean remove(E element) {

		if (element == null || this.isEmpty()) {
			return false;
		}
		int i = 0;
		Caja<E> aux1 = this.getCaja();
		boolean sent = aux1.elemento().equals(element);

		while (i != this.tam && !sent && aux1.cajaSig().elemento() != null) {
			sent = aux1.cajaSig().elemento().equals(element);
			i++;
			aux1 = aux1.cajaSig();
		}
		if (sent) {
			aux1.cajaAnt().cambiarSiguiente(aux1.cajaSig());
			this.tam--;
		}

		return sent;
	}

	/**
	 * Retorna el numero de elementos en la lista
	 */
	@Override
	public int getSize() {
		if (this == null) {
			return 0;
		}
		return this.tam;
	}

	/**
	 * Retorna un arreglo que contiene todos los elementos
	 * en esta lista.
	 */
	@Override
	public Object[] toArray() {
		if (this == null) {
			return new Object[0];
		}
		if (this.tam == 0) {
			return new Object[this.tam];
		}

		Object[] Alista = new Object[this.tam];
		int i = 0;
		Caja<E> e = this.getCaja();
		while (i != this.tam) {
			Alista[i] = e.elemento();
			i++;
			e = e.cajaSig();
		}
		return Alista;
	}

	/**
	 * Devuelve un iterador sobre la lista.
	 * @return Iterador para la lista
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public ListIterator<E> iterator() {
		return new LisIter(this);
	}
	/**
	 * Clase privada para el uso de la lista
	 * Implementa una cada con un apuntador
	 * una siguiente caja, y a una anterior.
	 * la caja guarda un elemento de tipo E     *
	 * @param <E> Tipo de elemnto de la caja
	 */
	@SuppressWarnings("hiding")
	private final class Caja<E> {

		private Caja<E> siguiente = null;
		private Caja<E> anterior = null;
		private E elemento = null;

		/**
		 * Constructor, crea una caja que contiene al elemento e
		 * @param e Elemento a guardar en la caja
		 */
		public Caja(E e) {
			this.elemento = e;
			this.siguiente = null;
			this.anterior = null;
		}

		/**
		 * Cambia el elemento de la caja siguiente por e
		 * @param e Elemento a cambiar en la caja siguiente
		 * @return true si cambio, false si no
		 */
		public boolean cambiarSiguiente(E e) {
			Caja<E> sig = new Caja<E>(e);
			if (this != null) {
				this.siguiente = sig;
				sig.anterior = this;
				return true;
			}
			return false;
		}

		/**
		 * Retorna la siguiente caja a donde apunta
		 * @return La caja siguiente
		 */
		public Caja<E> cajaSig() {
			return this.siguiente;
		}

		/**
		 * retorna la caja anterior a donde apunta
		 * @return La caja Anterior
		 */
		public Caja<E> cajaAnt() {
			return this.anterior;
		}

		/**
		 * hace que la caja e sea el nuevo siguiente de la caja acual
		 * @param e Caja que sera la siguiente
		 * @return true si cambio la siguiente, false en caso contrario
		 */
		public boolean cambiarSiguiente(Caja<E> e) {
			if (this != null) {
				this.siguiente = e;
				e.anterior = this;
				return true;
			}
			return false;
		}

		/**
		 * cambia el elemento de la caja anterior por e
		 * @param e Elemento a cambiar
		 * @return true si cambio el anterior, false en caso contrario
		 */
		public boolean cambiarAnterior(E e) {
			Caja<E> ant = new Caja<E>(e);
			if (this != null) {
				this.anterior = ant;
				ant.siguiente = this;
				return true;
			}
			return false;
		}

		/**
		 * hace que la caja e sea el nuevo anterior de la caja actual
		 * @param e Caja qu sera la anterior
		 * @return true si cambio la caja anterior, false en caso contrario
		 */
		public boolean cambiarAnterior(Caja<E> e) {
			if (this != null) {
				this.anterior = e;
				e.siguiente = this;
				return true;
			}
			return false;
		}

		/**
		 * retorna el elemento de la caja
		 * @return El elemento guardado en la caja
		 */
		public E elemento() {
			return this.elemento;
		}

		/**
		 * retorna el elemento de la caja siguiente
		 * @return Elemento de la caja siguiente
		 */
		public E siguiente() {
			return this.siguiente.elemento;
		}

		/**
		 * retorna el elemento de la caja anterior
		 * @return Elemento de la caja anterior
		 */
		public E anterior() {
			return this.anterior.elemento;
		}

		/**
		 * muestra una reperensation en String del contenido de la caja
		 */
		@Override
		public String toString() {
			return this.elemento.toString();
		}
	}

	/**
	 * clase privada para el uso de la lista
	 * implementacion de un iterador para la lista
	 * @param <E> Tipo que retorna el iterador
	 */
	@SuppressWarnings("hiding")
	private final class LisIter<E> implements ListIterator<E> {

		private MiLista<E> ListaAux = null;
		private Caja<E> Actual = null;
		private int cont;

		/**
		 * constructor, crea un iterador para la lista lis
		 * @param Lis lista que usara el iterador
		 */
		@SuppressWarnings("unchecked")
		private LisIter(MiLista<E> Lis) {
			this.ListaAux = Lis;
			this.Actual = ((Caja<E>) Lis.getCaja());
			this.cont = 0;
		}

		/**
		 * Comprueba que exista un proximo elemento.
		 */
		@Override
		public boolean hasNext() {
			return (this.Actual.siguiente() != null);
		}

		/**
		 * Comprueba que exista un proximo elemento.
		 */
		@Override
		public boolean hasPrev() {
			return (this.Actual.anterior() != null);
		}

		/**
		 * Devuelve el elemento asociado y avanza el iterador.
		 */
		@Override
		public E next() {
			E Temp;

			Temp = this.Actual.elemento();
			this.Actual = this.Actual.cajaSig();
			this.cont++;
			return Temp;
		}

		/**
		 * Devuelve el elemento asociado y retrocede el iterador.
		 */
		@Override
		public E prev() {
			E Temp;

			Temp = this.Actual.elemento();
			this.Actual = this.Actual.cajaAnt();
			this.cont--;
			return Temp;
		}

		/**
		 * Remueve de la lista el ultimo elemento retornado
		 */
		@Override
		public void unlink() {
			E Temp;
			Temp = this.Actual.anterior();
			this.ListaAux.remove(Temp);
		}
	}//Fin LisIter
}

// End List.