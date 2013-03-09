/**
 * Clase que implementa Ordenamiento topologico sobre un grafo 
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 * 
 * Proyecto 4
 * Prof Lab: Juan Arocha 
 *
 * @author Luiscarlo
 */
public class Topologico {
	private Pila<Nodo> pila;//Pila de salida
	private BinaryHeap<Nodo> cola;//Cola de prioridades
	private Graph grafo;//grafo al cual se aplicara el ordenamiento

	/**
	 * @param g grafo para el ordenamiento
	 */
	public Topologico(Graph g){
		this.grafo = g;
		this.pila = new Pila<Nodo>();
		this.cola = new BinaryHeap<Nodo>();
	}
	/**
	 * Implementacion del algoritmo modificado de ordenamiento topologico
	 * @return Una pila con el ordenamiento topologico del grafo
	 */
	public Pila<Nodo> TopoSort(){		
		this.iniciales();
		//Comienza el ordenamiento
		while (!this.cola.esVacio()){
			Nodo s = (Nodo) this.cola.min();
			this.cola.remove();
			s = this.grafo.get(s);

			this.pila.empilar(s);

			MiLista<Nodo> ady =(MiLista<Nodo>) this.grafo.getSuc(s);			
			ListIterator<Nodo> it2 = ady.iterator();

			int j = 0;
			while (j!=ady.getSize()){
				Nodo n = it2.next();
				n = this.grafo.get(n);
				if (!n.getVisitado()){
					n.setVisitado(true);
					this.cola.add(n);
				}
				j++;
			}
		}		
		return this.pila;
	}

	/**
	 * Llena la cola de prioridades con los nodos sin arcos entrantes
	 */
	public void iniciales(){
		//Obtengo todos los nodos del grafo
		MiLista<Nodo> nodos =(MiLista<Nodo>) this.grafo.getNodos();		
		ListIterator<Nodo> it = nodos.iterator();

		int i = 0;
		//Reviso todos los nodos del grafo
		while (i!=nodos.getSize()){
			Nodo n = it.next();
			n = this.grafo.get(n);
			//Los nodos sin arcos entrantes se agregan a la cola
			if (n.getInDegree()==0){
				n.setVisitado(true);
				this.cola.add(n);
			}
			i++;
		}

	}
}
