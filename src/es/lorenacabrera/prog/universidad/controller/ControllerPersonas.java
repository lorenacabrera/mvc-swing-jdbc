package es.lorenacabrera.prog.universidad.controller;


import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;

import view.com.company.DialogoAsignaturas;

import view.com.company.DialogoPersonas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPersonas implements ActionListener {
    DialogoPersonas vista;
    ModelPersonas modelPersonas=new ModelPersonas();
    private final DefaultTableModel m = null;

    public ControllerPersonas() {
    vista=new DialogoPersonas();
    IniciarPersonas();
    cargarTabla();
    vista.setVisible(true);

    }
    public void cargarTabla(){

        ModelPersonas personas = new ModelPersonas();
        vista.getTable1().setModel(personas.CargaDatos(m));


    }
    public void IniciarPersonas(){

        vista.getInsertarButton().addActionListener(this::actionPerformed);
        vista.getBorrarButton().addActionListener(this::actionPerformed);
        vista.getModificarButton().addActionListener(this::actionPerformed);
        vista.getBuscarButton().addActionListener(this::actionPerformed);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Insertar"){

        modelPersonas.InsertarPersona();
        cargarTabla();

        }
        if(e.getActionCommand()=="Borrar"){
            cargarTabla();
            modelPersonas.BorrarPersona();
            cargarTabla();
        }
        if(e.getActionCommand()=="Modificar"){
            cargarTabla();
            modelPersonas.ModificarPersona();
            cargarTabla();
        }
        if(e.getActionCommand()=="Buscar"){
            cargarTabla();
            ModelPersonas personas = new ModelPersonas();
            vista.getTable1().setModel(personas.CargaDatosBusqueda(m));

        }

    }


}

