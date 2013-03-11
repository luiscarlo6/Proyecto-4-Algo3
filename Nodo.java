/**
 * Clase que almacena la informacion de las aristas en el grafo.
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 */
public class Nodo implements Comparable<Nodo> {

    /**
     * Nombre del nodo
     */
    private String id = null;
    /**
     * Peso del nodo
     */
    private int peso = Integer.MAX_VALUE;
    /**
     * Estado "Visitado" del nodo
     */
    private boolean visitado = false;
    /**
     * Numero de arcos entrantes al nodo
     */
    private int inArcos = 0;

    /**
     * Constructor por defecto
     **/
    public Nodo() {
        this.id = "";
        this.peso = Integer.MAX_VALUE;
    }

    /**
     * Crea un nodo con id i.
     * @param i id del nodo
     */
    public Nodo(String i) {
        this.id = new String(i);
        this.peso = Integer.MAX_VALUE;
    }

    /**
     * Crea un nodo con id i y peso p
     * @param i id del nodo
     * @param p peso del nodo
     */
    public Nodo(String i, int p) {
        this.id = new String(i);
        this.peso = p;
    }

    /**
     * Retorna un nuevo nodo que es copia de this.
     */
    @Override
    protected Object clone() {
        Nodo sal = new Nodo(new String(this.id), this.peso);
        sal.setInDegree(this.inArcos);
        sal.setVisitado(this.visitado);
        return sal;
    }

    /**
     * Retorna la representacion en String del nodo.
     */
    @Override
    public String toString() {
        return new String(new String(this.id));
    }

    /**
     * Indica si el nodo de entrada es igual a this.
     */
    @Override
    public boolean equals(Object o) {
        Nodo n;

        if (o == null) {
            return false;
        }

        if (!(o instanceof Nodo)) {
            return false;
        }

        n = (Nodo) o;

        if (this.id.equalsIgnoreCase(n.id)) {
            return true;
        }

        return false;
    }

    /**
     * reemplaza la condicion de visitado
     * @param v estado de visita para el nodo
     */
    public void setVisitado(boolean v) {
        this.visitado = v;
    }

    /**
     * retorna el status de visitado
     * @return el estado de visita del nodo
     */
    public boolean getVisitado() {
        return this.visitado;
    }

    /**
     * retorna el peso del nodo
     * @return peso del nodo
     */
    public int getPeso() {
        return this.peso;
    }

    /**
     * reemplaza el peso del nodo
     * @param a Peso del Nodo
     */
    public void setPeso(int a) {
        this.peso = a;
    }

    /**
     * @return el numero de arcos entrando al nodo
     */
    public int getInDegree() {
        return this.inArcos;
    }

    /**
     * @param a Numero de arcos entrando al nodo
     */
    public void setInDegree(int a) {
        this.inArcos = a;
    }

    /**
     * Retorna el codigo hash para un nodo.
     */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public int compareTo(Nodo n) {

        if (this.inArcos == n.getInDegree()) {
            return 0;
        } else if (this.inArcos < n.getInDegree()) {
            return -1;
        }
        return 1;
    }
} /*Fin de nodo*/
