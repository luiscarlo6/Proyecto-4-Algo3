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
     * Devuelve el elemento asociado y avanza el iterador.
     * @return Elemento actual del iterador, avanza
     */
    public E next();
}// End ListIterator.
