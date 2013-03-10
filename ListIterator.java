/**
 * Interfaz que describe un iterador sobre listas.
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 * @param <E> Clase de la estructura de datos a iterar
 */
public interface ListIterator<E> {

    /**
     * Comprueba que exista un proximo elemento.
     * @return true si tiene un siguiente elemento
     */
    public boolean hasNext();

    /**
     * Comprueba que exista un proximo elemento.
     * @return false si tiene un elemento anterior
     */
    public boolean hasPrev();

    /**
     * Devuelve el elemento asociado y avanza el iterador.
     * @return Elemento actual del iterador, avanza
     */
    public E next();

    /**
     * Devuelve el elemento asociado y retrocede el iterador.
     * @return Elemento actual del iterador, retrocede
     */
    public E prev();

    /**
     * Remueve de la lista el ultimo elemento retornado
     */
    public void unlink();
}// End ListIterator.
