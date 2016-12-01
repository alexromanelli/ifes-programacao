package controledopuxafrangos.dados;

/**
 *
 * @author romanelli
 */
public abstract class Comando {
    private long id;
    private ListaComandos lista;
    private int sequencial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ListaComandos getLista() {
        return lista;
    }

    public void setLista(ListaComandos lista) {
        this.lista = lista;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    
    public abstract String obterStringComando();
    
    public abstract String obterTipoComando();
    
}
