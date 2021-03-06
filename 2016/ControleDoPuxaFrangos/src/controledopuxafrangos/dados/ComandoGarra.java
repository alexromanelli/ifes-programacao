package controledopuxafrangos.dados;

import java.text.NumberFormat;

/**
 *
 * @author romanelli
 */
public class ComandoGarra extends Comando {
    
    private int angulo;
    
    public ComandoGarra(int sequencial, int angulo) {
        this.angulo = angulo;
        super.setSequencial(sequencial);
    }

    public ComandoGarra(long id, ListaComandos lista, int sequencial, 
            int angulo) {
        this.angulo = angulo;
        super.setLista(lista);
        super.setSequencial(sequencial);
        super.setId(id);
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    @Override
    public String obterStringComando() {
        NumberFormat nf = NumberFormat.getInstance(); // singleton
        nf.setMinimumIntegerDigits(3);
        String comando = "g" + nf.format(angulo) + "\n";
        return comando;
    }

    @Override
    public String obterTipoComando() {
        return "Abrir/fechar garra";
    }
    
}
