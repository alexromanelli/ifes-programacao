package controledopuxafrangos.dados;

/**
 *
 * @author romanelli
 */
public abstract class Comando {
    private long id;
    private int sequencial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
