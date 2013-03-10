/**
 * Interfaz que define el uso de un grafo.
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 */
public interface Graph {

    /**
     * Agrega el nodo n. Si el nodo ya existe en el grafo, retorna false.
     * Si se agrega correctamente el nodo, retorna true.
     *
     * @param n Nodo a agregar
     * @return true si agrego el nodo, false en caso contrario
     */
    public boolean add(Nodo n);

    /**
     * Agrega el Arco a. Si los nodos del arco no existen
     * en el grafo o si ya existe un lado entre dichos nodos,
     * retorna false.
     * Si se agrega correctamente el nodo, retorna true.
     * @param a Aco a agregar
     * @return true si agrego el arco, false en caso contrario
     */
    public boolean add(Arco a);

    /**
     * Retorna un grafo nuevo que es una copia del grafo actual.
     * @return Grafo copia
     */
    public Object clone();

    /**
     * Retorna true si el grafo contiene un nodo igual a n,
     * si no retorna false.
     * @param n Nodo a revisar
     * @return true si el nodo esta en el grafo, false si no
     */
    public boolean contains(Nodo n);

    /**
     * Retorna true si el grafo contiene un arco igual a a,
     * si no retorna false.
     * @param a Arco a revisar
     * @return true si el arco esta en el grafo, false si no esta
     */
    public boolean contains(Arco a);

    /**
     * Remueve del grafo el nodo n con todos sus arcos relacionados.
     * Si el grafo se modifica (si el nodo existia en este), retorna true.
     * Si el grafo se mantiene igual, retorna false.
     * @param n Nodo a remover
     * @return true si el grafo cambia, false si no
     */
    public boolean remove(Nodo n);

    /**
     * Remueve el arco a del grafo.
     * Si el grafo se modifica (si el arco existia en este), retorna true.
     * Si el grafo se mantiene igual, retorna false.
     * @param a Arco a remover
     * @return true si el grafo cambia, false si no
     */
    public boolean remove(Arco a);

    /**
     * Devuelve una lista con todos los nodos del grafo.
     * @return La lista de los nodos
     */
    public Lista<Nodo> getNodos();

    /**
     * Devuelve una lista con todos los arcos del grafo.
     * @return La lista de los arcos
     */
    public Lista<Arco> getArcos();

    /**
     * Devuelve el numero de nodos que hay en el grafo.
     * @return el numero de nodos
     */
    public int getNumNodos();

    /**
     * Devuelve el numero de arcos que hay en el grafo.
     * @return el numero de arcos
     */
    public int getNumArcos();

    /**
     * Devuelve una lista con los predecesores del nodo n.
     * @param n Nodo de entrada
     * @return Lista de predecesores
     */
    public Lista<Nodo> getPred(Nodo n);

    /**
     * Devuelve una lista con los sucesores del nodo n.
     * @param n Nodo de entrada
     * @return Lista de sucesores
     */
    public Lista<Nodo> getSuc(Nodo n);

    /**
     * Devuelve una lista con los arcos que tienen al nodo n como destino.
     * @param n Nodo de entrada
     * @return Lista de Arcos destino
     */
    public Lista<Arco> getIn(Nodo n);

    /**
     * Devuelve una lista con los arcos que tienen al nodo n como fuente.
     * @param n Nodo de entrada
     * @return Lista de Arcos fuente
     */
    public Lista<Arco> getOut(Nodo n);

    /**
     * Devuelve una representacion en String del grafo.
     */
    @Override
    public String toString();

    /**
     * Retorna el nodo n. Si no existe dicho nodo,
     * retorna null.
     * @param n Nodo de entrada
     * @return Nodo de salida identico a n, perteneciente al grafo
     */
    public Nodo get(Nodo n);

    /**
     * @param a Aco de entrada
     * @return Arco de salida identico a "a" perteneciente al grafo
     */
    public Arco get(Arco a);
}
