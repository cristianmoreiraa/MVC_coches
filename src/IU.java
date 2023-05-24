import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU {
    private JPanel panel1;
    private JButton bCrear;
    private JTextField tModelo;
    private JTextField tMatricula;
    private JLabel eModelo;
    private JLabel eMatricula;
    private JButton button1;
    private JButton button2;
    private JButton bSalir;
    private JButton bGaraje;

    public IU() {
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.crearCoche(tModelo.getText(),tMatricula.getText());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bajarVelocidad(tMatricula.getText());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.aumentarVelocidad(tMatricula.getText());
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Se cerrará la aplicación");
                System.exit(3);
            }
        });
        bGaraje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Se está buscando el coche en el garaje");
                Controller.mostrarGaraje(tMatricula.getText());
            }
        });
    }

    public static void crearVentana() {
        JFrame frame = new JFrame("Ventana coches");

        frame.setContentPane(new IU().panel1);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        /**
         * Hacemos que la ventana de la intefaz se abra en el medio de nuestra pantalla
         */
        frame.setLocationRelativeTo(null);

    }
}
