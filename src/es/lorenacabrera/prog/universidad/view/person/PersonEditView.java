package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.model.Person;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonEditView implements ActionListener {
    private JDialog dialog;
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
    private static final String CIUDAD_STRING = "ciudad";
    private static final String DIRECCION_STRING = "direccion";
    private static final String FECHA_NACIMIENTO_STRING = "fecha nacimiento";
    private static final String SEXO_STRING = "sexo";
    private static final String TIPO_STRING = "tipo";

    private static final int COLUMNS_QUANTITY = 25;

    private JButton saveButton;
    private JButton cancelButton;

    public static final String INSERT_STRING = "save";
    public static final String CLOSE_EDIT_DIALOG_STRING = "close-edit-dialog";

    public PersonEditView(PersonController controller) {
        dialog = new JDialog();
        panel = new JPanel();
        this.controller = controller;
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

        ciudadLabel = new JLabel(CIUDAD_STRING);
        ciudadTextField = new JTextField(COLUMNS_QUANTITY);

        direccionLabel = new JLabel(DIRECCION_STRING);
        direccionTextField = new JTextField(COLUMNS_QUANTITY);

        fechaNacimientoLabel = new JLabel(FECHA_NACIMIENTO_STRING);
        fechaNacimientoTextField = new JTextField(COLUMNS_QUANTITY);

        sexoLabel = new JLabel(SEXO_STRING);
        sexoTextField = new JTextField(COLUMNS_QUANTITY);

        tipoLabel = new JLabel(TIPO_STRING);
        tipoTextField = new JTextField(COLUMNS_QUANTITY);

        saveButton = new JButton(INSERT_STRING);
        saveButton.addActionListener(this);
        saveButton.setActionCommand(INSERT_STRING);

        cancelButton = new JButton(CLOSE_EDIT_DIALOG_STRING);
        cancelButton.addActionListener(this);
        cancelButton.setActionCommand(CLOSE_EDIT_DIALOG_STRING);

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

        this.dialog.add(panel);
    }

    public JDialog getDialog() {
        return dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Person person;

        switch (e.getActionCommand()) {
            case CLOSE_EDIT_DIALOG_STRING:
                if (this.dialog.isActive()) {
                    this.getDialog().dispose();
                }
                break;
            case INSERT_STRING:
                person = new Person();

                person.setId(Integer.parseUnsignedInt(idTextField.getText()));
                person.setNombre(nombreTextField.getText());
                person.setApellido1(apellido1TextField.getText());
                person.setApellido2(apellido2TextField.getText());
                person.setCiudad(ciudadTextField.getText());
                person.setDireccion(direccionTextField.getText());
                person.setSexo(sexoTextField.getText());
                person.setTipo(tipoTextField.getText());

                controller.insert(person);

                if (this.dialog.isActive()) {
                    this.dialog.dispose();
                }

                break;
            default:
                break;
        }
    }
}
