package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;

public class PersonEditView {
    private JPanel panel;
    private PersonController controller;

    private JLabel idLabel;
    private JLabel nifLabel;
    private JLabel nombreLabel;
    private JLabel apellido1Label;
    private JLabel apellido2Label;
    private JLabel ciudadLabel;
    private JLabel direccionLabel;
    private JLabel fechaNacimientoLabel;
    private JLabel sexoLabel;
    private JLabel tipoLabel;

    private JTextField idTextField;
    private JTextField nifTextField;
    private JTextField nombreTextField;
    private JTextField apellido1TextField;
    private JTextField apellido2TextField;
    private JTextField ciudadTextField;
    private JTextField direccionTextField;
    private JTextField fechaNacimientoTextField;
    private JTextField sexoTextField;
    private JTextField tipoTextField;

    public PersonEditView() {
        panel = new JPanel();
    }

    private void addComponentsToPane() {
        panel.add(idLabel);
    }
}
