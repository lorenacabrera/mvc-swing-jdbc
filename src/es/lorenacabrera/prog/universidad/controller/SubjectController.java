package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.dao.SubjectDao;
import es.lorenacabrera.prog.universidad.model.Subject;
import es.lorenacabrera.prog.universidad.view.subject.SubjectEditView;
import es.lorenacabrera.prog.universidad.view.subject.SubjectToolbarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectController implements ActionListener {
    private SubjectDao dao;
    private JDialog dialog;

    public SubjectController(SubjectDao dao) {
        this.dao = dao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case SubjectToolbarView.DELETE_BUTTON_NAME:
                break;
            case SubjectToolbarView.SHOW_UPDATE_DIALOG:
                System.out.println("update!");
                break;
            case SubjectEditView.CLOSE_EDIT_DIALOG:
                if (this.dialog.isActive()) {
                    this.dialog.dispose();
                }
            default:
                System.out.println("error!");
        }
    }

    private void insert() {

    }

    private void update() {

    }

    private void delete(Subject subject) {
        dao.remove(subject);
    }
}

