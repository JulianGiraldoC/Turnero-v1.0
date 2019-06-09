/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Controlador.AtendedorService;
import Controlador.ClientesService;
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
public class MenuAtendedor {
    
    public void MenuA(int p){
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
         System.out.print ("\n MENU ATENDEDORES ");
         System.out.println ("\n 1. Agregar atendedores.");
         System.out.println (" 2. Listado de clientes por atender.");
         System.out.println (" 3. Atender un cliente.");
         System.out.println (" 0. Regresar. ");

         System.out.print (" Seleccione Opcion: ");
         opcion2 = entrada.nextInt();
         System.out.println("*_________________________________________________________________________*");
         switch (opcion2)
         {
                  
           case 1: System.out.println("Cargando...");
                   agregarAtendedor(p);
                   break;
           case 2: System.out.println("Cargando...");
                   clientesAtender();
                   break;
           case 3: System.out.println("Cargando...");
                   atenderCliente();
                   break;
           default: System.out.println("\nOpcion Invalida!");
          }
        } while (opcion2 != 0);
    }
    public void agregarAtendedor(int p){
        Scanner entrada = new Scanner (System.in);
        int opcion=0; int opcion1=0;
        AtendedorService service = new AtendedorService();
        ClientesService service1= new ClientesService();
        int config=p;
        for (int cantidadA=1; cantidadA<=config; cantidadA++){
        int d=config-cantidadA;
        System.out.println("Cantidad de puestos "+config+", disponibles "+d+"");
        System.out.println("*_____________________________________________________________________________*");
        System.out.print("Digite identificacion atendedor: ");
        long id= entrada.nextInt();
        String nd= entrada.nextLine();
        System.out.print("Digite nombre atendedor: ");
        String nombre= entrada.nextLine();
        System.out.print("Digite cantidad servicios que ofece [1] [12] [123] : ");
        int servicios= entrada.nextInt();
        String ndd= entrada.nextLine();
        System.out.print("Digite numero de puesto que ocupa / [disponibles "+d+"] : ");
        String nro= entrada.nextLine();
        System.out.println("*_____________________________________________________________________________*");

        System.out.println("\nGuardando atendedor "+nombre+"");

        Atendedor atendedor = new Atendedor(id, nombre, (int) id, servicios, nro);
        service.guardarAtendedor(atendedor);
        System.out.println("Se ha guardado correctamente el atendedor");
        }
        System.out.println("*_____________________________________________________________________________*");
        System.out.println("Listando los atendedores creados");
        List<Atendedor> listarAtendedor = service.listarAtendedores();
        for (Atendedor atendedor : listarAtendedor) {
            System.out.println(atendedor);
        }
    }
        public void clientesAtender(){
        ClientesService service1= new ClientesService();
        System.out.println("*______________________________________________________________________________*");
        System.out.println("Listando los clientes por atender");
        List<Cliente> listarUsuarios = service1.listarClientes();
        for (Cliente usuario : listarUsuarios) {
            System.out.println(usuario);
        }
        }
        public void atenderCliente(){
        Scanner entrada = new Scanner (System.in);
        AtendedorService service = new AtendedorService();
        System.out.print("Digite el cliente que quiere atender [ID]: ");
        long c= entrada.nextInt();
        System.out.print("Digite su ID señor atendedor: ");
        long d= entrada.nextInt();
        service.clienteAtendido(c, d);
        System.out.println("Se ha atendido la persona correctamente.");
        System.out.println("*_____________________________________________________________________________*");
}
}
    

