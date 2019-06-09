/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jusot
 */
public class MenuPrincipal {
    

  
    public static void menuPrincipal ()  throws IOException
    {
       Scanner entrada = new Scanner (System.in);
       String pass="admin";
        MenuAtendedor MenuA = new MenuAtendedor();
        MenuCliente menuC = new MenuCliente();
        MenuAtencion MenuAt= new MenuAtencion();
       int opcion=0; int intentos=1;
       System.out.print("Digite contraseña para iniciar sistema: ");
       String k=entrada.nextLine();
       System.out.println("...");
       if (k == null ? pass == null : k.equals(pass)){
           System.out.println("Ha iniciado sesion correctamente.");
           System.out.println("...");
           System.out.println("*_____________________________________________________________________*");
           System.out.println("CONFIGURACION INICIAL SISTEMA.");
           System.out.print("Indique cantidad de turnos disponibles en el dia: ");
           int d= entrada.nextInt();
           System.out.print("Indique cantidad de puestos disponibles: ");
           int e= entrada.nextInt();
           System.out.println("*_____________________________________________________________________*");

       do {
         System.out.println("\n\n Julian Giraldo Cardona");
         System.out.println("*_____________________________________________________________________*");
         System.out.print ("\n MENU PRINCIPAL DE OPCIONES TURNERO ");
         System.out.println ("\n 1. Menu clientes.");
         System.out.println (" 2. Menu atendedores.");
         System.out.println (" 3. Menu de clientes atendidos.");
         System.out.println (" 0. Salir del programa. ");

         System.out.print (" Seleccione Opcion: ");
         opcion = entrada.nextInt();
         System.out.println("*_____________________________________________________________________*");
         switch (opcion)
         {
                  
           case 1: System.out.println("Cargando...");
                   menuC.MenuC(d);
                   break;
           case 2: System.out.println("Cargando...");
                   MenuA.MenuA(e);
                   break;
           case 3: System.out.println("Cargando...");
                   MenuAt.MenuAt();
                   break;
           case 0: System.out.println("\n\nHa cerrado el sistema correctamente.\n");
                   break;
           default: System.out.println("\nOpcion invalida!");
          }
        } while (opcion != 0);
    }
       if (k == null ? pass != null : !k.equals(pass)){  
       System.out.println("Contraseña Incorrecta");
       System.out.println("");
       }
}}

