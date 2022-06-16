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
        ResultSet resultSet;
        String sql = "SELECT * from persona";
        List<Person> people = new ArrayList<>();

        Statement statement = this.connection.getStatement();

        try {
            resultSet = statement.executeQuery(sql);

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

    public boolean insert(Person person) {
        boolean isSuccessful = false;
        Statement statement = Connection.getStatement();
        String command;

        if (person != null) {
            command = String.format(
                    "INSERT INTO persona (id, nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, sexo, tipo) values ('%d', '%s', '%s', '%s', '%s', '%s', '%s', '%F', '%s', '%s'",
                    person.getId(),
                    person.getNombre(),
                    person.getNif(),
                    person.getApellido1(),
                    person.getApellido2(),
                    person.getCiudad(),
                    person.getDireccion(),
                    person.getTelefono(),
                    person.getFechaNacimiento(),
                    person.getSexo(),
                    person.getTipo()
            );

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public boolean remove(Integer id) {
        boolean isSuccessful = false;
        Statement statement = Connection.getStatement();
        String command;

        if (findById(id) != null) {
            command = String.format("DELETE FROM persona WHERE %d", id);

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public boolean update(Person person) {
        boolean isSuccessful = false;
        String command;
        Person actualPerson;

        Statement statement = Connection.getStatement();
        actualPerson = findById(person.getId());

        if (actualPerson != null) {
            actualPerson.setNombre(person.getNombre());
            actualPerson.setApellido1(person.getApellido1());
            actualPerson.setApellido2(person.getApellido2());
            actualPerson.setNif(person.getNif());
            actualPerson.setCiudad(person.getCiudad());
            actualPerson.setDireccion(person.getDireccion());
            actualPerson.setTelefono(person.getTelefono());
            actualPerson.setFechaNacimiento(person.getFechaNacimiento());
            actualPerson.setSexo(person.getSexo());
            actualPerson.setTipo(person.getTipo());

            command = String.format(
                    "UPDATE persona SET nombre = '%s', apellido1 = '%s', apellido2 = '%s', nif = '%s', ciudad = '%s', direccion = '%s', telefono = '%s', fecha_nacimiento = '%F', sexo = '%s', tipo = '%s' WHERE id = %d",
                    actualPerson.getNombre(),
                    actualPerson.getApellido1(),
                    actualPerson.getApellido2(),
                    actualPerson.getNif(),
                    actualPerson.getCiudad(),
                    actualPerson.getDireccion(),
                    actualPerson.getTelefono(),
                    actualPerson.getFechaNacimiento(),
                    actualPerson.getSexo(),
                    actualPerson.getTipo()
            );

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public Person findById(Integer id) {
        String command;
        ResultSet resultSet;
        Person person = null;
        int i = 0;

        Statement statement = Connection.getStatement();

        if (id != null) {
            person = new Person();
            command = String.format("SELECT * FROM persona WHERE id = %d", id);

            try {
                resultSet = statement.executeQuery(command);

                while (resultSet.next() && i < 1) {
                    person.setId(resultSet.getInt("id"));
                    person.setNombre(resultSet.getString("nombre"));
                    person.setApellido1(resultSet.getString("apellido1"));
                    person.setApellido2(resultSet.getString("apellido2"));
                    person.setNif(resultSet.getString("nif"));
                    person.setCiudad(resultSet.getString("ciudad"));
                    person.setDireccion(resultSet.getString("direccion"));
                    person.setTelefono(resultSet.getString("telefono"));
                    person.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                    person.setSexo(resultSet.getString("sexo"));
                    person.setTipo(resultSet.getString("tipo"));

                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return person;
    }
}
