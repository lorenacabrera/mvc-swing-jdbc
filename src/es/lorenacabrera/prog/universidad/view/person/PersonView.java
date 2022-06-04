package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;

import javax.swing.*;

public class PersonView {
    private JPanel panel;
    private PersonController controller;

    private JTable table;

    public PersonView(PersonController controller) {
        this.controller = controller;
        this.panel = new JPanel();

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

        this.panel.add(this.table);
        this.panel.add(new PersonToolbarView(controller).getPanel());
    }

    public JPanel getPanel() {
        return panel;
    }
}
