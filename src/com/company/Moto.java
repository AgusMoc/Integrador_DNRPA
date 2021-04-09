package com.company;

import java.time.LocalDate;
import java.util.List;

public class Moto extends Automotor {

    public Moto(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados, LocalDate fecharegistro, Propulsion propulsion) {
        super(seccional, propietario, tipoUso, autorizados, fecharegistro, propulsion);
    }
    public Moto(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados, Propulsion propulsion) {
        super(seccional, propietario, tipoUso, autorizados, propulsion);
    }
}
