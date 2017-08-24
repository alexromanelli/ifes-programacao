package controledopuxafrangos;

import java.text.NumberFormat;

/**
 *
 * @author romanelli
 */
public class BracoRobotico {

    private static BracoRobotico INSTANCE;

    public static BracoRobotico getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BracoRobotico();
        }
        return INSTANCE;
    }

    private static String TIPO_PORTA_SERIAL = "/dev/ttyACM0";
    private ComunicadorSerial comunicadorSerial;
    
    public BracoRobotico() {
        comunicadorSerial = new ComunicadorSerial(TIPO_PORTA_SERIAL);
    }

    void moverGarra(int angulo) {
        NumberFormat nf = NumberFormat.getInstance(); // singleton
        nf.setMinimumIntegerDigits(3);
        String comando = "g" + nf.format(angulo) + "\n";
        enviarStringComando(comando);
    }
    
    void posicionarGarra(int x, int y, int z) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(2);
        char sinalX = x < 0 ? '-' : '+';
        char sinalY = y < 0 ? '-' : '+';
        char sinalZ = z < 0 ? '-' : '+';
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
        String comando = "p:" + sinalX + nf.format(x) + "," + sinalY + nf.format(y) + "," + sinalZ + nf.format(z) + "\n";
        enviarStringComando(comando);
    }

    void enviarStringComando(String comando) {
        comunicadorSerial.enviarDados(comando);
    }

}
