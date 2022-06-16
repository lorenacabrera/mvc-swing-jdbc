package es.lorenacabrera.prog.universidad.view.subject;

import es.lorenacabrera.prog.universidad.model.Subject;


import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class SubjectTableModel extends AbstractTableModel {
    private Object[][] subjects;
    private String[] columnNames;

    public SubjectTableModel(List<Subject> subjects, String[] columnNames) {
        this.columnNames = columnNames;
        this.subjects = new Object[subjects.size()][columnNames.length];
        int i = 0;

        for(Subject subject:subjects){
            this.subjects[i][0] = subject.getId();
            this.subjects[i][1] = subject.getCredito();
            this.subjects[i][2] = subject.getNombre();
            this.subjects[i][3] = subject.getCustrimestre();
            this.subjects[i][4] = subject.getCurso();
            this.subjects[i][5] = subject.getProfesorId();
            this.subjects[i][6] = subject.getGradoId();
            this.subjects[i][7] = subject.getTipo();

            i++;
        }
    }

    @Override
    public int getRowCount() {
        return this.subjects.length;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.subjects[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.subjects[rowIndex][columnIndex] = aValue;
    }
}
