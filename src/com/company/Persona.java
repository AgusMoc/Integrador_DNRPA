package com.company;

import java.util.zip.DataFormatException;

public class Persona implements Registros{
/*
Todos los vehículos tienen un único propietario y autorizados a conducir.
De los propietarios y autorizados se sabe el nombre, DNI y dirección.
*/
    protected String nombre;
    protected String dni;
    protected String direccion;

    public Persona(String nombre, String dni, String direccion) throws RuntimeException {
        this.nombre = nombre;
        this.direccion = direccion;
        if(Utilitaria.validarDNI(dni))
            this.dni = dni;
        else
            throw new RuntimeException();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setDni(String dni) throws RuntimeException {
        if(Utilitaria.validarDNI(dni))
            this.dni = dni;
        else
            throw new RuntimeException();
    }
    //Listo registros .. funcionalidad solo implementada para usar interfaces
    @Override
    public String listarRegistros() {
        return "Se encuentra registrado con el DNI "+ dni+" , "+ nombre + " con dirección en: "+ direccion;
    }
}
