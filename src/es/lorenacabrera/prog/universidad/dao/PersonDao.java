package es.lorenacabrera.prog.universidad.dao;

import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private Connection connection;

    public PersonDao() {
        this.connection = new Connection();
    }

    public List<Person> findAll() {
        String sql = "SELECT * from persona";
        List<Person> people = new ArrayList<>();

        Statement statement = this.connection.getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                people.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("nif"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getDate("fecha_nacimiento"),
                        resultSet.getString("sexo"),
                        resultSet.getString("tipo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public void insert(Person person) {
    }

    public void remove(Person person) {

    }

    public Person findById(Integer id) {
        return null;
    }
}
