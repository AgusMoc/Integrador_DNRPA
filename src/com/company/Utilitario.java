package com.company;

import java.time.LocalDate;
import java.util.List;

public class Utilitario extends Automotor {


    public Utilitario(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados, LocalDate fecharegistro) {
        super(seccional, propietario, tipoUso, autorizados, fecharegistro);
    }
    public Utilitario(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados) {
        super(seccional, propietario, tipoUso, autorizados);
    }
}
