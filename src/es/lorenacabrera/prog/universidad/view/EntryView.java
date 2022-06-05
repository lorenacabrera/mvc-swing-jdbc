package es.lorenacabrera.prog.universidad.view;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.view.person.PersonView;

import javax.swing.*;
import java.awt.*;

public class EntryView extends JPanel {
    private JPanel headerPane;
    private JTabbedPane centerPane;
    private PersonController personController;

    public EntryView(PersonController personController) {
        this.personController = personController;
        this.headerPane = new JPanel();
        this.centerPane = new JTabbedPane();

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        JLabel headerLabel = new JLabel("Universidad");

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        this.headerPane.add(headerLabel);
        this.centerPane.addTab("Persona", new PersonView(personController));
        this.centerPane.addTab("Asignatura", new JLabel("Yeah!"));

        this.add(headerPane, BorderLayout.PAGE_START);
        this.add(centerPane, BorderLayout.CENTER);
    }
}
