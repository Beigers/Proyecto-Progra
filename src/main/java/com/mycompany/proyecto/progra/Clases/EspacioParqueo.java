/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

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
    
    
    
}
