package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.*;

public class PersonBodyView {
    private JPanel panel;
    private PersonController controller;

    public PersonBodyView(PersonController controller) {
        this.panel = new JPanel();
        this.controller = controller;
    }
}
