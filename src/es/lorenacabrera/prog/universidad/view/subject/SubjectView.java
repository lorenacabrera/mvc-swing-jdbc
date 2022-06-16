package es.lorenacabrera.prog.universidad.view.subject;

import es.lorenacabrera.prog.universidad.controller.SubjectController;
import es.lorenacabrera.prog.universidad.dao.SubjectDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectView extends JPanel implements ActionListener {
    private SubjectController controller;

    private JTable table;
    private JScrollPane scrollPane;
    private JDialog dialog;

    public static final String SHOW_EDIT_DIALOG_STRING = "show-edit-dialog";

    public SubjectView(SubjectController controller) {
        this.controller = controller;

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        BorderLayout borderLayout = new BorderLayout();

        this.setLayout(borderLayout);

        String[] columnName = {
                "id",
                "nombre",
                "tipo",
                "curso",
                "cuatrimestre",
                "profesorId",
                "gradoId",
                "credito"
        };

        SubjectDao dao = new SubjectDao();

        scrollPane = new JScrollPane();
        table = new JTable(new SubjectTableModel(dao.findAll(), columnName));
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(this.table);
        scrollPane.setVisible(true);

        add(scrollPane, BorderLayout.CENTER);
        add(new SubjectToolbarView(controller).getPanel(), BorderLayout.LINE_END);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            default:
                System.err.println("Error");
        }
    }
}
