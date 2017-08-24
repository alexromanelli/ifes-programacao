package controledopuxafrangosg2;

import java.text.NumberFormat;

/**
 *
 * @author romanelli
 */
public class BracoRobotico {

    private static BracoRobotico INSTANCE;

    public static BracoRobotico getInstance() { // Singleton
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

    void enviarStringComando(String comando) {
        comunicadorSerial.enviarDados(comando);
    }

}
