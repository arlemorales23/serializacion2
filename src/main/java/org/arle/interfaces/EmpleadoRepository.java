package org.arle.interfaces;

import org.arle.domain.Empleado;

import java.util.List;

public interface EmpleadoRepository {
    void save(Empleado empleado);
    Empleado findById(int id);
    List<Empleado> findAll();
    void update(Empleado empleado);
    void delete(int id);
}
