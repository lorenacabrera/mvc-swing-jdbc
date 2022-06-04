package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private Object[][] people;
    private String[] columnNames;

    public PersonTableModel(List<Person> people, String[] columnNames) {
        this.columnNames = columnNames;
        this.people = new Object[people.size()][columnNames.length];
        int i = 0;

        for (Person person: people) {
            this.people[i][0] = person.getId();
            this.people[i][1] = person.getNif();
            this.people[i][2] = person.getNombre();
            this.people[i][3] = person.getApellido1();
            this.people[i][4] = person.getApellido2();
            this.people[i][5] = person.getCiudad();
            this.people[i][6] = person.getDireccion();
            this.people[i][7] = person.getTelefono();
            this.people[i][8] = person.getFechaNacimiento();
            this.people[i][9] = person.getSexo();
            this.people[i][10] = person.getTipo();

            i++;
        }
    }

    @Override
    public int getRowCount() {
        return this.people.length;
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
        return this.people[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.people[rowIndex][columnIndex] = aValue;
    }
}
