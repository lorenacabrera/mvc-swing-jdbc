package view.com.company;

import javax.swing.*;

public class DialogoAsignaturas extends JDialog {
    private JPanel contentPane;
    private JButton modificarButton;
    private JButton borrarButton;
    private JButton insertarButton;


    private JTable tableAsignaturas;
    private JButton buscarButton;
    private JButton actualizarTablaButton;



    public DialogoAsignaturas() {

        setContentPane(contentPane);
        setSize(900,1000);
        setLocation(500,20);
        setModal(true);
       // getRootPane().setDefaultButton(buttonOK);
    }
   /* public static void main(String[] args) {
        DialogoAsignaturas dialog = new DialogoAsignaturas();
        dialog.pack();

        dialog.setVisible(true);
        System.exit(0);
    }*/



    public JButton getActualizarTablaButton() {
        return actualizarTablaButton;
    }

    public void setActualizarTablaButton(JButton actualizarTablaButton) {
        this.actualizarTablaButton = actualizarTablaButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(JButton buscarButton) {
        this.buscarButton = buscarButton;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public void setModificarButton(JButton modificarButton) {
        this.modificarButton = modificarButton;
    }

    public JButton getBorrarButton() {
        return borrarButton;
    }

    public void setBorrarButton(JButton borrarButton) {
        this.borrarButton = borrarButton;
    }

    public JButton getInsertarButton() {
        return insertarButton;
    }

    public void setInsertarButton(JButton insertarButton) {
        this.insertarButton = insertarButton;
    }



    public JTable getTableAsignaturas() {
        return tableAsignaturas;
    }

    public void setTableAsignaturas(JTable tableAsignaturas) {
        this.tableAsignaturas = tableAsignaturas;
    }




}
