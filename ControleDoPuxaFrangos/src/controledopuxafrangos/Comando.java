package controledopuxafrangos;

/**
 *
 * @author romanelli
 */
public abstract class Comando {
    
    private int sequencial;

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    
    public abstract String obterStringComando();
    
    public abstract String obterTipoComando();
    
}
