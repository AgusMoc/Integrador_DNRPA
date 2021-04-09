package com.company;

import java.time.LocalDate;
import java.util.*;

public class Automotor implements Registros, NombresSimples{

    Scanner sc = new Scanner(System.in);

    protected Persona propietario;
    protected List<Persona> autorizados;
    protected Seccional seccional;
    protected TipoUso tipoUso;
    protected String patente;
    protected LocalDate fecharegistro;
    protected LocalDate fechaCambioDueño;
    protected Propulsion propulsion;

    public Automotor(Seccional seccional, Persona propietario,TipoUso tipoUso,List<Persona> autorizados, LocalDate fecharegistro) {
        this.patente = generarPatente();
        this.autorizados = autorizados;
        this.seccional = seccional;
        this.tipoUso = tipoUso;
        this.propietario = propietario;
        this.fecharegistro = fecharegistro;
        this.fechaCambioDueño = fecharegistro;
    }
    public Automotor(Seccional seccional, Persona propietario,TipoUso tipoUso,List<Persona> autorizados, LocalDate fecharegistro, Propulsion propulsion) {
        this.patente = generarPatente();
        this.autorizados = autorizados;
        this.seccional = seccional;
        this.tipoUso = tipoUso;
        this.propietario = propietario;
        this.fecharegistro = fecharegistro;
        this.fechaCambioDueño = fecharegistro;
        this.propulsion = propulsion;
    }
    public Automotor(Seccional seccional, Persona propietario,TipoUso tipoUso,List<Persona> autorizados, Propulsion propulsion) {
        this.patente = generarPatente();
        this.autorizados = autorizados;
        this.seccional = seccional;
        this.tipoUso = tipoUso;
        this.propietario = propietario;
        this.fecharegistro = fecharegistro;
        this.fechaCambioDueño = fecharegistro;
        this.propulsion = propulsion;
    }
    public Automotor(Seccional seccional, Persona propietario,TipoUso tipoUso,List<Persona> autorizados) {
        this.patente = generarPatente();
        this.autorizados = autorizados;
        this.seccional = seccional;
        this.tipoUso = tipoUso;
        this.propietario = propietario;
        this.fecharegistro = LocalDate.now();
        this.fechaCambioDueño = fecharegistro;
    }
    public Persona getPropietario() {
        return propietario;
    }
    public String nombrePropietario(){
        return getPropietario().getNombre();
    }
    public List<Persona> getAutorizados() {
        return autorizados;
    }
    public Seccional getSeccional() {
        return seccional;
    }
    public Propulsion getPropulsion() {
        return propulsion;
    }
    public String getPatente() {
        return patente;
    }
    public TipoUso getTipoUso() {
        return tipoUso;
    }

    //para ver si lleva + de x tiempo registrado el dueño
    public void consultaRegistro (){
        if (LocalDate.now().isAfter(fechaCambioDueño.plusDays(365)))
            System.out.println("Pasó más de un año desde que se registro un cambio");
        else System.out.println("Ha pasado menos de un año desde que se registro un cambio");
    }
    //cambio el propietario sii el ultimo cambio se registro hace más de un año
    public void cambiarDueño(Persona nuevoDueño){
        if (LocalDate.now().isAfter(fechaCambioDueño.plusDays(365)) ){
        propietario = nuevoDueño;
        fechaCambioDueño = LocalDate.now();
        }
        else{
            System.out.println("No se puede realizar el cambio si no pasan al menos de un año desde el ultimo cambio");
        }
    }
    //Genero patentes aleatorias que solo se asignan cuando se inscribe un nuevo automotor
    public String generarPatente() {
        Set patentes = new HashSet();
        int generado = 1;
        String matricula = "";
        do {
            Random rnd = new Random();
            for (int i = 0; i < 6; i++) {
                if (i < 3)
                    matricula += (char) (rnd.nextInt(26) + 65);
                 else
                    matricula += rnd.nextInt(10);
            }
            if (!patentes.contains(matricula))
                patentes.add(matricula);
                generado = 0;
        } while (generado == 1);
        return matricula;
    }
    //Listo registros (esto fue solo para darle un uso a las interfaces...
    @Override
    public String listarRegistros() {
        return "Automotor de uso "+ tipoUso+ " de patente " + patente +" perteneciente a "+ propietario.getNombre();
    }
}


