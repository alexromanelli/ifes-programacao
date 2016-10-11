package controledopuxafrangosg2;

/**
 *
 * @author romanelli
 */
public abstract class Comando {
    private int sequencial;
    
    public int getSequencial() {
        return sequencial;
    }
    
    public Comando(int sequencial) {
        this.sequencial = sequencial;
    }
    
    public abstract String getTipo();
    
    public abstract String getParametro();
}
