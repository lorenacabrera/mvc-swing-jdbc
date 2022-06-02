package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.dao.PersonDao;
import es.lorenacabrera.prog.universidad.model.Person;
import es.lorenacabrera.prog.universidad.view.person.PersonToolbarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonController implements ActionListener {
    private PersonDao dao;
    public PersonController(PersonDao dao) {
        this.dao = dao;
    }
    public List<Person> findAll() {
        return dao.findAll();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case PersonToolbarView.LIST_BUTTON_NAME:
                System.out.println("Yeah!");
                break;
            default:
                System.out.println("Fuck!");
        }
    }
}