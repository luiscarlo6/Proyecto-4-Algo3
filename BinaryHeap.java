/**
 * Clase que implementa un heap binario
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 * @param <E> Tipo de objetos que guardara el arreglo
 */
public class BinaryHeap<E extends Comparable<E>> {

    /**
     * arreglo donde se guardan los elementos del heap
     */
    private ArrDin<E> vector;

    /**
     * Costructor
     */
    public BinaryHeap() {
        this.vector = new ArrDin<E>();
    }

    /**
     * Añade un elemento al heap
     * @param e elemento a agregar al heap
     *
     */
    public void add(E e) {
        this.vector.add(e);
        this.subir(this.vector.numElem() - 1);
    }

    /**
     * Elimina el primer elemento deñ heap
     * @return true si removio el primer elemento del heap, false en contrario
     */
    @SuppressWarnings("unchecked")
    public boolean remove() {
        E ultimo = ((E) this.vector.get(this.vector.numElem() - 1));
        this.vector.remove(this.vector.numElem() - 1);
        if (this.vector.numElem() == 0) {
            return false;
        }
        this.vector.add(ultimo, 0);
        this.bajar(0);
        return true;
    }

    /**
     * Obtiene el minimo elemento del heap
     * @return el minimo del heap
     */
    public Object min() {
        if (this.esVacio()) {
            return null;
        }
        return this.vector.get(0);
    }

    /**
     * Indica si el heap esta vacio
     * @return true si el heap es vacio, fal en caso contrario
     */
    public boolean esVacio() {
        return this.vector.numElem() == 0;
    }

    /**
     * @param pos Reordena el heap hacia abajo
     */
    @SuppressWarnings("unchecked")
    private void bajar(int pos) {
        int i = pos;
        while (i < this.vector.numElem() / 2) {
            int posHijo = 2 * i + 1;
            E actual = (E) this.vector.get(i);
            E hijo = (E) this.vector.get(posHijo);
            if (posHijo < this.vector.numElem() - 1 && hijo.compareTo(((E) this.vector.get(posHijo + 1))) > 0) {
                posHijo++;
                hijo = (E) this.vector.get(posHijo);
            }
            if (actual.compareTo(hijo) <= 0) {
                break;
            }
            this.vector.add(actual, posHijo);
            this.vector.add(hijo, i);
            i = posHijo;
        }
    }

    /**
     * @param pos reordena el heap hacia arriba
     */
    @SuppressWarnings("unchecked")
    private void subir(int pos) {
        int i = pos;
        while (i > 0) {
            int posPadre = (i - 1) / 2;
            E actual = (E) this.vector.get(i);
            E padre = (E) this.vector.get(posPadre);
            if (actual.compareTo(padre) >= 0) {
                break;
            }
            this.vector.add(actual, posPadre);
            this.vector.add(padre, i);
            i = posPadre;
        }
    }
}// fin de BinaryHeap
