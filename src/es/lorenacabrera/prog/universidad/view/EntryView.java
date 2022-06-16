package es.lorenacabrera.prog.universidad.view;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.controller.SubjectController;
import es.lorenacabrera.prog.universidad.view.person.PersonView;
import es.lorenacabrera.prog.universidad.view.subject.SubjectView;

import javax.swing.*;
import java.awt.*;

public class EntryView extends JPanel {
    private JPanel headerPane;
    private JTabbedPane centerPane;
    private PersonController personController;
    private SubjectController subjectController;

    public EntryView(PersonController personController, SubjectController subjectController) {
        this.personController = personController;
        this.subjectController = subjectController;
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
        this.centerPane.addTab("Asignatura", new SubjectView(subjectController));

        this.add(headerPane, BorderLayout.PAGE_START);
        this.add(centerPane, BorderLayout.CENTER);
    }
}
