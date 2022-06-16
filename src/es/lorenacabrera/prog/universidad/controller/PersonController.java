package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.dao.PersonDao;
import es.lorenacabrera.prog.universidad.model.Person;
import es.lorenacabrera.prog.universidad.view.person.PersonEditView;
import es.lorenacabrera.prog.universidad.view.person.PersonToolbarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonController implements ActionListener {
    private PersonDao dao;
    private JDialog dialog;

    public PersonController(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case PersonToolbarView.DELETE_BUTTON_NAME:
                break;
            case PersonToolbarView.SHOW_UPDATE_DIALOG:
                System.out.println("Fuck update!");
                break;
            case PersonEditView.CLOSE_EDIT_DIALOG_STRING:
                break;
            default:
                System.out.println("Fuck!");
        }
    }

    public void insert(Person person) {
        dao.insert(person);
    }

    private void update(Person person) {
        dao.update(person);
    }

    private void delete(Integer id) {
        dao.remove(id);
    }
}