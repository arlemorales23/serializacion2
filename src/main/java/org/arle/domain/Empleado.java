package org.arle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private List<Direccion> direcciones;

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.direcciones = new ArrayList<>();
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Direccion> getDirecciones() { return direcciones; }
    public void setDirecciones(List<Direccion> direcciones) { this.direcciones = direcciones; }

    public void addDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', direcciones=" + direcciones + '}';
    }
}