package es.lorenacabrera.prog.universidad;


import es.lorenacabrera.prog.universidad.controller.PersonController;
import es.lorenacabrera.prog.universidad.controller.SubjectController;
import es.lorenacabrera.prog.universidad.dao.PersonDao;
import es.lorenacabrera.prog.universidad.dao.SubjectDao;
import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.view.EntryView;
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

        PersonController personController = new PersonController(new PersonDao());
        SubjectController subjectController = new SubjectController(new SubjectDao());
        EntryView entryView = new EntryView(personController);
        frame.getContentPane().add(entryView);

        frame.pack();
//        frame.setResizable(false);
        frame.setVisible(true);
    }
}