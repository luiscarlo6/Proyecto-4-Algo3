/**
 * Interfaz que define el comportamiento de una lista
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 * @param <E> TIpo de clase que guardara la lista
 */
public interface Lista<E> {

    /**
     * Agrega un elemento a la lista.
     * @param element Elemento a agregar
     * @return true si se agrego, false en caso contrario
     */
    public boolean add(E element);

    /**
     * @return el primer elemento de la lista
     */
    public E get();

    /**
     * @return el ultimo elemento de la lista
     */
    public E getLast();

    /**
     * Determina si el elemento dado esta en la lista.
     * @param element elemento a verificar
     * @return true si contiene el elemento, false en caso contrario
     */
    public boolean contains(E element);

    /**
     * Determina si la lista dada es igual a la lista.
     * @param list Lista a verificar
     * @return true si las listas son iguales, false en caso contrario
     */
    public boolean equals(Lista<E> list);

    /**
     * Determina si la lista es vacia.
     * @return true sila lista no tiene elementos
     */
    public boolean isEmpty();

    /**
     * Elimina el elemento dado de la lista. Si la lista cambia,
     * retorna true, sino retorna false.
     * @param element elemento a eliminar
     * @return true si elimino el elemento, false si la lista no cambia
     */
    public boolean remove(E element);

    /**
     * Retorna el numero de elementos en la lista
     * @return numero de elementos de la lista
     */
    public int getSize();

    /**
     * Retorna un arreglo que contiene todos los elementos
     * en esta lista.
     * @return Arreglo de elementos
     */
    public Object[] toArray();

    /**
     * Elimina todos los elementos de la lista
     * esta queda como recien creada
     */
    public void clear();
}
