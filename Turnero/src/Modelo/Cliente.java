/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JulianGiraldo
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    private long ID;
    private int NroTurno;
    private String Nombre;
    private String Apellido;
    private String TipoServicio;
    private String Prioridad;
    private String Hora;
    private String Atendido;

    public Cliente() {
    }

    public Cliente(long Identificacion, int NroTurno, String Nombre, String Apellido, String TipoServicio, String Prioridad, String Atendido){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        this.ID=Identificacion;
        this.NroTurno=NroTurno;
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.TipoServicio=TipoServicio;
        this.Prioridad=Prioridad;
        this.Atendido=Atendido;
        this.Hora=(hour.format(now));
    }

    public long getID() {
        return ID;
    }

    public void setID(Long i){
        ID=i;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String n){
        Nombre=n;
    }
    public String getApellido(){
        return Apellido;
    }
    public void setApellido(String a){
        Apellido=a;
    }
    public void setNroTurno(int n){
        NroTurno=n;
    }
    public int getNroTurno(){
        return NroTurno;
    }
    public void setTipoSevicio(String t){
        TipoServicio=t;
    }
    public String getTipoServicio(){
        return TipoServicio;
    }
    public void setPrioridad(String p){
        Prioridad=p;
    }
    public String getPrioridad(){
        return Prioridad;
    }
    public void setAtendido(String a){
        Atendido=a;
    }
    public String getAtendido(){
        return Atendido;
    }
    public void modificarServicio(String s){
        this.TipoServicio=s;
    }
    public void actualizarAtendido(String a){
        this.Atendido=a;
    }
    public String getHora(){
        return Hora;
    }
    @Override
    public String toString() {
        return "Cliente {"+ "Identificacion="  + ID + ",  Numero Turno="  + NroTurno + ",  Nombre="  + Nombre + ",  Apellido="  + Apellido + ",  Tipo Servicio="  + TipoServicio + ",  Prioridad="  + Prioridad + ",  Atendido="  + Atendido + ", Hora=" + Hora + '}';
    }
}
