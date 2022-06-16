package es.lorenacabrera.prog.universidad.dao;

import es.lorenacabrera.prog.universidad.db.Connection;
import es.lorenacabrera.prog.universidad.model.Subject;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public List<Subject> findAll() {
        String command = "SELECT * FROM asignatura";
        ResultSet resultSet;
        List<Subject> subjects = new ArrayList();
        Subject subject;

        Statement statement = Connection.getStatement();

        try {
            resultSet = statement.executeQuery(command);

            while (resultSet.next()) {
                subject = new Subject();

                subject.setId(resultSet.getInt("id"));
                subject.setNombre(resultSet.getString("nombre"));
                subject.setCredito(BigDecimal.valueOf(resultSet.getDouble("creditos")));
                subject.setTipo(resultSet.getString("tipo"));
                subject.setCurso(resultSet.getInt("curso"));
                subject.setCustrimestre(resultSet.getInt("cuatrimestre"));
                subject.setProfesorId(resultSet.getInt("id_profesor"));
                subject.setGradoId(resultSet.getInt("grado_id"));

                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }

    public boolean insert(Subject subject) {
        boolean isSuccessful = false;
        Statement statement = Connection.getStatement();
        String command;

        if (subject != null) {
            command = String.format(
                    "INSERT INTO asignatura (id, nombre, creditos, tipo, curso, cuatrimestre, id_profesor, id_grado) values (%d, '%s', %f, '%s', %d, %d, %d, %d)",
                    subject.getId(),
                    subject.getNombre(),
                    subject.getCredito(),
                    subject.getTipo(),
                    subject.getCurso(),
                    subject.getCustrimestre(),
                    subject.getProfesorId(),
                    subject.getGradoId()
            );

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public boolean remove(Subject subject) {
        boolean isSuccessful = false;
        Statement statement = Connection.getStatement();
        String command;

        if (subject != null) {
            command = String.format("DELETE FROM asignatura WHERE %d", subject.getId());

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public boolean update(Subject subject) {
        boolean isSuccessful = false;
        String command;
        ResultSet resultSet;
        Subject actualSubject;

        Statement statement = Connection.getStatement();
        actualSubject = findById(subject.getId());

        if (actualSubject != null) {
            actualSubject.setCredito(subject.getCredito());
            actualSubject.setCurso(subject.getCurso());
            actualSubject.setNombre(subject.getNombre());
            actualSubject.setGradoId(subject.getGradoId());
            actualSubject.setProfesorId(subject.getProfesorId());
            actualSubject.setTipo(subject.getTipo());
            actualSubject.setCredito(subject.getCredito());

            command = String.format(
                "UPDATE asignatura SET nombre = '%s', curso = %d, creditos = %d, tipo = '%s', cuatrimestre = %d, id_profesor = %d, id_grado = %d WHERE id = %d",
                actualSubject.getNombre(),
                actualSubject.getCurso(),
                actualSubject.getCredito(),
                actualSubject.getTipo(),
                actualSubject.getCustrimestre(),
                actualSubject.getProfesorId(),
                actualSubject.getGradoId()
            );

            try {
                isSuccessful = statement.executeUpdate(command) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccessful;
    }

    public Subject findById(Integer id) {
        String command;
        ResultSet resultSet;
        Subject subject = null;
        int i = 0;

        Statement statement = Connection.getStatement();

        if (id != null) {
            subject = new Subject();
            command = String.format("SELECT * FROM asignatura WHERE id = %d", id);

            try {
                resultSet = statement.executeQuery(command);

                while (resultSet.next() && i < 1) {
                    subject.setId(resultSet.getInt("id"));
                    subject.setNombre(resultSet.getString("nombre"));
                    subject.setCredito(BigDecimal.valueOf(resultSet.getDouble("creditos")));
                    subject.setTipo(resultSet.getString("tipo"));
                    subject.setCurso(resultSet.getInt("curso"));
                    subject.setCustrimestre(resultSet.getInt("cuatrimestre"));
                    subject.setProfesorId(resultSet.getInt("id_profesor"));
                    subject.setGradoId(resultSet.getInt("id_grado"));

                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return subject;
    }
}
