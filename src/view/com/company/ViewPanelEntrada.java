package view.com.company;

import javax.swing.*;

public class ViewPanelEntrada extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton boton1Button;
    private JButton boton2Button;
    private JPanel panelEntrada;
    private JButton dialog;
    private JTable table1;
    private JButton asignaturasButton;
    private JButton personasButton;


    public ViewPanelEntrada() {

        super("La Ventana es de Prueba");
        setContentPane(panelEntrada);
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);

    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JButton getBoton1Button() {
        return boton1Button;
    }

    public void setBoton1Button(JButton boton1Button) {
        this.boton1Button = boton1Button;
    }

    public JButton getBoton2Button() {
        return boton2Button;
    }

    public void setBoton2Button(JButton boton2Button) {
        this.boton2Button = boton2Button;
    }

    public JPanel getPanelEntrada() {
        return panelEntrada;
    }

    public void setPanelEntrada(JPanel panelEntrada) {
        this.panelEntrada = panelEntrada;
    }

    public JButton getDialog() {
        return dialog;
    }

    public void setDialog(JButton dialog) {
        this.dialog = dialog;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getAsignaturasButton() {
        return asignaturasButton;
    }

    public void setAsignaturasButton(JButton asignaturasButton) {
        this.asignaturasButton = asignaturasButton;
    }

    public JButton getPersonasButton() {
        return personasButton;
    }

    public void setPersonasButton(JButton personasButton) {
        this.personasButton = personasButton;
    }
}
