package es.lorenacabrera.prog.universidad.view;

import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.SubjectDao;

import javax.swing.*;

public class PersonView {
    private JPanel panel;
    private PersonController controller;

    private JPanel controlPanel;
    private JPanel mainPanel;

    private JButton subjectButton;
    private JButton teacherButton;
    private JButton listButton;
    private JButton updateButton;

    private JTextField test;

    private static final String SUBJECT_BUTTON = "asignaturas";
    private static final String TEACHER_BUTTON = "profesores";
    private static final String LIST_BUTTON = "show";
    private static final String UPDATE_BUTTON = "update";

    public PersonView() {
        createAndShowPanel();
    }

    private void createAndShowPanel() {
        panel = new JPanel();

        this.subjectButton = new JButton(SUBJECT_BUTTON);
        this.teacherButton = new JButton(TEACHER_BUTTON);
        this.listButton = new JButton(LIST_BUTTON);
        this.updateButton = new JButton(UPDATE_BUTTON);

        test = new JTextField();
        test.setText(new SubjectDao().findById(1).getNombre());

        panel.add(subjectButton);
        panel.add(teacherButton);
        panel.add(listButton);
        panel.add(updateButton);

        panel.add(test);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
