/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangos;

/**
 *
 * @author romanelli
 */
public class ControleDoPuxaFrangos {

    //<editor-fold defaultstate="collapsed" desc=" Comunicaçao via USB ">
    /*
    public static void write(DeviceHandle handle, byte[] data) {
        ByteBuffer buffer = BufferUtils.allocateByteBuffer(data.length);
        buffer.put(data);
        IntBuffer transferred = BufferUtils.allocateIntBuffer();
        int result = LibUsb.controlTransfer(handle, 
                (byte) (LibUsb.REQUEST_TYPE_CLASS | LibUsb.RECIPIENT_INTERFACE),
                (byte) 0x09, (short) 2, (short) 1, buffer,
                1000);
        if (result != LibUsb.SUCCESS) {
            System.out.println(new LibUsbException("Unable to send data", result).getMessage());
        }
        System.out.println(transferred.get() + " bytes sent to device");
    }
     */
    //</editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Comunicaçao via USB ">
        /*

        // Create the libusb context
        Context context = new Context();

        // Initialize the libusb context
        int result = LibUsb.init(context);
        if (result < 0) {
            throw new LibUsbException("Unable to initialize libusb", result);
        }

        // Read the USB device list
        DeviceList list = new DeviceList();
        result = LibUsb.getDeviceList(context, list);
        if (result < 0) {
            throw new LibUsbException("Unable to get device list", result);
        }

        Device arduino = null;
        short arduinoVendorId = 0;
        short arduinoProductId = 0;
        try {
            // Iterate over all devices and list them
            for (Device device : list) {
                int address = LibUsb.getDeviceAddress(device);
                int busNumber = LibUsb.getBusNumber(device);
                DeviceDescriptor descriptor = new DeviceDescriptor();
                result = LibUsb.getDeviceDescriptor(device, descriptor);
                if (descriptor.idProduct() == 67
                        && descriptor.idVendor() == 9025) {
                    arduino = device;
                    arduinoProductId = descriptor.idProduct();
                    arduinoVendorId = descriptor.idVendor();
                    System.out.println("achou");
                }

                if (result < 0) {
                    throw new LibUsbException(
                            "Unable to read device descriptor", result);
                }
                System.out.format(
                        "Bus %03d, Device %03d: Vendor %04x, Product %04x, %d, %d\n",
                        busNumber, address, descriptor.idVendor(),
                        descriptor.idProduct(), descriptor.idVendor(), descriptor.idProduct());
            }
        } finally {
            // Ensure the allocated device list is freed
            LibUsb.freeDeviceList(list, true);
        }

        // envia comandos para o arduino
        //LibUsb.
        DeviceHandle arduinoHandle = new DeviceHandle();
        result = LibUsb.open(arduino, arduinoHandle);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to open USB device", result);
        }
        String comando = "x150\n";
        byte[] bComando = comando.getBytes();
        write(arduinoHandle, bComando);

        // Deinitialize the libusb context
        LibUsb.exit(context);
         */
        //</editor-fold>
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal.getInstance().setVisible(true);
            }
        });
    }
}
