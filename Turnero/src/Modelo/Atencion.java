/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jusot
 */
    @Entity 
    @Table (name="Atencion") 
    public class Atencion implements Serializable {

    @Id
    private long IDCliente;
    private String NombreCliente;
    private String TipoServicioPrestado;
    private String Prioridad;
    private int NroAsesor;
    private String NombreAsesor;
    private String HoraInicio;
    private String HoraFinal;
    private int Duracion;
    private String Fecha;
    private int NroTurno;
    
    public Atencion(){
        
    }
    public Atencion(long Identificacion, String NombreClient, String ServicioPrest, String Prioridad, int NroAsesor, String NombreAsesor, String HoraI, int NroTurno){
    
    Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    this.IDCliente=Identificacion;
    this.NombreCliente=NombreClient;
    this.TipoServicioPrestado=ServicioPrest;
    this.Prioridad=Prioridad;
    this.NroAsesor=NroAsesor;
    this.NombreAsesor=NombreAsesor;
    this.HoraInicio=HoraI;
    this.HoraFinal=hour.format(now);
    this.Fecha=date.format(now);
    this.NroTurno=NroTurno;
     
    }
    public long getIdCliente(){
        return (long) IDCliente;
    }
    
    public void setIDCliente(long i){
        IDCliente=i;
    }
    public void setNombreCliente(String n){
        NombreCliente=n;
    }
    public String getNombreCliente(){
        return NombreCliente;
    }
    public void setNroAsesor(int t){
        NroAsesor=t;
    }
    public int getNroAsesor(){
        return NroAsesor;
    }
    public void setTipoServicioPrestado(String p){
        TipoServicioPrestado=p;
    }
    public String getTipoServicioPrestado(){
        return TipoServicioPrestado;
    }
    public void setPrioridad(String c){
        Prioridad=c;
    }
    public String getPrioridad(){
        return Prioridad;
    }
    public void setFecha(String f){
        Fecha=f;
    }
    public String getFecha(){
        return Fecha;
    }
    public void setNombreAsesor(String e){
        NombreAsesor=e;
    }
    public String getNombreAsesor(){
        return NombreAsesor;
    }
    public void setHoraInicio(String i){
        HoraInicio=i;
    }
    public String getHoraInicio(){
        return HoraInicio;
    }
    public void setHoraFinal(String i){
        HoraFinal=i;
    }
    public String getHoraFinal(){
        return HoraFinal;
    }
    public void setDuracion(int i){
        Duracion=i;
    }
    public int getDuracion(){
        return Duracion;
    }
    public void setNroTurno(int t){
        NroTurno=t;
    }
    public int getNroTurno(){
        return NroTurno;
    }
    @Override
    public String toString() {
        return "Atencion {"+ "Id cliente atendido="  + IDCliente + ",  Nombre Cliente atendido="  + NombreCliente + ",  Tipo Servicio prestado="  + TipoServicioPrestado + ",  Prioridad="  + Prioridad + ",  Numero Asesor que antendio="  + NroAsesor + ",  Nombre Asesor que atendio="  + NombreAsesor + ",  Hora inicio ingreso="  + HoraInicio + ",  Hora final antencion="  + HoraFinal + ",  Duracion atencion="  + Duracion + ",  Fecha antencion="  + Fecha + ",  Numero Turno antencion="  + NroTurno +'}';
    }
}
