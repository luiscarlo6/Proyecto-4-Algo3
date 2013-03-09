
public class Topologico {

	public Pila<Nodo> TopoSort(Graph grafo){
		Pila<Nodo> pila = new Pila<Nodo>();
		BinaryHeap<Nodo> cola = new BinaryHeap<Nodo>();
		
		//Obtengo todos los nodos del grafo
		MiLista<Nodo> nodos =(MiLista<Nodo>) grafo.getNodos();
		
		ListIterator<Nodo> it = nodos.iterator();
		int i = 0;
		//Reviso todos los nodos del grafo
		while (i!=nodos.getSize()){
			Nodo n = it.next();
			n = grafo.get(n);
			//Los nodos sin arcos entrantes se agregan a la cola
			if (n.getInDegree()==0){
				n.setVisitado(true);
				cola.add(n);
			}
			i++;
		}
		
		//Comienza el ordenamiento
		while (!cola.esVacio()){
			Nodo s = (Nodo) cola.min();
			cola.remove();
			s = grafo.get(s);
			
			pila.empilar(s);
			
			MiLista<Nodo> ady =(MiLista<Nodo>) grafo.getSuc(s);			
			ListIterator<Nodo> it2 = ady.iterator();
			
			int j = 0;
			while (j!=ady.getSize()){
				Nodo n = it2.next();
				n = grafo.get(n);
				if (!n.getVisitado()/*&&n.getPeso()==Integer.MAX_VALUE*/){
					n.setVisitado(true);
					cola.add(n);
				}
				j++;
			}
		}
		
		
		return pila;
	}
}
