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
     * Devuelve una lista con todos los nodos del grafo.
     * @return La lista de los nodos
     */
    public Lista<Nodo> getNodos();

    /**
     * @return Lista de todos los arcos del grafo
     */
    public Lista<Arco> getArcos();
    
    /**
     * Devuelve una lista con los sucesores del nodo n.
     * @param n Nodo de entrada
     * @return Lista de sucesores
     */
    public Lista<Nodo> getSuc(Nodo n);

    /**
     * Retorna el nodo n. Si no existe dicho nodo,
     * retorna null.
     * @param n Nodo de entrada
     * @return Nodo de salida identico a n, perteneciente al grafo
     */
    public Nodo get(Nodo n);
}
