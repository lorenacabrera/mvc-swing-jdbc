package es.lorenacabrera.prog.universidad.model;

import java.math.BigDecimal;

public class Subject {
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer curso;
    private Integer custrimestre;
    private Integer profesorId;
    private Integer gradoId;
    private BigDecimal credito;

    public Subject() {
    }

    public Subject(String nombre, String tipo, Integer curso, Integer custrimestre, Integer profesorId, Integer gradoId, Integer id, BigDecimal credito) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.curso = curso;
        this.custrimestre = custrimestre;
        this.profesorId = profesorId;
        this.gradoId = gradoId;
        this.id = id;
        this.credito = credito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getCustrimestre() {
        return custrimestre;
    }

    public void setCustrimestre(Integer custrimestre) {
        this.custrimestre = custrimestre;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public Integer getGradoId() {
        return gradoId;
    }

    public void setGradoId(Integer gradoId) {
        this.gradoId = gradoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }
}
