package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;

import javax.swing.*;
import java.awt.*;

public class PersonView extends JPanel {
    private PersonController controller;

    private JTable table;
    private JScrollPane scrollPane;

    public PersonView(PersonController controller) {
        this.controller = controller;

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        BorderLayout borderLayout = new BorderLayout();

        this.setLayout(borderLayout);

        String[] columnNames = {
          "id",
          "nif",
          "nombre",
          "apellido 1",
          "apellido 2",
          "ciudad",
          "dirección",
          "teléfono",
          "fecha nacimiento",
          "sexo",
          "tipo"
        };

        PersonDao dao = new PersonDao();

        scrollPane = new JScrollPane();
        table = new JTable(new PersonTableModel(dao.findAll(), columnNames));
        scrollPane.setViewportView(this.table);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 8;
        constraints.gridheight = GridBagConstraints.RELATIVE;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
//        add(scrollPane, constraints);
        add(scrollPane, BorderLayout.CENTER);

        constraints.gridx = 8;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0;
        constraints.weighty = 0;
//        add(new PersonToolbarView(controller), constraints);
        add(new PersonToolbarView(controller), BorderLayout.LINE_END);
    }
}
