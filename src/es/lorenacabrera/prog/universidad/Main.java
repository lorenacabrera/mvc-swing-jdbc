package es.lorenacabrera.prog.universidad;


import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;
import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.view.person.PersonView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection.openConn();

        PersonController controller = new PersonController(new PersonDao());
        PersonView commonView = new PersonView(controller);
        frame.getContentPane().add(commonView.getPanel());

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}