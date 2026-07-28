/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.progra.Clases;

import com.mycompany.proyecto.progra.Enum.Rol_Usuario;

/**
 *
 * @author Lenovo ThinkPad
 */
public class Usuario {

    private String nombre;
    private String correo;
    private Rol_Usuario rol;

    public Usuario(String nombre, String correo, Rol_Usuario rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Usuario(String nombre, String correo) {
        this(nombre, correo, Rol_Usuario.CLIENTE);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol_Usuario getRol() {
        return rol;
    }

    public void setRol(Rol_Usuario rol) {
        this.rol = rol;
    }


    public String mostrarDatos() {
        String datos = "Nombre: " + nombre + " - Correo: " + correo + " - Rol: " + rol;
        return datos;
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}