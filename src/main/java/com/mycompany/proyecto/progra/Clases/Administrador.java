/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import com.mycompany.proyecto.progra.Enum.Rol_Usuario;

public class Administrador {

    private String nombre;
    private String correo;
    private String contrasena;
    private Rol_Usuario rol;
    private double tarifaSemana;
    private double tarifaFinSemana;

    public Administrador(String pNombre, String pCorreo,
        String pContrasena, Rol_Usuario pRol,
        double pTarifaSemana, double pTarifaFinSemana) {
        
        nombre = pNombre;
        correo = pCorreo;
        contrasena = pContrasena;
        rol = pRol;
        tarifaSemana = pTarifaSemana;
        tarifaFinSemana = pTarifaFinSemana;
    }

    public Administrador(String pNombre, String pCorreo) {

        nombre = pNombre;
        correo = pCorreo;
        rol = Rol_Usuario.ADMINISTRADOR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String pCorreo) {
        correo = pCorreo;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String pContrasena) {
        contrasena = pContrasena;
    }

    public Rol_Usuario getRol() {
        return rol;
    }

    public void setRol(Rol_Usuario pRol) {
        rol = pRol;
    }

    public double getTarifaSemana() {
        return tarifaSemana;
    }

    public void setTarifaSemana(double pTarifaSemana) {
        tarifaSemana = pTarifaSemana;
    }

    public double getTarifaFinSemana() {
        return tarifaFinSemana;
    }

    public void setTarifaFinSemana(double pTarifaFinSemana) {
        tarifaFinSemana = pTarifaFinSemana;
    }

    public void gestionarEspacios() {
        System.out.println("Espacios gestionados.");
    }

    public void revisarReportes() {
        System.out.println("Reportes revisados.");
    }

    public void configurarTarifas() {
        System.out.println("Tarifas configuradas.");
    }

    public String mostrarDatos() {

        String datos = "Nombre: " + nombre
                + " - Correo: " + correo
                + " - Rol: " + rol
                + " - Tarifa Semana: " + tarifaSemana
                + " - Tarifa Fin de Semana: " + tarifaFinSemana;

        return datos;
    }

}
