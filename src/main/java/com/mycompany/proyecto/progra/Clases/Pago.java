/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import com.mycompany.proyecto.progra.Enum.Metodo_Pago;

/**
 *
 * @author Lenovo ThinkPad
 */
public class Pago {
    
    private String placa;
    private double montoBase;
    private double iva;
    private double total;
    private Metodo_Pago metodoPago;

    public Pago(String placa, double montoBase, Metodo_Pago metodoPago) {
        this.placa = placa;
        this.montoBase = montoBase;
        this.iva = this.montoBase * 0.13;
        this.total = this.montoBase + this.iva;
        this.metodoPago = metodoPago;
    }
     public double getTotal() {
         return this.total;
     }
    public String generarFactura() {
        String factura = "_______________________________ \n"
                        +"           FACTURA                " + "\n"
                        +"________________________________ \n"
                        + "Placa : " + this.placa + "\n"
                        + "Metodo Pago : " + this.metodoPago + "\n"
                        + "IVA (13%) : " + this.iva + "\n"
                        + "_______________________________ \n"
                        + "Total : " + this.total + "\n"
                        + "________________________________";
        return factura; 
    } 
}
