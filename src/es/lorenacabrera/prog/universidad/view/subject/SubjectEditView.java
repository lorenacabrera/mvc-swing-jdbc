package es.lorenacabrera.prog.universidad.view.subject;

import es.lorenacabrera.prog.universidad.controller.SubjectController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectEditView implements ActionListener{
    private JPanel panel;
    private SubjectController controller;

    private JLabel idLabel;
    private JLabel nombreLabel;
    private JLabel creditolabel;
    private JLabel tipoLabel;
    private JLabel cursoLabel;
    private JLabel cuatrimestreLabel;
    private JLabel profesorIdLabel;
    private JLabel gradoIdLabel;

    private JTextField idTexField;
    private JTextField nombreTexField;
    private JTextField creditoTexField;
    private JTextField tipoTexField;
    private JTextField cursoTexField;
    private JTextField cuatrimestreTexField;
    private JTextField profesorIdTexField;
    private JTextField gradoIdTexField;

    private static final String ID_STRING = "id";
    private static final String NOMBRE_STRING = "nombre";
    private static final String CREDITO_STRING = "credito";
    private static final String TIPO_STRING = "tipo";
    private static final String CURSO_STRING = "curso";
    private static final String CUATRIMESTRE_STRING = "cuatrimestre";
    private static final String PROFESORID_STRING = "profesorId";
    private static final String GRADOID_STRING = "gradoId";

    private static final int COLUMNS_QUANTITY = 25;

    private JButton saveButton;
    private JButton cancelButton;

    public static final String INSERT_STRING = "save";
    public static final String CLOSE_EDIT_DIALOG = "cancel";


    public SubjectEditView(SubjectController controller) {
        panel = new JPanel();
        this.controller = controller;

        addComponentsToPane();
    }

    private void addComponentsToPane(){
        GridLayout layout = new GridLayout(0, 2, 5, 5);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.panel.setLayout(layout);

        idLabel = new JLabel(ID_STRING);
        idTexField = new JTextField(COLUMNS_QUANTITY);

        nombreLabel = new JLabel(NOMBRE_STRING);
        nombreTexField = new JTextField(COLUMNS_QUANTITY);

        creditolabel = new JLabel(CREDITO_STRING);
        creditoTexField = new JTextField(COLUMNS_QUANTITY);

        tipoLabel = new JLabel(TIPO_STRING);
        tipoTexField = new JTextField(COLUMNS_QUANTITY);

        cursoLabel = new JLabel(CURSO_STRING);
        cursoTexField = new JTextField(COLUMNS_QUANTITY);

        cuatrimestreLabel = new JLabel(CUATRIMESTRE_STRING);
        cuatrimestreTexField = new JTextField(COLUMNS_QUANTITY);

        profesorIdLabel = new JLabel(PROFESORID_STRING);
        profesorIdTexField = new JTextField(COLUMNS_QUANTITY);

        gradoIdLabel = new JLabel(GRADOID_STRING);
        gradoIdTexField = new JTextField(COLUMNS_QUANTITY);

        saveButton = new JButton(INSERT_STRING);
        saveButton.addActionListener(controller);
        saveButton.setActionCommand(INSERT_STRING);;

        cancelButton = new JButton(CLOSE_EDIT_DIALOG);
        cancelButton.addActionListener(this);
        cancelButton.setActionCommand(CLOSE_EDIT_DIALOG);

        this.panel.add(idLabel);
        this.panel.add(idTexField);
        this.panel.add(nombreLabel);
        this.panel.add(nombreTexField);
        this.panel.add(creditolabel);
        this.panel.add(creditoTexField);
        this.panel.add(tipoLabel);
        this.panel.add(tipoTexField);
        this.panel.add(cursoLabel);
        this.panel.add(cursoTexField);
        this.panel.add(cuatrimestreLabel);
        this.panel.add(cuatrimestreTexField);
        this.panel.add(profesorIdLabel);
        this.panel.add(profesorIdTexField);
        this.panel.add(profesorIdTexField);
        this.panel.add(gradoIdLabel);
        this.panel.add(gradoIdTexField);

        this.panel.add(saveButton);
        this.panel.add(cancelButton);
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case CLOSE_EDIT_DIALOG:
                Component parent = this.panel.getParent();
                break;
            default:
                System.err.println("Error");
        }
    }
}
