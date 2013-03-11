/**
 * Clase que almacena la informacion de las aristas en el grafo.
 *
 * Luiscarlo Rivera, 09-11020
 * Jose Prado, 09-11006
 *
 * Proyecto 4
 * Prof Lab: Juan Arocha
 *
 **/
public class Arco {

    /**
     * Nodo fuente del arco
     */
    private String src = "";
    /**
     * Nodo destino del arco
     */
    private String dst = "";

    /**
     * Crea una arista entre los vertices src y dst.
     *
     * @param src1 id del Nodo fuente del arco
     * @param dst1 id del Nodo destino del arco
     **/
    public Arco(String src1, String dst1) {
        this.src = new String(src1);
        this.dst = new String(dst1);
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
     *
     * @return id del Nodo fuente del Arco
     **/
    public String getSrc() {
        return (new String(this.src));
    }

    /**
     * Retorna el vertice dst de la arista.
     *
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
} /* Fin de arco */
