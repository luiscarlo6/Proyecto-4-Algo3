/**
 * 
 * Clase que almacena la informacion de las aristas en el grafo.
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 3
 * Prof Lab: Juan Arocha
 **/
public class Arco implements Comparable<Arco> {

	private String src = "";
	private String dst = "";
	private int peso = Integer.MAX_VALUE;


	/**
	 * Crea una arista entre los vertices src y dst.
	 * @param src id del Nodo fuente del arco
	 * @param dst id del Nodo destino del arco
	 **/
	public Arco(String src, String dst) {
		this.src = new String(src);
		this.dst = new String(dst);
	}


	/**
	 * Crea una arista entre los vertices src y dst.
	 * @param src id del Nodo fuente del arco
	 * @param dst id del Nodo destino del arco
	 * @param p peso del Arco
	 **/
	public Arco(String src, String dst, int p) {
		this.src = new String(src);
		this.dst = new String(dst);
		this.peso = p;
	}


	/**
	 * Retorna una nueva arista que es copia de this.
	 **/
	@Override
	protected Object clone() {
		// se copian (clonan) todos los objetos internos,
		return new Arco(new String(this.src), new String(this.dst), this.peso);
	}


	/**
	 * Indica si la arista de entrada es igual a this.
	 **/
	@Override
	public boolean equals(Object o) {
		Arco a;
		if (o == null) {
			return false;
		}

		if (!(o instanceof Arco)) {
			return false;
		}

		a = (Arco) o;

		if (this.src.equalsIgnoreCase(a.getSrc())
				&& this.dst.equalsIgnoreCase(a.getDst())) {
			return true;
		}
		return false;
	}


	/**
	 * Retorna el vertice src de la arista.
	 * @return id del Nodo fuente del Arco
	 **/
	public String getSrc() {
		return (new String(this.src));
	}


	/**
	 * Retorna el vertice dst de la arista.
	 * @return id del Nodo destino del Arco
	 **/
	public String getDst() {
		return (new String(this.dst));
	}


	/**
	 * @return peso del Arco
	 **/
	public int getPeso() {
		return this.peso;
	}

	/**
	 * @param a es asignado al peso del arco
	 **/
	public void setPeso(int a) {
		this.peso = a;
	}

	/**
	 * Retorna la representacion en String de la arista.
	 **/
	@Override
	public String toString() {
		return "(" + this.src + ", " + this.dst + ")" + " Peso:" + this.peso;
	}


	/**
	 * Retorna el codigo hash para un arco.
	 */
	@Override
	public int hashCode() {
		return this.src.hashCode() + this.dst.hashCode();
	}


	/**
	 * Compara dos arcos
	 **/
	@Override
	public int compareTo(Arco a) {
		if (this.peso == a.peso) {
			return 0;
		} else if (this.peso < a.peso) {
			return -1;
		}
		return 1;
	}


} /*Fin de arco*/
