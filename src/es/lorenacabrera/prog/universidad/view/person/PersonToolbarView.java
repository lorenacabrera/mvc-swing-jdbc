package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonToolbarView implements ActionListener {
    private PersonController controller;
    private JPanel panel;
    private JDialog dialog;

    public static final String SHOW_INSERT_DIALOG = "show-insert-dialog";
    public static final String DELETE_BUTTON_NAME = "delete";
    public static final String SHOW_UPDATE_DIALOG = "show-update-dialog";

    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;

    public PersonToolbarView(PersonController controller) {
        this.controller = controller;
        this.panel = new JPanel();

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        insertButton = new JButton(SHOW_INSERT_DIALOG);
        deleteButton = new JButton(DELETE_BUTTON_NAME);
        updateButton = new JButton(SHOW_UPDATE_DIALOG);

        insertButton.setActionCommand(SHOW_INSERT_DIALOG);
        deleteButton.setActionCommand(DELETE_BUTTON_NAME);
        updateButton.setActionCommand(SHOW_UPDATE_DIALOG);

        insertButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);

        this.panel.add(insertButton);
        this.panel.add(deleteButton);
        this.panel.add(updateButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createAndShowPersonEditGUI() {
        PersonEditView personEditView = new PersonEditView(controller);
        this.dialog = personEditView.getDialog();
        dialog.pack();
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case SHOW_INSERT_DIALOG:
                createAndShowPersonEditGUI();
                break;
            default:
                System.err.println("Fuck!");
        }
    }
}
