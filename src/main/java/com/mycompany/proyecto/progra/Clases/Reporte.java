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
public class Reporte {
    private int espaciosTotales;
    private int espaciosOcupados;
    private double ingresosTotales;

    public Reporte(
            int espaciosTotales,
            int espaciosOcupados,
            double ingresosTotales) {

        this.espaciosTotales = espaciosTotales;
        this.espaciosOcupados = espaciosOcupados;
        this.ingresosTotales = ingresosTotales;
    }

    public void mostrarReporte() {

        int espaciosDisponibles =
                espaciosTotales - espaciosOcupados;

        double porcentajeOcupacion = 0;

        if (espaciosTotales > 0) {

            porcentajeOcupacion =
                    ((double) espaciosOcupados
                    / espaciosTotales) * 100;
        }

        String reporte = """
                ==============================
                     REPORTE DEL PARQUEO
                      "EL DESCANSO"
                ==============================
                
                Espacios totales: %d
                Espacios ocupados: %d
                Espacios disponibles: %d
                
                Porcentaje de ocupación: %.2f%%
                
                Ingresos acumulados:
                ₡%.2f
                
                ==============================
                """.formatted(
                        espaciosTotales,
                        espaciosOcupados,
                        espaciosDisponibles,
                        porcentajeOcupacion,
                        ingresosTotales
                );

        JOptionPane.showMessageDialog(
                null,
                reporte,
                "Reporte del Parqueo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
