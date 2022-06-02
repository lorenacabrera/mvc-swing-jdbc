package es.lorenacabrera.prog.universidad;


import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.view.person.PersonToolbarView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection.openConn();

        PersonController controller = new PersonController();
        PersonToolbarView personToolbarView = new PersonToolbarView(controller);

        frame.getContentPane().add(personToolbarView.getPanel());

        frame.pack();
        frame.setVisible(true);
    }
}