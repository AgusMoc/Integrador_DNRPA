package com.company;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaDNRPA sis= new SistemaDNRPA();
        sis.personas.add(sis.pers1);
        sis.personas.add(sis.pers2);
        sis.personas.add(sis.pers3);
        sis.personas.add(sis.pers4);
        sis.personas.add(sis.pers5);

        sis.autorizadosAgus.add(sis.pers2);
        sis.autorizadosCarlitos.add(sis.pers3);
        sis.autorizadosPepe.add(sis.pers1);
        sis.autorizadosRicky.add(sis.pers1);
        sis.autorizadosNemo.add(sis.pers4);
        sis.autorizadosNemo.add(sis.pers1);

        sis.registros.add(sis.autito);
        sis.registros.add(sis.autito2);
        sis.registros.add(sis.tutu);
        sis.registros.add(sis.coche);
        sis.registros.add(sis.coche2);
//--------------------------------------------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("-------------------------------------------------------");
        System.out.println("Bienvenido al sistema de la DNRPA ");
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Opcion 1 - Listar todos los AUTOS registrados");
            System.out.println("2. Opcion 2 - Listar a todos los propietarios de CAMIONES(en orden alfabético)");
            System.out.println("3. Opcion 3 - Cambiar de propietario ");
            System.out.println("4. Opción 4 - Dar de alta un nuevo automotor");
            System.out.println("5. Opcion 5 - Consultar si pasó un año o más desde el registro o cambio de titular (por patente)");
            System.out.println("6. Opcion 6 - Listar todos los registos existentes");
            System.out.println("0. Opcion 0 - Salir");
            System.out.println("Escribe una de las opciones");
            System.out.println("-------------------------------------------------------");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Debe ingresar valores númericos");
                opcion = 99;
            }
            switch (opcion) {
                    case 1 -> {
                    System.out.println("Los autos registrados en la DNRPA son: ");
                    for (Automotor y : sis.registros)
                        if (y.getClass().equals(Auto.class)) System.out.println(y.listarRegistros());
                    }
                    case 2 -> {
                    System.out.println("Los propietarios de camiones registrados en la DNRPA son: ");
                    List<String> aux = new ArrayList<>();
                    for (Automotor y : sis.registros) {
                            if (y.getClass().equals(Camion.class)) aux.add(y.nombrePropietario());
                        }
                    Collections.sort(aux);
                    for (String x : aux) {
                        System.out.println(x);
                        }
                    }
                    case 3 -> {
                        System.out.println("Has seleccionado: Opción 3 - Cambiar propietario de un automotor");
                        sis.cambiarDueAutomotor();
                    }
                    case 4 -> {
                        System.out.println("Has seleccionado: Opción 4 - Dar de alta un nuevo automotor");
                        sis.ingresarAutomotor();
                    }
                    case 5 -> {
                        System.out.println("Indique la patente del automotor por el que quiere consultar");
                        Scanner scn = new Scanner(System.in);
                        String patBuscada = scn.nextLine();
                        for (Automotor y : sis.registros) {
                            if (patBuscada.equals(y.getPatente()))
                                y.consultaRegistro();
                        }
                    }
                    case 6 -> {
                        System.out.println("Los registros que figuran en la DNRPA son: ");
                        System.out.println("Automotores: ");
                        for(Automotor a : sis.registros){
                          System.out.println(a.listarRegistros());
                        }
                        System.out.println("Personas: ");
                        for(Persona p: sis.personas){
                           System.out.println(p.listarRegistros());
                        }
                        System.out.println("Info completa de todo: ");
                        sis.infoAutomotores();
                    }
                    default -> System.out.println("Solo números entre 1 y 6 para seleccionar opciones");
                }
        } while (opcion != 0);

  //TODO --> ver que más se puede hacer con interfaces que tenga sentido
    }}



