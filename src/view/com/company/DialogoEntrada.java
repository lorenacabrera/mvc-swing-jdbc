package view.com.company;

import javax.swing.*;
import java.awt.event.*;

public class DialogoEntrada extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textUsuario;
    private JPasswordField passwordField;
    private String usuario;
    private String contrasenia;

    public DialogoEntrada() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        usuario = textUsuario.getText();
        char[] contra = passwordField.getPassword();
        this.contrasenia = String.copyValueOf(contra) ;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        this.usuario = "";
        this.contrasenia = "";
        dispose();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public static void main(String[] args) {
        DialogoEntrada dialog = new DialogoEntrada();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
