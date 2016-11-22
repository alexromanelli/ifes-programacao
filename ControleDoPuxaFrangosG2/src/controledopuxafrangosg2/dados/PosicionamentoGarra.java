
package controledopuxafrangosg2.dados;

import controledopuxafrangosg2.dados.Comando;

/**
 *
 * @author romanelli
 */
public class PosicionamentoGarra extends Comando {

    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    public PosicionamentoGarra(int sequencial, int x, int y, int z) {
        super(sequencial);
        setX(x);
        setY(y);
        setZ(z);
    }
    
    @Override
    public String getTipo() {
        return "Posicionamento";
    }

    @Override
    public String getParametro() {
        // Exemplo: (x=40; y=25; z=62)
        return "(x=" + Integer.toString(x) + "; y=" + Integer.toString(y) +
                "; z=" + Integer.toString(z) + ")";
    }
    
}
