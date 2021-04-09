package com.company;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

public class Colectivo extends Automotor{

    public Colectivo(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados, LocalDate fecharegistro) {
        super(seccional, propietario, tipoUso, autorizados, fecharegistro);
    }
    public Colectivo(Seccional seccional, Persona propietario, TipoUso tipoUso, List<Persona> autorizados) {
        super(seccional, propietario, tipoUso, autorizados);
    }
 }
