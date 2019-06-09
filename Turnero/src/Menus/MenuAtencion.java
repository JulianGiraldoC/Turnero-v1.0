/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Controlador.AtencionService;
import Controlador.AtendedorService;
import Controlador.ClientesService;
import Modelo.Atencion;
import Modelo.Atendedor;
import Modelo.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jusot
 */
public class MenuAtencion {
    public void MenuAt(){
        Scanner entrada = new Scanner (System.in);
       int opcion2=0;
       do {
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
         System.out.print("Fecha: ");
         System.out.println(date.format(now));
         System.out.print("Hora: ");
         System.out.println(hour.format(now));
         System.out.println("*_________________________________________________________________________*");
         System.out.println("\n\n TURNERO");
         System.out.print ("\n MENU CLIENTES ATENDIDOS ");
         System.out.println ("\n 1. Listar los clientes atendidos.");
         System.out.println (" 0. Regresar. ");

         System.out.print (" Seleccione Opcion: ");
         opcion2 = entrada.nextInt();
         System.out.println("*_________________________________________________________________________*");
         switch (opcion2)
         {
                  
           case 1: System.out.print("Cargando...");
                   listarAtendidos();
                   break;
           default: System.out.println("\nOpcion Invalida!");
          }
        } while (opcion2 != 0);
    }
       
       public void listarAtendidos(){
        AtencionService service = new AtencionService();
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("Fecha: ");
        System.out.println(date.format(now));
        System.out.print("Hora: ");
        System.out.println(hour.format(now));
        
        System.out.println("*_____________________________________________________________________________*");
        System.out.println("Listando las personas atendidas");
        List<Atencion> listarAtencion = service.listarAtenciones();
        for (Atencion atencion : listarAtencion) {
            System.out.println(atencion);
        }
        System.out.println("*______________________________________________________________________________*");
    }
    
}
