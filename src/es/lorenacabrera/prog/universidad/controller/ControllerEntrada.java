package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.db.Connection;
import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;
import view.com.company.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ControllerEntrada implements ActionListener, MouseListener, WindowListener, KeyListener {

    private final ViewPanelEntrada frEntrada = new ViewPanelEntrada();
    private final DefaultTableModel m = null;


    // Constructor lanza cada uno de los procedimientos de la aplicación
    public ControllerEntrada() {

        iniciarVentana();
        iniciarEventos();
        prepararBaseDatos();
    }

    public void iniciarVentana() {
        frEntrada.setVisible(true);
    }

    public void iniciarEventos() {
        frEntrada.getBoton1Button().addActionListener(this::actionPerformed);
        frEntrada.getBoton2Button().addActionListener(this::actionPerformed);
        frEntrada.getDialog().addActionListener(this::actionPerformed);
        frEntrada.getAsignaturasButton().addActionListener(this::actionPerformed);
        frEntrada.getPersonasButton().addActionListener(this::actionPerformed);
        frEntrada.getPanelEntrada().addMouseListener(this);
        frEntrada.getTable1().addMouseListener(this);
        frEntrada.addWindowListener(this);
        frEntrada.getTextField1().addKeyListener(this);
        frEntrada.getTextField2().addKeyListener(this);
    }

    public void prepararBaseDatos() {
        ModelPersonas entrada = new ModelPersonas();
        frEntrada.getTable1().setModel(entrada.CargaDatos(m));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String entrada = e.getActionCommand();

        switch (entrada) {
            case "CRUD Asignaturas":
               ControllerAsignaturas controllerAsignaturas=new ControllerAsignaturas();
               DialogoAsignaturas dialogoAsignaturas=new DialogoAsignaturas();



                break;

            case "CRUD Personas":
                ControllerPersonas controllerPersonas=new ControllerPersonas();
                DialogoPersonas dialogoPersona=new DialogoPersonas();


                break;

            case "Diálogo":
                DialogoEntrada miDialogo = new DialogoEntrada();
                miDialogo.setSize(400, 200);
                miDialogo.setLocation(400, 300);
                miDialogo.setTitle("Entrada de usuario y contraseña");
                miDialogo.setVisible(true);
                if (miDialogo.getUsuario().equals("") || miDialogo.getContrasenia().equals("")) {
                    JOptionPane.showMessageDialog(null, "No has introducido correctamente el usuario o la contraseña, " +
                            "por lo tanto la acción se ha cancelado");
                } else {
                    System.out.println(miDialogo.getUsuario());
                    frEntrada.getTextField1().setText(miDialogo.getUsuario());
                    System.out.println(miDialogo.getContrasenia());
                    frEntrada.getTextField2().setText(miDialogo.getContrasenia());
                }
                break;

            case "Asignaturas":
                ModelAsignaturas asignatura = new ModelAsignaturas();
                frEntrada.getTable1().setModel(asignatura.CargaDatos(m));
                break;

            case "Personas":
                ModelPersonas persona = new ModelPersonas();
                frEntrada.getTable1().setModel(persona.CargaDatos(m));
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 3) {
            JOptionPane.showMessageDialog(null, "ha pisado el botón derecho");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("ha salido del programa");
        frEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Connection.closeConn();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getComponent().equals(frEntrada.getTextField1()))
            JOptionPane.showMessageDialog(null, "Ha escrito la letra: " + e.getKeyChar() + " en el Jtext del usuario");

        if (e.getComponent().equals(frEntrada.getTextField2()))
            JOptionPane.showMessageDialog(null, "Ha escrito la letra: " + e.getKeyChar() + " en el Jtext de la contraseña");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
