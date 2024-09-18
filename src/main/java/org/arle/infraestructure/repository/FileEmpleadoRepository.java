package org.arle.infraestructure.repository;

import org.arle.domain.Empleado;
import org.arle.interfaces.EmpleadoRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileEmpleadoRepository implements EmpleadoRepository {
    private static final String FILE_NAME = "empleados.dat";

    @Override
    public void save(Empleado empleado) {
        List<Empleado> empleados = findAll();
        empleados.add(empleado);
        saveAll(empleados);
    }

    @Override
    public Empleado findById(int id) {
        return findAll().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Empleado> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void update(Empleado empleado) {
        List<Empleado> empleados = findAll();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                empleados.set(i, empleado);
                break;
            }
        }
        saveAll(empleados);
    }

    @Override
    public void delete(int id) {
        List<Empleado> empleados = findAll();
        empleados.removeIf(e -> e.getId() == id);
        saveAll(empleados);
    }

    private void saveAll(List<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
