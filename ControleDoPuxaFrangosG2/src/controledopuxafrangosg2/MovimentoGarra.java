package controledopuxafrangosg2;

/**
 *
 * @author romanelli
 */
public class MovimentoGarra extends Comando {
    private int angulo;
    
    public MovimentoGarra(int sequencial, int angulo) {
        super(sequencial);
        this.angulo = angulo;
    }

    @Override
    public String getTipo() {
        return "Garra";
    }

    @Override
    public String getParametro() {
        return Integer.toString(angulo);
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
    
}
