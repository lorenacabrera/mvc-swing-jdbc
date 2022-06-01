package view.com.company;

import javax.swing.*;

public class DialogoPersonas extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton insertarButton;
    private JButton borrarButton;
    private JButton modificarButton;
    private JTable table1;
    private JButton buscarButton;

    public DialogoPersonas() {
        setContentPane(contentPane);
        setSize(900,1000);
        setLocation(500,20);
        setModal(true);
       // getRootPane().setDefaultButton(buttonOK);
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(JButton buscarButton) {
        this.buscarButton = buscarButton;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOK = buttonOK;
    }

    public JButton getInsertarButton() {
        return insertarButton;
    }

    public void setInsertarButton(JButton insertarButton) {
        this.insertarButton = insertarButton;
    }

    public JButton getBorrarButton() {
        return borrarButton;
    }

    public void setBorrarButton(JButton borrarButton) {
        this.borrarButton = borrarButton;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public void setModificarButton(JButton modificarButton) {
        this.modificarButton = modificarButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }
}
