package es.lorenacabrera.prog.universidad.view.subject;

import es.lorenacabrera.prog.universidad.controller.SubjectController;
import es.lorenacabrera.prog.universidad.view.person.PersonEditView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectToolbarView implements ActionListener {
    private SubjectController controller;
    private JPanel panel;
    private JDialog dialog;

    public static final String SHOW_INSERT_DIALOG = "show-insert-dialog";
    public static final String DELETE_BUTTON_NAME = "delete";
    public static final String SHOW_UPDATE_DIALOG = "show-update-dialog";

    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;


    public SubjectToolbarView(SubjectController controller){
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

    private void createAndShowSubjectEditGUI() {
        this.dialog = new JDialog();

        dialog.getContentPane().add(new SubjectEditView(controller).getPanel());
        dialog.pack();
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( e.getActionCommand()) {
            case SHOW_INSERT_DIALOG:
               createAndShowSubjectEditGUI();
               break;
            default:
                System.out.println("Error");
        }
    }
}
