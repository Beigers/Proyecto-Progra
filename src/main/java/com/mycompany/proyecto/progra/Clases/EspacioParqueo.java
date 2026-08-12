/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import com.mycompany.proyecto.progra.Enum.Estado_Espacio;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ThinkPad
 */
public class EspacioParqueo {
    
    private int id_Espacio;
    private Estado_Espacio disponibilidad;
    
    public EspacioParqueo(int id_Espacio) {
        this.id_Espacio = id_Espacio;
        this.disponibilidad = Estado_Espacio.LIBRE;
    }

    public EspacioParqueo(int id_Espacio, Estado_Espacio disponibilidad) {
        this.id_Espacio = id_Espacio;
        this.disponibilidad = disponibilidad;
    }

    public int getId_Espacio() {
        return id_Espacio;
    }

    public void setId_Espacio(int id_Espacio) {
        this.id_Espacio = id_Espacio;
    }

    public Estado_Espacio getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Estado_Espacio disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public boolean verificarDisponibilidad() {
        if (disponibilidad == Estado_Espacio.LIBRE) {
            return true;
        } else {
            return false;
        }
    }
    
    public void ocuparEspacio() {
        this.disponibilidad = Estado_Espacio.OCUPADO;
    }
    
    public void reservarEspacio() {
        this.disponibilidad = Estado_Espacio.RESERVADO;
    }
    
    public void liberarEspacio() {
        this.disponibilidad = Estado_Espacio.LIBRE;
    }
    
    public void mostrarDetalle() {
        String estadoTexto;

        if (disponibilidad == Estado_Espacio.LIBRE) {
            estadoTexto = "LIBRE";
        } else if (disponibilidad == Estado_Espacio.OCUPADO) {
            estadoTexto = "OCUPADO";
        } else {
            estadoTexto = "RESERVADO";
        }

        String mensaje = "=== REPORTE DEL ESPACIO DE PARQUEO === \n" +
                         "Número de espacio: #" + id_Espacio + "\n" +
                         "Estado actual: " + estadoTexto;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}