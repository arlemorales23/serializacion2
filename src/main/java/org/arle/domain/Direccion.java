package org.arle.domain;

import java.io.Serializable;

public class Direccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String calle;
    private String ciudad;

    public Direccion(String calle, String ciudad) {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    // Getters y setters
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    @Override
    public String toString() {
        return "Direccion{calle='" + calle + "', ciudad='" + ciudad + "'}";
    }
}
