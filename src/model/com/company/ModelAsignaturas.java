package model.com.company;

import es.lorenacabrera.prog.universidad.db.Connection;

import Dtos.DtoAsignaturas;
import view.com.company.DialogoAsignaturas;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelAsignaturas implements KeyListener {

    DialogoAsignaturas vista=new DialogoAsignaturas();
    DtoAsignaturas asignatura=new DtoAsignaturas();
    int curso;
    String tipo;


    private Statement stmt;

    public DefaultTableModel CargaDatos(DefaultTableModel m) {
        String[] titulos = {"ID", "Nombre", "Créditos", "Tipo", "Curso", "Cuatrimestre", "Id Profesor", "Id Grado"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = Connection.getStatement();
            ResultSet rs = stmt.executeQuery("select * from asignatura");
            String[] fila = new String[8];

            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("creditos");
                fila[3] = rs.getString("tipo");
                fila[4] = rs.getString("curso");
                fila[5] = rs.getString("cuatrimestre");
                fila[6] = rs.getString("id_profesor");
                fila[7] = rs.getString("id_grado");
                m.addRow(fila);
            }
        } catch (SQLException e) {

        }
        return m;
    }

    public void introducirDatos(){
        asignatura.setNombre(JOptionPane.showInputDialog("Inserte el nombre de la asignatura"));
        asignatura.setCreditos(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el numero de créditos")));
        asignatura.setTipo(JOptionPane.showInputDialog("Introduzca el tipo__Obligatoria,básica u optativa"));
        asignatura.setCurso(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el curso ")));
        asignatura.setCuatrimestre(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cuatrimestre del 1 al 3")));
        asignatura.setId_profesor(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Identificador del profesor")));
        asignatura.setId_grado(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Identificador del grado")));
    }

    public void InsertarAsignatura()  {


    introducirDatos();

        stmt = Connection.getStatement();


       try {

               int rs=stmt.executeUpdate("INSERT INTO asignatura (nombre,creditos,tipo,curso,cuatrimestre,id_profesor,id_grado) VALUES ( '"+asignatura.getNombre()+"',"+ asignatura.getCreditos()+",'"+asignatura.getTipo()+"',"
                       +asignatura.getCurso()+ "," +asignatura.getCuatrimestre()+","+asignatura.getId_profesor()+","+asignatura.getId_grado()+");");
                JOptionPane.showMessageDialog(vista,"Datos introducidos con éxito");



        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error en los datos");
        }


    }

    public void BorrarAsignatura() {
        asignatura.setId(Integer.parseInt(JOptionPane.showInputDialog("Inserte el numero de identificador a borrar")));
        stmt = Connection.getStatement();
        try {
            int rs=stmt.executeUpdate("DELETE FROM asignatura where id="+asignatura.getId()+";");
            JOptionPane.showMessageDialog(vista,"Datos borrados");





        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error en los datos");
        }

    }

    public void ModificarAsignatura() {

        asignatura.setId(Integer.parseInt(JOptionPane.showInputDialog("Inserte el numero de identificador a modificar")));
        introducirDatos();
        stmt = Connection.getStatement();

        try {
            int rs=stmt.executeUpdate("UPDATE asignatura SET nombre='" + asignatura.getNombre() + "',creditos='" + asignatura.getCreditos() + "',tipo='" + asignatura.getTipo() + "',curso='" + asignatura.getCurso()+ "',cuatrimestre='" + asignatura.getCuatrimestre()+"',id_profesor='"+ asignatura.getId_profesor()+"',id_grado='"+ asignatura.getId_grado()+ "' WHERE id = '" + asignatura.getId() + "';");

            JOptionPane.showMessageDialog(vista,"Datos modificados con éxito");



        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error de actualización");
        }


    }

    public DefaultTableModel CargaDatosBusqueda(DefaultTableModel m) {

        tipo=JOptionPane.showInputDialog(vista,"Introduzca el tipo a buscar ");

        String[] titulos = {"ID", "Nombre", "Créditos", "Tipo", "Curso", "Cuatrimestre", "Id Profesor", "Id Grado"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = Connection.getStatement();


            ResultSet rs = stmt.executeQuery("select * from asignatura where tipo ='"+tipo+"';");

            String[] fila = new String[8];

            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("creditos");
                fila[3] = rs.getString("tipo");
                fila[4] = rs.getString("curso");
                fila[5] = rs.getString("cuatrimestre");
                fila[6] = rs.getString("id_profesor");
                fila[7] = rs.getString("id_grado");
                m.addRow(fila);
            }
        } catch (SQLException e) {

        }
        return m;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
