/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo ThinkPad
 */
public class EspacioParqueo {
    
    private int id_Espacio;
    private boolean disponible;

    public EspacioParqueo(int id_Espacio, boolean disponible) {
        this.id_Espacio = id_Espacio;
        this.disponible = disponible;
    }

    public int getId_Espacio() {
        return id_Espacio;
    }

    public void setId_Espacio(int id_Espacio) {
        this.id_Espacio = id_Espacio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public boolean verificarDisponibilidad() {
        return disponible;
    }

    public void ocuparEspacio() {
        this.disponible = false;
    }

    public void liberarEspacio() {
        this.disponible = true;
    }

    public void mostrarDetalle() {
        String estadoTexto = disponible ? "DISPONIBLE" : "OCUPADO";
        String mensaje = "=== Reporte Espacio Parqueo ===\n" +
                         "Número de espacio: #" + id_Espacio + "\n" +
                         "Estado actual: " + estadoTexto;

        JOptionPane.showMessageDialog(null, mensaje);
    
}
}
