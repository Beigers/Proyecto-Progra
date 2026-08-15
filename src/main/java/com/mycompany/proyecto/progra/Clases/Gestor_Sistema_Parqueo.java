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
public class Gestor_Sistema_Parqueo {
    private int espaciosTotales = 20;
    private int espaciosOcupados = 0;
    private double ingresosTotales = 0;

    public void iniciarSistema() {

        int opcion = 0;

        while (opcion != 5) {

            String menu = """
                    
                    ==============================
                    PARQUEO "EL DESCANSO"
                    GESTOR DEL SISTEMA
                    ==============================
                    
                    1. Registrar vehículo
                    2. Registrar salida y pago
                    3. Consultar espacios
                    4. Generar reporte
                    5. Salir
                    
                    Seleccione una opción:
                    """;

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                opcion = 5;
            } else {
                opcion = Integer.parseInt(entrada);
            }

            switch (opcion) {

                case 1:
                    registrarVehiculo();
                    break;

                case 2:
                    registrarSalida();
                    break;

                case 3:
                    consultarEspacios();
                    break;

                case 4:
                    generarReporte();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(
                            null,
                            "Gracias por utilizar el sistema "
                            + "del Parqueo El Descanso."
                    );
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida."
                    );
            }
        }
    }

    private void registrarVehiculo() {

        if (espaciosOcupados < espaciosTotales) {

            String placa = JOptionPane.showInputDialog(
                    "Ingrese la placa del vehículo:"
            );

            if (placa != null && !placa.isEmpty()) {

                espaciosOcupados++;

                JOptionPane.showMessageDialog(
                        null,
                        "Vehículo registrado correctamente.\n\n"
                        + "Placa: " + placa
                        + "\nEspacios ocupados: "
                        + espaciosOcupados
                        + "\nEspacios disponibles: "
                        + (espaciosTotales - espaciosOcupados)
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar una placa."
                );
            }

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay espacios disponibles."
            );
        }
    }

    private void registrarSalida() {

        if (espaciosOcupados > 0) {

            String placa = JOptionPane.showInputDialog(
                    "Ingrese la placa del vehículo:"
            );

            String montoTexto = JOptionPane.showInputDialog(
                    "Ingrese el monto de la tarifa:"
            );

            double monto = Double.parseDouble(montoTexto);

            double impuesto = monto * 0.13;

            double total = monto + impuesto;

            espaciosOcupados--;

            ingresosTotales = ingresosTotales + total;

            JOptionPane.showMessageDialog(
                    null,
                    "SALIDA REGISTRADA\n\n"
                    + "Placa: " + placa
                    + "\nTarifa: ₡"
                    + String.format("%.2f", monto)
                    + "\nImpuesto 13%: ₡"
                    + String.format("%.2f", impuesto)
                    + "\nTotal: ₡"
                    + String.format("%.2f", total)
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay vehículos dentro del parqueo."
            );
        }
    }

    private void consultarEspacios() {

        int espaciosDisponibles =
                espaciosTotales - espaciosOcupados;

        JOptionPane.showMessageDialog(
                null,
                "ESTADO DEL PARQUEO\n\n"
                + "Espacios totales: " + espaciosTotales
                + "\nEspacios ocupados: " + espaciosOcupados
                + "\nEspacios disponibles: "
                + espaciosDisponibles
        );
    }

    private void generarReporte() {

        Reporte reporte = new Reporte(
                espaciosTotales,
                espaciosOcupados,
                ingresosTotales
        );

        reporte.mostrarReporte();
    }

    public static void main(String[] args) {

        Gestor_Sistema_Parqueo gestor =
                new Gestor_Sistema_Parqueo();

        gestor.iniciarSistema();
    }
}
