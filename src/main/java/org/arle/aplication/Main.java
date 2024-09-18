package org.arle.aplication;

import org.arle.aplication.service.EmpleadoService;
import org.arle.infraestructure.repository.FileEmpleadoRepository;
import org.arle.interfaces.EmpleadoRepository;

public class Main {
    public static void main(String[] args) {
        EmpleadoRepository repository = new FileEmpleadoRepository();
        EmpleadoService service = new EmpleadoService(repository);
        ConsolaUI ui = new ConsolaUI(service);
        ui.iniciar();
    }
}