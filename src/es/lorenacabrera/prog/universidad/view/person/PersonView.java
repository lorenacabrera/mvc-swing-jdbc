package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonView extends JPanel implements ActionListener {
    private PersonController controller;

    private JTable table;
    private JScrollPane scrollPane;
    private JDialog dialog;

    public static final String SHOW_EDIT_DIALOG_STRING = "show-edit-dialog";

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
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(this.table);
        scrollPane.setVisible(true);

        add(scrollPane, BorderLayout.CENTER);
        add(new PersonToolbarView(controller).getPanel(), BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            default:
                System.err.println("Fuck!");
        }
    }
}
