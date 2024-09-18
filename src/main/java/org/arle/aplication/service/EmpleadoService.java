package org.arle.aplication.service;


import org.arle.domain.Empleado;
import org.arle.interfaces.EmpleadoRepository;

import java.util.List;

public class EmpleadoService {
    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public void crearEmpleado(Empleado empleado) {
        repository.save(empleado);
    }

    public Empleado obtenerEmpleado(int id) {
        return repository.findById(id);
    }

    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }

    public void actualizarEmpleado(Empleado empleado) {
        repository.update(empleado);
    }

    public void eliminarEmpleado(int id) {
        repository.delete(id);
    }
}