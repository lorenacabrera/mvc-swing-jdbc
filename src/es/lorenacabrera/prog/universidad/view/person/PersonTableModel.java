package es.lorenacabrera.prog.universidad.view.person;

import es.lorenacabrera.prog.universidad.controller.PersonController;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PersonTableModel implements TableModel {
    private PersonController controller;
    private static final String[] columnNames = {
        "id",
        "nif",
        "nombre",
        "apellido 1",
        "apellido 2",
        "ciudad",
        "dirección",
        "teléfono",
        "fecha nacimiento",
        "sexo",
        "tipo"
    };

    public PersonTableModel(PersonController controller) {
        this.controller = controller;
    }

    @Override
    public int getRowCount() {
        return controller.findAll().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
