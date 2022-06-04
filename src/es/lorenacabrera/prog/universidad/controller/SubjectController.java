package es.lorenacabrera.prog.universidad.controller;

import es.lorenacabrera.prog.universidad.dao.SubjectDao;

public class SubjectController {
    private SubjectDao subjectDao;

    public SubjectController(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
}
