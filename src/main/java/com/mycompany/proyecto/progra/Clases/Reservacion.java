/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import com.mycompany.proyecto.progra.Enum.Estado_Espacio;
import com.mycompany.proyecto.progra.Enum.Tipo_Dia;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ThinkPad
 */
public class Reservacion {
    
    private String id_Reservacion;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private Estado_Espacio estado_espacio;
    private String hora_entrada;
    private String hora_salida;
    private Tipo_Dia tipo_dia;
    private double monto_Total;
    private boolean activa;

    public Reservacion(String id_Reservacion, Usuario usuario, Vehiculo vehiculo, Estado_Espacio estado_espacio, String hora_entrada, String hora_salida, Tipo_Dia tipo_dia, double monto_Total, boolean activa) {
        this.id_Reservacion = id_Reservacion;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.estado_espacio = estado_espacio;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.tipo_dia = tipo_dia;
        this.monto_Total = monto_Total;
        this.activa = activa;
    }

    public String getId_Reservacion() {
        return id_Reservacion;
    }

    public void setId_Reservacion(String id_Reservacion) {
        this.id_Reservacion = id_Reservacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Estado_Espacio getEstado_espacio() {
        return estado_espacio;
    }

    public void setEstado_espacio(Estado_Espacio estado_espacio) {
        this.estado_espacio = estado_espacio;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Tipo_Dia getTipo_dia() {
        return tipo_dia;
    }

    public void setTipo_dia(Tipo_Dia tipo_dia) {
        this.tipo_dia = tipo_dia;
    }

    public double getMonto_Total() {
        return monto_Total;
    }

    public void setMonto_Total(double monto_Total) {
        this.monto_Total = monto_Total;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        String nombre_Usuario = null;
        if(usuario != null) {
            nombre_Usuario = vehiculo.getNombre();
            
        }
        
        String placa_Vehiculo = null;
        if (vehiculo != null) {
            placa_Vehiculo = vehiculo.getPlaca();
            
        }
        
        String id_Espacio = null;
        if(estado_espacio != )
        
        
        
        
        
    }

    
    
}
