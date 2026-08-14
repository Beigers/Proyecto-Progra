/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

/**
 *
 * @author Lenovo ThinkPad
 */
public class Vehiculo {
    
    private String placa;
    private String formaPago;
    private int tiempoEstadia;

    public Vehiculo(String pPlaca, String pFormaPago, int pTiempoEstadia) {
        placa = pPlaca;
        formaPago = pFormaPago;
        tiempoEstadia = pTiempoEstadia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String pPlaca) {
        placa = pPlaca;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String pFormaPago) {
        formaPago = pFormaPago;
    }

    public int getTiempoEstadia() {
        return tiempoEstadia;
    }

    public void setTiempoEstadia(int pTiempoEstadia) {
        tiempoEstadia = pTiempoEstadia;
    }

    public String mostrarDatos() {

        String datos = "Placa: " + placa
                + " - Forma de Pago: " + formaPago
                + " - Tiempo de Estadia: " + tiempoEstadia;

        return datos;
    }
}