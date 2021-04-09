package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDNRPA {

    Scanner sc = new Scanner(System.in);

    public SistemaDNRPA() {
    }

    private List<Automotor> automotores;
    List<Persona> personas = new ArrayList<>();
    List<Automotor> registros = new ArrayList<>();

    //--------------------------BBDD PERSONAS Y AUTOMOTORES-------------------------------------
    Persona pers1 = new Persona("Carlitos", "1234", "Pampa y la vía");
    Persona pers2 = new Persona("Nemo", "5678", "Calle Wallaby 42 Sidney");
    Persona pers3 = new Persona("Agus", "1111", "Mi casa");
    Persona pers4 = new Persona("Pepe", "1122", "Florida");
    Persona pers5 = new Persona("Ricky", "666", "Miameeee");

    List<Persona> autorizadosCarlitos = new ArrayList<>();
    List<Persona> autorizadosNemo = new ArrayList<>();
    List<Persona> autorizadosAgus = new ArrayList<>();
    List<Persona> autorizadosPepe = new ArrayList<>();
    List<Persona> autorizadosRicky = new ArrayList<>();

    Auto autito = new Auto(Seccional.NRO1, pers1, TipoUso.PARTICULAR, autorizadosAgus, LocalDate.of(2019, 02, 15),Propulsion.COMBUSTION);
    Camion coche = new Camion(Seccional.NRO1, pers2, TipoUso.PROFESIONAL, autorizadosNemo, LocalDate.of(2018, 02, 14));
    Auto autito2 = new Auto(Seccional.NRO1, pers3, TipoUso.PARTICULAR, autorizadosAgus, LocalDate.of(2015, 11, 14),Propulsion.ELECTRICA);
    Moto coche2 = new Moto(Seccional.NRO1, pers4, TipoUso.PROFESIONAL, autorizadosPepe, LocalDate.of(2006, 05, 06),Propulsion.COMBUSTION);
    Camion tutu = new Camion(Seccional.NRO2, pers5,TipoUso.PARTICULAR, autorizadosRicky, LocalDate.of(2001, 12, 05));

//------------------------------------------FIN BBDD-------------------------------------------------------------

    //Antes de ingresar una persona siempre valido que ya no exista en la lista de personas (para no repetir). Si no existe la ingreso.
    public Persona buscarPersonaXDni(String dni) {
        Persona perBuscada = null;
        for (Persona persona : personas) {
            if (dni.equals(persona.getDni())) perBuscada = persona;
        }
        return perBuscada;
    }
    public Persona ingresarPersonaSINOexisteDNI() {
        System.out.println("Ingrese el dni: ");
        String dni = sc.nextLine();
        Persona nuevaPersona = buscarPersonaXDni(dni);
        if (nuevaPersona == null) {
            System.out.println("No hay persona registrada con ese DNI, por favor, proceda a ingresarla");
            System.out.println("Ingrese el nombre");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la dirección");
            String direccion = sc.nextLine();
            nuevaPersona = new Persona(nombre, dni, direccion);
            personas.add(nuevaPersona);
        }
        return nuevaPersona;
    }
//Antes de hacer un cambio de propietario reviso si la patente del automotor que quiero cambiar existe
    public Automotor buscarAutomotorPorPatente() {
        System.out.println("Ingrese la patente del automotor que quiere ver");
        String patBuscada2 = sc.nextLine();
        Automotor buscado = null;
        int op1 = 0;
        for (Automotor registro : registros) {
            if (patBuscada2.equals(registro.getPatente())) {
                buscado = registro;
                op1 = 1;
            }
        }
        if (op1 == 1) System.out.println("Se trata del automotor de : " + buscado.getPropietario().getNombre());
        else System.out.println("No se encontro automotor registrado con esa patente");
        return buscado;
    }
    //Ingreso según la clase el automotor que quiero. Validando las personas y eligiendo seccional, uso y propulsión de unos enums
    public void ingresarAutomotor() {
        System.out.println("Selecciones que tipo de automotor quiere ingresar: 1-AUTO; 2-MOTO; 3-CAMION; 4-COLECTIVO; 5-UTILITARIO ; 0-SALIR");
        int op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1 -> registros.add(new Auto(elegirSeccional(), ingresarPersonaSINOexisteDNI(), elegirTipoUso(),autorizados(), elegirPropulsion()));
            case 2 -> registros.add(new Moto(elegirSeccional(), ingresarPersonaSINOexisteDNI(), elegirTipoUso(),autorizados(),elegirPropulsion()));
            case 3 -> registros.add(new Camion(elegirSeccional(), ingresarPersonaSINOexisteDNI(), elegirTipoUso(),autorizados()));
            case 4 -> registros.add(new Colectivo(elegirSeccional(), ingresarPersonaSINOexisteDNI(), elegirTipoUso(),autorizados()));
            case 5 -> registros.add(new Utilitario(elegirSeccional(), ingresarPersonaSINOexisteDNI(), elegirTipoUso(),autorizados()));
            case 0 -> System.out.println("No se ha registrado nada");
            default -> System.out.println("Ingrese una de las opciones dadas");
        }
    }
    //Si encuentro el automotor puedo cambiar de dueño.Y si el propietario ya estaba registrado basta con ingresar el dni
    public void cambiarDueAutomotor() {
        Automotor automotorAmodificar = buscarAutomotorPorPatente();
        if (automotorAmodificar == null)
            System.out.println("No se puede cambiar de dueño porque no se encontro el automotor");
        else {
            System.out.println("Vamos a registrar el cambio, facilite los datos del nuevo propierario");
            automotorAmodificar.cambiarDueño(ingresarPersonaSINOexisteDNI());
        }
    }
    //Elijo propulsión, tipo de uso y seccional a partir de enums. (Atrapa excepción si me ingresan letras en lugar de números --> repito código..se puede mejorar)
    public Propulsion elegirPropulsion() {
        Propulsion propulsion = null;
        do {
            int seleccion = 99;
            System.out.println("Seleccione el tipo de propulsion que quiere ingresar: 1-COMBUSTION ; 2-ELECTRICA");
            try {
                seleccion = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                seleccion = 99;
            }
            if (seleccion == 1) propulsion = Propulsion.COMBUSTION;
            if (seleccion == 2) propulsion = Propulsion.ELECTRICA;
        } while (propulsion == null);
        return propulsion;
    }
    public TipoUso elegirTipoUso() {
        TipoUso uso = null;
        do {
            int seleccion = 99;
            System.out.println("Seleccione el tipo de uso que quiere ingresar: 1-PARTICULAR ; 2-PROFESIONAL");
            try {
                seleccion = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                seleccion = 99;
            }
            if (seleccion == 1) uso = TipoUso.PARTICULAR;
            if (seleccion == 2) uso = TipoUso.PROFESIONAL;
        } while (uso == null);
        return uso;
    }
    public Seccional elegirSeccional() {
        Seccional seccional = null;
        do {
            int seleccion = 99;
            System.out.println("Seleccione la seccional que quiere ingresar: 1-NRO1 ; 2-NRO2 ; 3-NRO3");
            try {
                seleccion = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                seleccion = 99;
            }
                if (seleccion == 1) seccional = Seccional.NRO1;
                if (seleccion == 2) seccional = Seccional.NRO2;
                if (seleccion == 3) seccional = Seccional.NRO3;
        } while (seccional == null);
        return seccional;
    }
    //Puedo agregar autorizados a conducir que se asignan a una lista a ese automotor. Si el dni ya esta registrado basta con escribirlo.
    public List<Persona> autorizados() {
        List<Persona> autorizados = new ArrayList<>();
        System.out.println("¿Desea agreagar autorizados a conducir? Ingrese 1 asignar autorizados, 0 para salir");
        int op;
        try {
            op = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            op =99;
            System.out.println("No se registron autorizados.");
        }
        if (op == 1) {
            do {
                Persona nuevoAutorizado = ingresarPersonaSINOexisteDNI();
                autorizados.add(nuevoAutorizado);
                System.out.println("Seleccione 1-Agregar otro autorizado ; 0 - Finalizar");
                op = Integer.parseInt(sc.nextLine());
            } while (op != 0);
        }
        return autorizados;
    }
    //Info bien completa de los automotores.
    public void infoAutomotores() {
        for (Automotor r : registros) {
            String registro;
            if (r.getClass().equals(Auto.class)||r.getClass().equals(Moto.class)) {
                 registro ="Registro de seccional " + r.getSeccional() + " de un " + r.getNombre() + " de patente " + r.getPatente() +" de uso "+r.getTipoUso()+ ", perteneciente a " + r.getPropietario().getNombre() + " de propulsión " + r.getPropulsion();
            }
            else registro = "Registro de seccional " + r.getSeccional() + " de un " + r.getNombre() + " de patente " + r.getPatente() +" de uso "+r.getTipoUso()+ ", perteneciente a " + r.getPropietario().getNombre();

            if (r.getAutorizados() != null){
                registro = registro + ". Con los siguientes autorizados a conducirlo: ";
                for (int i = 0; i<r.getAutorizados().size(); i++){
                registro = registro + r.getAutorizados().get(i).getNombre()+", ";
                }}
            System.out.println(registro);
            }

    }
}