/**
 * Clase que implementa el TAD Pila
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 * @param <E> Tipo de elemento que contendra la pila
 */
public class Pila<E> {

    /**
     * Lista donde e guardan los elementos de la pila
     */
    private Lista<E> lista;

    /**
     * Constructor por defecto
     */
    public Pila() {
        this.lista = new MiLista<E>();
    }

    /**
     * @return true si la pila no tiene elementos
     */
    public boolean esVacia() {
        return this.lista.getSize() == 0;
    }

    /**
     * Empila el elemento e
     * @param e elemento a empilar
     * @return true si empilo el elemento
     */
    public boolean empilar(E e) {
        return this.lista.add(e);
    }

    /**
     * desencola el primer elemento
     * @return el elemento desempilado
     */
    public E desempilar() {
        E e = this.lista.getLast();
        this.lista.remove(e);
        return e;
    }

    /**
     * @return el primero de lapila
     */
    public E primero() {
        return this.lista.getLast();
    }
}
