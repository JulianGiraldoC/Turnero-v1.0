/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.List;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jusot
 */
@Entity
@Table(name = "Atendedor")
public class Atendedor implements Serializable {

    @Id
    private long ID;
    private String Nombre;
    private String Estado;
    private int NroAsesor;
    private int TipoServicios;
    private String NroPuesto;
    private String Fecha;
    
    public Atendedor(){
        
    }
    public Atendedor(long Identificacion, String Nombre, int NroAsesor, int Servicio, String NroPuesto){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        this.ID=Identificacion;
        this.Nombre=Nombre;
        this.Estado="Activo";
        this.NroAsesor=NroAsesor;
        this.TipoServicios=Servicio;
        this.NroPuesto=NroPuesto;
        this.Fecha=date.format(now);
    }
    public long getId(){
        return (long) ID;
    }
    public void setID(long i){
        ID=i;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String n){
        Nombre=n;
    }
    public void setEstado(String n){
        Estado=n;
    }
    public String getEstado(){
        return Estado;
    }
    public void setNroAsesor(int t){
        NroAsesor=t;
    }
    public int getNroAsesor(){
        return NroAsesor;
    }
    public void setTipoServicio(int p){
        TipoServicios=p;
    }
    public int getTipoServicio(){
        return TipoServicios;
    }
    public void setNroPuesto(String c){
        NroPuesto=c;
    }
    public String getNroPuesto(){
        return NroPuesto;
    }
    public String getFecha(){
        return Fecha;
    }
    public void actualizarEstado(String e){
        this.Estado=e;
    }
    public void modificarTipoServicios(int t){
        this.TipoServicios=t;
    }
    @Override
    public String toString() {
        return "Atendedor {"+ "Identificacion="  + ID + ",  Nombre="  + Nombre + ",  Estado="  + Estado + ",  Numero Asesor="  + NroAsesor + ",  Tipo Servicios="  + TipoServicios + ",  NumeroPuesto="  + NroPuesto + ",  Fecha="  + Fecha + '}';
    }
}
