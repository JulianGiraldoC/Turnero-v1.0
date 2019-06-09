/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Controlador.ClientesService;
import Modelo.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jusot
 */
public class MenuCliente {

    
    
public void MenuC(int p){
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
         System.out.println("\n\n TURNERO");
         System.out.println("*_________________________________________________________________________*");
         System.out.print ("\n MENU CLIENTES ");
         System.out.println ("\n 1. Agregar clientes para solicitar servicio.");
         System.out.println (" 2. Listar cola.");
         System.out.println (" 3. Consultar estado de cliente en la cola.");
         System.out.println (" 0. Regresar. ");

         System.out.print (" Seleccione Opcion: ");
         opcion2 = entrada.nextInt();
         System.out.println("*_________________________________________________________________________*");
         switch (opcion2)
         {
                  
           case 1: System.out.println("Cargando...");
                   agregarCliente(p);
                   break;
           case 2: System.out.println("Cargando...");
                   listarClientes();
                   break;
           case 3: System.out.println("Cargando...");
                   consultarCliente();
                   break;
           default: System.out.println("\nOpcion Invalida!");
          }
        } while (opcion2 != 0);
    }

       public void agregarCliente(int w){
        Scanner entrada = new Scanner (System.in);
        int opcion=0; int opcion1=0;
        ClientesService service = new ClientesService();
        int config=w;
        for (int turno=1; turno<=config; turno++){
        int d=config-turno;
        System.out.println("Cantidad de turnos del dia: "+config+" disponibles: "+d+"");
        System.out.println("*_____________________________________________________________________________*");
        System.out.print("Digite identificacion cliente con numero de turno "+turno+": ");
        long id= entrada.nextInt();
        String nd= entrada.nextLine();
        System.out.print("Digite Nombre Cliente con numero de turno "+turno+": ");
        String nombre= entrada.nextLine();
        System.out.print("Digite Apellido Cliente con numero de turno "+turno+": ");
        String apellido= entrada.nextLine();
        String servicio="";
        System.out.println("Servicios: ");
        System.out.println("\nAdelantar pago | Seleccione 1.");
        System.out.println("\nReclamo        | Seleccione 2.");
        System.out.println("\nConsulta       | Seleccione 3.");
        System.out.print("Seleccione servicio que solicita: ");
         opcion = entrada.nextInt();
         if (opcion==1)
             servicio="Adelantar pago";
         if (opcion==2)
             servicio="Reclamo";
         if (opcion==3)
             servicio="Consulta";
        String prioridad="";
        System.out.println("\nTercera edad       | Seleccione 1.");
        System.out.println("\nInvalido           | Seleccione 2.");
        System.out.println("\nOtra discapacidad  | Seleccione 3.");  
        System.out.println("\nNo tiene prioridad | Seleccione 4.");
        System.out.print("Seleccione si tiene prioridad: ");
         opcion1 = entrada.nextInt();
         if(opcion1==1)
             prioridad="Tercera edad";
         if (opcion1==2)
             prioridad="Invalido";
         if (opcion1==3)
             prioridad="Otra discapacidad";
         if (opcion1==4)
             prioridad="No tiene prioridad";
        System.out.println("*_____________________________________________________________________________*");

        System.out.println("\nGuardando cliente "+nombre+" con numero de turno "+turno+"");

        Cliente cliente = new Cliente(id, turno, nombre, apellido, servicio, prioridad, "no");
        service.guardarCliente(cliente);
        }
       }
       public void listarClientes(){
        ClientesService service = new ClientesService();
        System.out.println("*_____________________________________________________________________________*");
        System.out.println("Listando los clientes creados");
        List<Cliente> listarUsuarios = service.listarClientes();
        for (Cliente usuario : listarUsuarios) {
            System.out.println(usuario);
        }
       }
       public void consultarCliente(){
        ClientesService service = new ClientesService();
        Scanner entrada = new Scanner (System.in);
        System.out.println("*______________________________________________________________________________*");
        System.out.print("Digite el usuario que quiere consultar [ID]: ");
        long id= entrada.nextInt();
        Cliente cliente2 = service.consultarCliente(id);
        System.out.print("Nombre: "+cliente2.getNombre()+" |* ");
        System.out.print(" Apellido: "+cliente2.getApellido()+" |* ");
        System.out.print(" Atendido: "+cliente2.getAtendido()+" |* ");
        System.out.print(" Hora: "+cliente2.getHora()+" | ");
        
    }}

