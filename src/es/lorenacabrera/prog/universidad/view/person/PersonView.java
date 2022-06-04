package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;

import javax.swing.*;
import java.awt.*;

public class PersonView extends JPanel {
    private PersonController controller;

    private JTable table;

    public PersonView(PersonController controller) {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.controller = controller;

        addComponentsToPane();
    }

    private void addComponentsToPane() {
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

        this.table = new JTable(new PersonTableModel(dao.findAll(), columnNames));

        this.add(this.table);
        this.add(new PersonToolbarView(controller));
    }
}
