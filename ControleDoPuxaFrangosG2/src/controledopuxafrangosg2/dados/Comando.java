package controledopuxafrangosg2.dados;

/**
 *
 * @author romanelli
 */
public abstract class Comando {
    private long id;
    private int sequencial;
    private ListaComandos lista;
    
    public int getSequencial() {
        return sequencial;
    }
    
    public long getId() {
        return id;
    }
    
    public ListaComandos getLista() {
        return lista;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLista(ListaComandos lista) {
        this.lista = lista;
    }
    
    public Comando(long id, ListaComandos lista, int sequencial) {
        this.id = id;
        this.lista = lista;
        this.sequencial = sequencial;
    }
    
    public abstract String getTipo();
    
    public abstract String getParametro();
}
