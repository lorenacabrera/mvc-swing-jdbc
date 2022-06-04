package es.lorenacabrera.prog.universidad.view;

import javax.swing.*;
import java.awt.*;

public class EntryView extends JPanel {
    private JPanel headerPane;
    private JTabbedPane centerPane;

    public EntryView() {
        this.headerPane = new JPanel();
        this.centerPane = new JTabbedPane();

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        JLabel headerLabel = new JLabel("Universidad");

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        this.headerPane.add(headerLabel);
        this.centerPane.addTab("Asignatura", new JLabel("Fuck!"));
        this.centerPane.addTab("Persona", new JLabel("Yeah!"));

        this.add(headerPane, BorderLayout.PAGE_START);
        this.add(centerPane, BorderLayout.CENTER);
    }
}
