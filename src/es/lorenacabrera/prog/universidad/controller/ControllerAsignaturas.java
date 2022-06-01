package es.lorenacabrera.prog.universidad.controller;

import model.com.company.ModelAsignaturas;
import view.com.company.DialogoAsignaturas;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAsignaturas implements ActionListener {
    DialogoAsignaturas vista;
    ModelAsignaturas modelAsignaturas=new ModelAsignaturas();

    private final DefaultTableModel m = null;
    public ControllerAsignaturas() {

        vista=new DialogoAsignaturas();
        IniciarAsignaturas();
        cargarTabla();
        vista.setVisible(true);

    }
    public void cargarTabla(){

        ModelAsignaturas asignatura = new ModelAsignaturas();
        vista.getTableAsignaturas().setModel(asignatura.CargaDatos(m));


    }
    public void IniciarAsignaturas(){





        vista.getInsertarButton().addActionListener(this::actionPerformed);
        vista.getBorrarButton().addActionListener(this::actionPerformed);
        vista.getModificarButton().addActionListener(this::actionPerformed);
        vista.getBuscarButton().addActionListener(this::actionPerformed);





    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Insertar") {
            cargarTabla();
            modelAsignaturas.InsertarAsignatura();
            cargarTabla();

        }
        if (e.getActionCommand() == "Borrar") {
            cargarTabla();
            modelAsignaturas.BorrarAsignatura();
            cargarTabla();
        }
        if (e.getActionCommand() == "Modificar") {
            cargarTabla();
            modelAsignaturas.ModificarAsignatura();
            cargarTabla();
        }
        if (e.getActionCommand() == "Buscar") {
            cargarTabla();
            ModelAsignaturas asignaturas = new ModelAsignaturas();
            vista.getTableAsignaturas().setModel(asignaturas.CargaDatosBusqueda(m));


        }
    }
}
