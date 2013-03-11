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
    /**
     * Caja centinela vacia
     */
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
     *@return el ultimo elemento de la lista
     */
    @Override
    public E getLast() {
        if (this == null) {
            return null;
        }
        return this.centinela.cajaAnt().elemento();
    }

    /**
     * Determina si la lista es vacia.
     */
    @Override
    public boolean isEmpty(){
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

        /**
         * apuntador a una caja siguiente
         */
        private Caja<E> siguiente = null;
        /**
         * apuntador a una caja anterior
         */
        private Caja<E> anterior = null;
        /**
         * elemento que guarda la caja
         */
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
    }

    /**
     * clase privada para el uso de la lista
     * implementacion de un iterador para la lista
     * @param <E> Tipo que retorna el iterador
     */
    @SuppressWarnings("hiding")
    private final class LisIter<E> implements ListIterator<E> {

        /**
         * Caja acual del iterador
         */
        private Caja<E> Actual = null;

        /**
         * constructor, crea un iterador para la lista lis
         * @param Lis lista que usara el iterador
         */
        @SuppressWarnings("unchecked")
        private LisIter(MiLista<E> Lis) {
            this.Actual = ((Caja<E>) Lis.getCaja());
        }

        /**
         * Devuelve el elemento asociado y avanza el iterador.
         */
        @Override
        public E next() {
            E Temp;

            Temp = this.Actual.elemento();
            this.Actual = this.Actual.cajaSig();
            return Temp;
        }
    }//Fin LisIter
}// End List.
