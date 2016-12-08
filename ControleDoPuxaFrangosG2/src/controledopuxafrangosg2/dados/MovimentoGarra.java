package controledopuxafrangosg2.dados;

import controledopuxafrangosg2.dados.Comando;

/**
 *
 * @author romanelli
 */
public class MovimentoGarra extends Comando {
    private int angulo;
    
    public MovimentoGarra(long id, ListaComandos lista, int sequencial, int angulo) {
        super(id, lista, sequencial);
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
