package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;

public class PersonCommonView {
    private JPanel panel;
    private PersonController controller;

    private JTable table;

    public PersonCommonView(PersonController controller) {
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

        this.table = new JTable(controller.findAll(), columnNames);
    }
}
