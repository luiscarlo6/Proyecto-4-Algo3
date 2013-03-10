/**
 * Clase que implementa un arreglo dinamico.
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 * @param <E> Tipo de objetos que guardara el arreglo
 */
public class ArrDin<E> {

    private Object arr[] = null;
    private int anterior, actual, ocupados;

    /**
     * Construcctor por defecto
     **/
    public ArrDin() {
        this.anterior = 89;
        this.actual = 144;
        this.ocupados = 0;
        this.arr = new Object[this.actual];
    }

    /**
     * Agrega un elemento en la posicion siguiente vacia
     * @param e elemento a agregar
     * @return true si agrego, false si no agrego
     **/
    public boolean add(E e) {
        if (e == null) {
            return false;
        }

        this.ampliar();
        this.arr[this.ocupados] = e;
        this.ocupados++;
        return true;
    }

    /**
     * Agrega un elemento a la posicion
     * "pos" del arreglo
     * @param e elemento a agregar
     * @param pos pos del arreglo donde se quiere agregar
     * @return true si agrego, false si no agrego
     **/
    public boolean add(E e, int pos) {
        if (e == null) {
            return false;
        }
        if (this.arr[pos] == null) {
            this.ocupados++;
        }
        this.arr[pos] = e;
        return true;
    }

    /**
     * Retorna el objeto almacenado en la posicion
     * "pos" del arreglo
     * @param pos posicion del arreglo
     * @return elemento en la posicion pos del arreglo
     **/
    public Object get(int pos) {
        try {
            return this.arr[pos];
        } catch (java.lang.ArrayIndexOutOfBoundsException A) {
            return null;
        }
    }

    /**
     * Amplia el tamaño del arreglo en funcion de
     * la sucecion de fibonacci
     **/
    public void ampliar() {
        if (!(this.ocupados >= this.actual)) {
            return;
        }
        Object viejoArr[] = this.arr;
        this.resize();

        System.arraycopy(viejoArr, 0, this.arr, 0, viejoArr.length);
    }

    /**
     * redimensiona el arreglo en funcion de la
     * sucesion de fibonacci, el arreglo queda vacio
     **/
    public void resize() {
        //calculo de fibonacci
        int nuevoTam = this.actual + this.anterior;
        this.anterior = this.actual;
        this.actual = nuevoTam;

        Object nuevoArr[] = new Object[nuevoTam];
        this.arr = nuevoArr;
    }

    /**
     * Elimina todos los elementos del arreglo
     * (el arreglo queda como recien creado)
     **/
    public void clear() {
        this.ocupados = 0;
        this.arr = new Object[this.actual];
    }

    /**
     * Verifica si el arreglo contiene el elemento o
     * @param o objeto de entrada
     * @return true si el arreglo contiene el elemento o
     **/
    public boolean contains(E o) {
        int i = 0;
        boolean e = false;
        if (this.arr.length == 0) {
            return false;
        }
        while ((!this.arr[i].equals(o)) && (i < this.arr.length)) {
            i++;
        }

        if (this.arr[i].equals(o)) {
            e = true;
        }
        return e;
    }

    /**
     * retorna el arreglo
     * @return retorna el arreglo NO dinamico
     **/
    public Object[] getArr() {
        return this.arr;
    }

    /**
     * retorna el tamaño del arreglo
     * @return retorna el tamaño actual del arreglo
     **/
    public int tam() {
        return this.arr.length;
    }

    /**
     * @return numero de elementos guardados en el arreglo
     **/
    public int numElem() {
        return this.ocupados;
    }

    /**
     * @param pos posicion en el arreglo del elemento a eliminar
     * @return true si elimino un objeto, false si no lo hizo
     **/
    public boolean remove(int pos) {
        try {
            if (this.arr[pos] == null) {
                return false;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException a) {
            return false;
        }
        this.arr[pos] = null;
        this.ocupados--;
        return true;
    }

    /**
     * remueve el elemento "e" del arreglo
     * @param e elemento a remover del arreglo
     * @return true si lo removio, falso si no lo hizo
     **/
    public boolean remove(E e) {
        int pos = this.getPos(e);
        if (pos == -1) {
            return false;
        }
        Object temp[] = new Object[this.arr.length];

        System.arraycopy(this.arr, 0, temp, 0, pos);
        System.arraycopy(this.arr, pos + 1, temp, pos, this.arr.length - (pos + 1));

        this.arr = temp;
        this.ocupados--;
        return true;
    }

    /**
     * @param e elemento
     * @return la pos de elemento en el arreglo, (-1 si no esta)
     **/
    public int getPos(E e) {
        if (e == null) {
            return -1;
        }

        int i = 0;
        if (this.arr.length == 0) {
            return -1;
        }
        try {
            while ((!e.equals(this.arr[i])) && (i < this.arr.length)) {
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException a) {
            return -1;
        }

        if (e.equals(this.arr[i])) {
            return i;
        }
        return -1;
    }
} /*Fin de arrDin*/
