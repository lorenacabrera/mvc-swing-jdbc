package model.com.company;

import Dtos.DtoPersonas;
import es.lorenacabrera.prog.universidad.db.Connection;
import view.com.company.DialogoPersonas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelPersonas implements KeyListener {
    String nombre;

    DialogoPersonas vista=new DialogoPersonas();
    DtoPersonas persona=new DtoPersonas();
    private Statement stmt;

    public ModelPersonas() {
        Connection.openConn();
    }

    public DefaultTableModel CargaDatos(DefaultTableModel m) {
        String[] titulos = {"ID","NIF", "Nombre", "Apellido1", "Apellido2", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = Connection.getStatement();
            ResultSet rs = stmt.executeQuery("select * from persona");
            String[] fila = new String[11];

            while (rs.next()) {
                fila[0]=rs.getString("id");
                fila[1] = rs.getString("nif");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido1");
                fila[4] = rs.getString("apellido2");
                fila[5] = rs.getString("ciudad");
                fila[6] = rs.getString("direccion");
                fila[7] = rs.getString("telefono");
                fila[8] = rs.getString("fecha_nacimiento");
                fila[9] = rs.getString("sexo");
                fila[10] = rs.getString("tipo");
                m.addRow(fila);
            }
        } catch (SQLException e) {

        }
        return m;
    }
    public void introducirDatos(){
        persona.setNif(JOptionPane.showInputDialog("Introduzca el NIF"));
        persona.setNombre(JOptionPane.showInputDialog("Introduzca el nombre"));
        persona.setApellido1(JOptionPane.showInputDialog("Introduzca el primer apellido "));
        persona.setApellido2(JOptionPane.showInputDialog("Introduzca el segundo apellido"));
        persona.setCiudad(JOptionPane.showInputDialog("Introduzca la ciudad"));
        persona.setDireccion(JOptionPane.showInputDialog("Introduzca la dirección"));
        persona.setTelefono(JOptionPane.showInputDialog("Introduzca el teléfono"));
        persona.setDate(JOptionPane.showInputDialog("Introduzca la fecha de nacimiento en el siguiente formato AAAA/MM/DD"));
        persona.setSexo(JOptionPane.showInputDialog("Introduzca el sexo H o M"));
        persona.setTipo(JOptionPane.showInputDialog("Introduzca el tipo profesor o alumno"));
    }


    public void InsertarPersona() {
        introducirDatos();
        stmt = Connection.getStatement();
        try {
            int rs=stmt.executeUpdate("INSERT INTO persona (nif,nombre,apellido1,apellido2,ciudad,direccion,telefono,fecha_nacimiento,sexo,tipo) VALUES ( '"+persona.getNif()+"','"+ persona.getNombre()+"','"+persona.getApellido1()+"','"
                    +persona.getApellido2()+ "','" +persona.getCiudad()+"','"+persona.getDireccion()+"','"+persona.getTelefono()+"','"+persona.getDate()+"','"+persona.getSexo()+"','"  +persona.getTipo()+"');");
            JOptionPane.showMessageDialog(vista,"Datos introducidos con éxito");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error en los datos");
        }
    }

    public void BorrarPersona() {
        persona.setId(Integer.parseInt(JOptionPane.showInputDialog("Inserte el numero de identificador a borrar")));
        stmt = Connection.getStatement();
        try {
            int rs=stmt.executeUpdate("DELETE FROM persona where id="+persona.getId()+";");
            JOptionPane.showMessageDialog(vista,"Datos borrados");




        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error en los datos");
        }

    }

    public void ModificarPersona() {
        persona.setId(Integer.parseInt(JOptionPane.showInputDialog("Inserte el numero de identificador a modificar")));
        introducirDatos();
        stmt = Connection.getStatement();

        try {
            int rs=stmt.executeUpdate("UPDATE persona SET nif='" + persona.getNif() + "',nombre='" + persona.getNombre() + "',apellido1='" + persona.getApellido1() + "',apellido2='" + persona.getApellido2()+ "',ciudad='" + persona.getCiudad()+"',direccion='"
                    + persona.getDireccion()+"',telefono='"+persona.getTelefono()+"',fecha_nacimiento='"+persona.getDate()+"',sexo='"+persona.getSexo()+"',tipo='"+ persona.getTipo()+ "' WHERE id = '" + persona.getId() + "';");

            JOptionPane.showMessageDialog(vista,"Datos modificados con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,"Error de actualización");
        }
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

    public String buscar() {
        nombre=JOptionPane.showInputDialog(vista,"Ingrese el nombre ");
        return nombre;
    }

    public DefaultTableModel CargaDatosBusqueda(DefaultTableModel m) {

        nombre=JOptionPane.showInputDialog(vista,"Ingrese el nombre a buscar ");

        String[] titulos = {"ID","NIF", "Nombre", "Apellido1", "Apellido2", "Ciudad", "Dirección", "Teléfono", "Fecha Nacimiento", "Sexo", "Tipo"};
        m = new DefaultTableModel(null, titulos);

        try {
            stmt = Connection.getStatement();
            ResultSet rs = stmt.executeQuery("select * from persona where nombre ='"+nombre+"';");
            String[] fila = new String[11];

            while (rs.next()) {
                fila[0]=rs.getString("id");
                fila[1] = rs.getString("nif");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("apellido1");
                fila[4] = rs.getString("apellido2");
                fila[5] = rs.getString("ciudad");
                fila[6] = rs.getString("direccion");
                fila[7] = rs.getString("telefono");
                fila[8] = rs.getString("fecha_nacimiento");
                fila[9] = rs.getString("sexo");
                fila[10] = rs.getString("tipo");
                m.addRow(fila);
            }
        } catch (SQLException e) {

        }
        return m;
    }
}
