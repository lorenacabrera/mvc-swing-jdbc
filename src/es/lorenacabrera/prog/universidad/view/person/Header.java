package es.lorenacabrera.prog.universidad.view.person;

import javax.swing.*;

public class Header {
    private JPanel panel;

    private static final String LIST_BUTTON_NAME = "persons";
    private static final String INSERT_BUTTON_NAME = "insert";
    private static final String DELETE_BUTTON_NAME = "delete";
    private static final String UPDATE_BUTTON_NAME = "update";

    private JButton listButton;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;

    public Header() {
        panel = new JPanel();
    }

    private void addComponentsToPane() {
        listButton = new JButton(LIST_BUTTON_NAME);
        insertButton = new JButton(INSERT_BUTTON_NAME);
        deleteButton = new JButton(DELETE_BUTTON_NAME);
        updateButton = new JButton(UPDATE_BUTTON_NAME);

        panel.add(listButton);
        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);
    }
}
