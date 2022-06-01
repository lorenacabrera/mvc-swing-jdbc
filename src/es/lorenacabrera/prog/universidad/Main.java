package es.lorenacabrera.prog.universidad;


import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.view.PersonView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection.openConn();

        PersonView personView = new PersonView();

        frame.getContentPane().add(personView.getPanel());

        frame.pack();
        frame.setVisible(true);
    }
}