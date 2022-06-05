package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.dao.PersonDao;
import es.lorenacabrera.prog.universidad.model.Person;
import es.lorenacabrera.prog.universidad.view.person.PersonEditView;
import es.lorenacabrera.prog.universidad.view.person.PersonToolbarView;

import javax.swing.*;
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
            case PersonToolbarView.INSERT_BUTTON_NAME:
                createAndShowPersonEditGUI();
            default:
                System.out.println("Fuck!");
        }
    }

    public void createAndShowPersonEditGUI() {
        JDialog dialog = new JDialog();

        dialog.getContentPane().add(new PersonEditView().getPanel());
        dialog.pack();
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}