/**
 * 
 * Clase que almacena la informacion de las aristas en el grafo.
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 3
 * Prof Lab: Juan Arocha
 **/
public class Arco {

	private String src = "";
	private String dst = "";


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
	 * Retorna una nueva arista que es copia de this.
	 **/
	@Override
	protected Object clone() {
		// se copian (clonan) todos los objetos internos,
		return new Arco(new String(this.src), new String(this.dst));
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
	 * Retorna la representacion en String de la arista.
	 **/
	@Override
	public String toString() {
		return "(" + this.src + ", " + this.dst + ")";
	}


	/**
	 * Retorna el codigo hash para un arco.
	 */
	@Override
	public int hashCode() {
		return this.src.hashCode() + this.dst.hashCode();
	}

} /*Fin de arco*/
