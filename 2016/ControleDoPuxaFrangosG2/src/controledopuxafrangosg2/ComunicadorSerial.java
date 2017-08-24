package controledopuxafrangosg2;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 *
 * @author romanelli
 */
public class ComunicadorSerial {

    private CommPortIdentifier idPorta;
    private SerialPort portaSerial;
    private String tipoPorta;
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM", // Raspberry Pi
        "/dev/ttyUSB", // Linux
        "COM3", // Windows
    };
    
    private static int TIME_OUT = 1000;
    private static int BAUD_RATE = 9600;

    public ComunicadorSerial(String tipoPorta) {
        this.tipoPorta = tipoPorta;
        abrePortaCom();
    }

    // Abre a porta para comunicação
    public final void abrePortaCom() {
        try {
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            //First, Find an instance of serial port as set in PORT_NAMES.
            iteracaoPorPortas:
            while (portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                for (String portName : PORT_NAMES) {
                    // verifica se o inicio do nome da porta atual e igual ao nome de porta em portName
                    if (currPortId.getName().length() > portName.length() &&
                            currPortId.getName().substring(0, portName.length()).equals(portName)) {
                        portId = currPortId;
                        break iteracaoPorPortas;
                    }
                }
            }
            if (portId == null) {
                System.out.println("Could not find COM port.");
                return;
            }

            idPorta = portId;
            portaSerial = (SerialPort) idPorta.open("Arduino", TIME_OUT);
            portaSerial.setSerialPortParams(BAUD_RATE, portaSerial.DATABITS_8,
                    portaSerial.STOPBITS_1, portaSerial.PARITY_NONE);
        } catch (PortInUseException piu) {
            System.err.println("Porta ja esta aberta!");
        } catch (UnsupportedCommOperationException uscoe) {
            System.err.println("Configuração dos parametros da porta não suportada!");
        }
    }

    // Método que envia um bit para a porta serial
    public void enviarDados(String comando) {
        try {
            OutputStream saida = portaSerial.getOutputStream();
            saida.write(comando.getBytes());
            Thread.sleep(100);
        } catch (IOException ioe) {
            System.out.println("Não foi possivel abrir/enviar_comando na porta serial");
            System.out.println("Erro! STATUS: " + ioe);
        } catch (InterruptedException ie) {
            System.out.println("Problema com as Threads");
            System.out.println("Erro: Status: " + ie);
        }
    }

}
