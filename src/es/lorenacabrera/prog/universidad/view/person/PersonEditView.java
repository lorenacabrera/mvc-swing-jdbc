package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

    private static final String ID_STRING = "id";
    private static final String NIF_STRING = "nif";
    private static final String NOMBRE_STRING = "nombre";
    private static final String APELLIDO_1_STRING = "apellido 1";
    private static final String APELLIDO_2_STRING = "apellido 2";
    private static final String CIUDAD_TEXTFIELD = "ciudad";
    private static final String DIRECCION_STRING = "direccion";
    private static final String FECHA_NACIMIENTO_STRING = "fecha nacimiento";
    private static final String SEXO_STRING = "sexo";
    private static final String TIPO_STRING = "tipo";

    private static final int COLUMNS_QUANTITY = 25;

    private JButton saveButton;
    private JButton cancelButton;

    private static final String SAVE_STRING = "save";
    private static final String CANCEL_STRING = "cancel";

    public PersonEditView() {
        panel = new JPanel();

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        GridLayout layout = new GridLayout(0, 2, 5, 5);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.panel.setLayout(layout);

        idLabel =  new JLabel(ID_STRING);
        idTextField = new JTextField(COLUMNS_QUANTITY);

        nombreLabel = new JLabel(NOMBRE_STRING);
        nombreTextField = new JTextField(COLUMNS_QUANTITY);

        apellido1Label = new JLabel(APELLIDO_1_STRING);
        apellido1TextField = new JTextField(COLUMNS_QUANTITY);

        apellido2Label = new JLabel(APELLIDO_2_STRING);
        apellido2TextField = new JTextField(COLUMNS_QUANTITY);

        ciudadLabel = new JLabel(CIUDAD_TEXTFIELD);
        ciudadTextField = new JTextField(COLUMNS_QUANTITY);

        direccionLabel = new JLabel(DIRECCION_STRING);
        direccionTextField = new JTextField(COLUMNS_QUANTITY);

        fechaNacimientoLabel = new JLabel(FECHA_NACIMIENTO_STRING);
        fechaNacimientoTextField = new JTextField(COLUMNS_QUANTITY);

        sexoLabel = new JLabel(SEXO_STRING);
        sexoTextField = new JTextField(COLUMNS_QUANTITY);

        tipoLabel = new JLabel(TIPO_STRING);
        tipoTextField = new JTextField(COLUMNS_QUANTITY);

        saveButton = new JButton(SAVE_STRING);
        saveButton.addActionListener(controller);
        saveButton.setActionCommand(SAVE_STRING);

        cancelButton = new JButton(CANCEL_STRING);
        cancelButton.addActionListener(controller);
        cancelButton.setActionCommand(CANCEL_STRING);

        this.panel.add(idLabel);
        this.panel.add(idTextField);
        this.panel.add(nombreLabel);
        this.panel.add(nombreTextField);
        this.panel.add(apellido1Label);
        this.panel.add(apellido1TextField);
        this.panel.add(apellido2Label);
        this.panel.add(apellido2TextField);
        this.panel.add(ciudadLabel);
        this.panel.add(ciudadTextField);
        this.panel.add(direccionLabel);
        this.panel.add(direccionTextField);
        this.panel.add(fechaNacimientoLabel);
        this.panel.add(fechaNacimientoTextField);
        this.panel.add(sexoLabel);
        this.panel.add(sexoTextField);
        this.panel.add(tipoLabel);
        this.panel.add(tipoTextField);

        this.panel.add(saveButton);
        this.panel.add(cancelButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
