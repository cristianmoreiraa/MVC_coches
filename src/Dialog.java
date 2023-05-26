import javax.swing.*;

/**
 * Clase que representa un diálogo personalizado en Swing.
 */
public class Dialog extends JDialog {
    private JPanel panel1;
    private JLabel eVelocidad;

    /**
     * Constructor de la clase Dialog.
     * Configura el contenido del diálogo y establece las propiedades.
     */
    public Dialog() {
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * Método estático para mostrar un diálogo con un mensaje especificado.
     * @param mensajito el mensaje a mostrar en el diálogo.
     */
    public static void vDialogo(String mensajito) {
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.eVelocidad.setText(mensajito);
        dialogo.setVisible(true);
        dialogo.setLocationRelativeTo(null);
    }
}
