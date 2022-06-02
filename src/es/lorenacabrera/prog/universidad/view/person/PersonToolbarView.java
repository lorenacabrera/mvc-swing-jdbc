package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;

public class PersonToolbarView {
    private JPanel panel;
    private PersonController controller;

    public static final String LIST_BUTTON_NAME = "persons";
    public static final String INSERT_BUTTON_NAME = "insert";
    public static final String DELETE_BUTTON_NAME = "delete";
    public static final String UPDATE_BUTTON_NAME = "update";

    private JButton listButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;

    public PersonToolbarView(PersonController controller) {
        panel = new JPanel();
        this.controller = controller;
        addComponentsToPane();
    }

    private void addComponentsToPane() {
        listButton = new JButton(LIST_BUTTON_NAME);
        insertButton = new JButton(INSERT_BUTTON_NAME);
        deleteButton = new JButton(DELETE_BUTTON_NAME);
        updateButton = new JButton(UPDATE_BUTTON_NAME);

        listButton.setActionCommand(LIST_BUTTON_NAME);
        insertButton.setActionCommand(INSERT_BUTTON_NAME);
        deleteButton.setActionCommand(DELETE_BUTTON_NAME);
        updateButton.setActionCommand(UPDATE_BUTTON_NAME);

        listButton.addActionListener(controller);
        insertButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        updateButton.addActionListener(controller);

        panel.add(listButton);
        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}