/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto.progra;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import com.mycompany.proyecto.progra.Clases.Administrador;
import com.mycompany.proyecto.progra.Clases.EspacioParqueo;
import com.mycompany.proyecto.progra.Clases.Reporte;
import com.mycompany.proyecto.progra.Clases.Reservacion;
import com.mycompany.proyecto.progra.Clases.Usuario;
import com.mycompany.proyecto.progra.Clases.Vehiculo;
import com.mycompany.proyecto.progra.Enum.Estado_Espacio;
import com.mycompany.proyecto.progra.Enum.Metodo_Pago;
import com.mycompany.proyecto.progra.Enum.Rol_Usuario;
import com.mycompany.proyecto.progra.Enum.Tipo_Dia;
import javax.swing.JOptionPane;

public class ProyectoProgra {

    public static void main(String[] args) {
 
        int capacidadEspacios = 30;
        EspacioParqueo[] espacios = new EspacioParqueo[capacidadEspacios];
        for (int i = 0; i < capacidadEspacios; i++) {
            espacios[i] = new EspacioParqueo(i + 1);
        }

        double tarifaHora = 1000;
        int maxVehiculos = 100;
        Vehiculo[] vehiculos = new Vehiculo[maxVehiculos];
        boolean[] vehiculoPagado = new boolean[maxVehiculos];
        int cantidadVehiculos = 0;

     
        int maxReservaciones = 100;
        Reservacion[] reservaciones = new Reservacion[maxReservaciones];
        boolean[] reservacionPagada = new boolean[maxReservaciones];
        int cantidadReservaciones = 0;
        double ingresosTotales = 0;

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
        if (nombre == null) {
            nombre = "Invitado";
        } else {
            nombre = nombre.trim();
            if (nombre.equals("")) {
                nombre = "Invitado";
            }
        }

        String correo = JOptionPane.showInputDialog(null, "Ingrese su correo:");
        if (correo == null) {
            correo = "sin-correo@eldescanso.com";
        } else {
            correo = correo.trim();
            if (correo.equals("")) {
                correo = "sin-correo@eldescanso.com";
            }
        }
        Administrador administrador = new Administrador(
                nombre, correo, "", Rol_Usuario.ADMINISTRADOR, 5000, 7000);
 
        boolean salirSistema = false;
        String[] opcionesRol = {"Menu Cliente", "Menu Administrador", "Salir"};

        do {
            int seleccionRol = JOptionPane.showOptionDialog(null,
                    "Parqueo 'El Descanso'\n\nSeleccione una opcion:",
                    "Sistema de Parqueo El Descanso",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesRol,
                    opcionesRol[0]);

          
            if (seleccionRol == 0) {

                Usuario usuarioCliente = new Usuario(nombre, correo);
                JOptionPane.showMessageDialog(null, "Bienvenido cliente.\n" + usuarioCliente.mostrarDatos());

                boolean volverCliente = false;
                String[] opcionesCliente = {"Registrar vehiculo", "Crear reservacion", "Procesar pago", "Mostrar reporte", "Salir"};

                while (!volverCliente) {
                    int seleccionCliente = JOptionPane.showOptionDialog(null,
                            "Menu Principal (Cliente)",
                            "Menu Cliente",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesCliente,
                            opcionesCliente[0]);

               
                    if (seleccionCliente == 0) {

                        if (cantidadVehiculos >= maxVehiculos) {
                            JOptionPane.showMessageDialog(null, "No se pueden registrar mas vehiculos.");
                        } else {
                            String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehiculo:");

                            if (placa == null) {
                                JOptionPane.showMessageDialog(null, "Registro cancelado: no se ingreso placa.");
                            } else {
                                placa = placa.trim();
                                if (placa.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Registro cancelado: la placa esta vacia.");
                                } else {
                                    placa = placa.toUpperCase();

                                    String[] opcionesPago = {"SINPE", "Efectivo", "Tarjeta"};
                                    int seleccionPago = JOptionPane.showOptionDialog(null,
                                            "Seleccione la forma de pago:",
                                            "Forma de pago",
                                            JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            opcionesPago,
                                            opcionesPago[0]);

                                    Metodo_Pago metodoPago;
                                    if (seleccionPago == 0) {
                                        metodoPago = Metodo_Pago.SINPE;
                                    } else if (seleccionPago == 1) {
                                        metodoPago = Metodo_Pago.EFECTIVO;
                                    } else {
                                        metodoPago = Metodo_Pago.TARJETA;
                                    }

                                    String textoHoras = JOptionPane.showInputDialog(null,
                                            "Ingrese el tiempo estimado de parqueo (en horas):", "1");

                                    int horas = 1;
                                    if (textoHoras != null) {
                                        textoHoras = textoHoras.trim();

                                        boolean esValidoHoras = true;
                                        int cantidadDigitosHoras = 0;
                                        int i = 0;
                                        while (i < textoHoras.length() && esValidoHoras) {
                                            char caracter = textoHoras.charAt(i);
                                            if (Character.isDigit(caracter)) {
                                                cantidadDigitosHoras = cantidadDigitosHoras + 1;
                                            } else {
                                                esValidoHoras = false;
                                            }
                                            i = i + 1;
                                        }

                                        if (esValidoHoras && cantidadDigitosHoras > 0) {
                                            horas = Integer.parseInt(textoHoras);
                                            if (horas <= 0) {
                                                horas = 1;
                                            }
                                        }
                                    }

                                    EspacioParqueo espacioLibre = null;
                                    boolean encontrado = false;
                                    int indice = 0;
                                    while (indice < capacidadEspacios && !encontrado) {
                                        if (espacios[indice].verificarDisponibilidad()) {
                                            espacioLibre = espacios[indice];
                                            encontrado = true;
                                        }
                                        indice = indice + 1;
                                    }

                                    if (espacioLibre == null) {
                                        JOptionPane.showMessageDialog(null, "No hay espacios disponibles en este momento.");
                                    } else {
                                        Vehiculo vehiculo = new Vehiculo(placa, metodoPago.toString(), horas);
                                        vehiculos[cantidadVehiculos] = vehiculo;
                                        vehiculoPagado[cantidadVehiculos] = false;
                                        cantidadVehiculos = cantidadVehiculos + 1;

                                        espacioLibre.ocuparEspacio();

                                        double costoEstimado = horas * tarifaHora;
                                        JOptionPane.showMessageDialog(null, "Vehiculo registrado con exito.\n"
                                                + vehiculo.mostrarDatos()
                                                + "\nEspacio asignado: #" + espacioLibre.getId_Espacio()
                                                + "\nCosto estimado (sin IVA): " + costoEstimado);
                                    }
                                }
                            }
                        }

                    } else if (seleccionCliente == 1) {

                        if (cantidadReservaciones >= maxReservaciones) {
                            JOptionPane.showMessageDialog(null, "No se pueden procesar mas reservaciones.");
                        } else {
                            String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehiculo:");

                            if (placa == null || placa.trim().equals("")) {
                                JOptionPane.showMessageDialog(null, "Reservacion cancelada.");
                            } else {
                                placa = placa.trim().toUpperCase();

                                String[] opcionesDia = {"Entre semana", "Fin de semana"};
                                int seleccionDia = JOptionPane.showOptionDialog(null,
                                        "Seleccione el tipo de dia de la reservacion:",
                                        "Tipo de dia",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesDia,
                                        opcionesDia[0]);

                                Tipo_Dia tipoDia;
                                double tarifaPorNoche;
                                if (seleccionDia == 0) {
                                    tipoDia = Tipo_Dia.ENTRE_SEMANA;
                                    tarifaPorNoche = administrador.getTarifaSemana();
                                } else {
                                    tipoDia = Tipo_Dia.FIN_DE_SEMANA;
                                    tarifaPorNoche = administrador.getTarifaFinSemana();
                                }

                                String textoNoches = JOptionPane.showInputDialog(null, "Ingrese la cantidad de noches:", "1");
                                int noches = 1;
                                if (textoNoches != null) {
                                    textoNoches = textoNoches.trim();
                                    boolean esValidoNoches = true;
                                    int cantidadDigitosNoches = 0;
                                    int i = 0;
                                    while (i < textoNoches.length() && esValidoNoches) {
                                        char caracter = textoNoches.charAt(i);
                                        if (Character.isDigit(caracter)) {
                                            cantidadDigitosNoches = cantidadDigitosNoches + 1;
                                        } else {
                                            esValidoNoches = false;
                                        }
                                        i = i + 1;
                                    }
                                    if (esValidoNoches && cantidadDigitosNoches > 0) {
                                        noches = Integer.parseInt(textoNoches);
                                        if (noches <= 0) {
                                            noches = 1;
                                        }
                                    }
                                }

                                String textoPersonas = JOptionPane.showInputDialog(null, "Ingrese la cantidad de personas:", "1");
                                int personas = 1;
                                if (textoPersonas != null) {
                                    textoPersonas = textoPersonas.trim();
                                    boolean esValidoPersonas = true;
                                    int cantidadDigitosPersonas = 0;
                                    int j = 0;
                                    while (j < textoPersonas.length() && esValidoPersonas) {
                                        char caracter = textoPersonas.charAt(j);
                                        if (Character.isDigit(caracter)) {
                                            cantidadDigitosPersonas = cantidadDigitosPersonas + 1;
                                        } else {
                                            esValidoPersonas = false;
                                        }
                                        j = j + 1;
                                    }
                                    if (esValidoPersonas && cantidadDigitosPersonas > 0) {
                                        personas = Integer.parseInt(textoPersonas);
                                        if (personas <= 0) {
                                            personas = 1;
                                        }
                                    }
                                }

                                String horaEntrada = JOptionPane.showInputDialog(null, "Ingrese la hora de entrada (ej: 8:00 am):");
                                if (horaEntrada == null) {
                                    horaEntrada = "No indicada";
                                }

                                String horaSalida = JOptionPane.showInputDialog(null, "Ingrese la hora de salida (ej: 6:00 pm):");
                                if (horaSalida == null) {
                                    horaSalida = "No indicada";
                                }

                                EspacioParqueo espacioLibre = null;
                                boolean encontrado = false;
                                int indice = 0;
                                while (indice < capacidadEspacios && !encontrado) {
                                    if (espacios[indice].verificarDisponibilidad()) {
                                        espacioLibre = espacios[indice];
                                        encontrado = true;
                                    }
                                    indice = indice + 1;
                                }

                                if (espacioLibre == null) {
                                    JOptionPane.showMessageDialog(null, "No hay espacios disponibles para reservar.");
                                } else {
                                    double montoBase = tarifaPorNoche * noches * personas;

                                    Vehiculo vehiculoReserva = new Vehiculo(placa, "PENDIENTE", 0);
                                    String idReservacion = "R" + (cantidadReservaciones + 1);

                                    Reservacion reservacion = new Reservacion(idReservacion, usuarioCliente, vehiculoReserva,
                                            Estado_Espacio.RESERVADO, horaEntrada, horaSalida, tipoDia, montoBase, true);

                                    reservaciones[cantidadReservaciones] = reservacion;
                                    reservacionPagada[cantidadReservaciones] = false;
                                    cantidadReservaciones = cantidadReservaciones + 1;

                                    espacioLibre.reservarEspacio();

                                    double ivaEstimado = montoBase * 0.13;
                                    double totalEstimado = montoBase + ivaEstimado;

                                    JOptionPane.showMessageDialog(null, "Reservacion creada con exito.\n"
                                            + "Espacio asignado: #" + espacioLibre.getId_Espacio() + "\n"
                                            + "Tipo de dia: " + tipoDia + "\n"
                                            + "Noches: " + noches + " - Personas: " + personas + "\n"
                                            + "Monto (sin IVA): " + montoBase + "\n"
                                            + "IVA estimado (13%): " + ivaEstimado + "\n"
                                            + "Total estimado: " + totalEstimado);
                                }
                            }
                        }

                    // ---------- Procesar pago ----------
                    } else if (seleccionCliente == 2) {

                        String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del vehiculo a pagar:");

                        if (placa == null || placa.trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Pago cancelado.");
                        } else {
                            placa = placa.trim().toUpperCase();

                            // ---- Buscar reservacion pendiente (ciclo WHILE) ----
                            int indiceReservacion = -1;
                            boolean encontradaReservacion = false;
                            int r = 0;
                            while (r < cantidadReservaciones && !encontradaReservacion) {
                                if (reservaciones[r].getVehiculo().getPlaca().equals(placa) && !reservacionPagada[r]) {
                                    indiceReservacion = r;
                                    encontradaReservacion = true;
                                }
                                r = r + 1;
                            }

                            // ---- Buscar vehiculo pendiente (ciclo WHILE), solo si no hay reservacion ----
                            int indiceVehiculo = -1;
                            if (indiceReservacion == -1) {
                                boolean encontradoVehiculo = false;
                                int v = 0;
                                while (v < cantidadVehiculos && !encontradoVehiculo) {
                                    if (vehiculos[v].getPlaca().equals(placa) && !vehiculoPagado[v]) {
                                        indiceVehiculo = v;
                                        encontradoVehiculo = true;
                                    }
                                    v = v + 1;
                                }
                            }

                            if (indiceReservacion == -1 && indiceVehiculo == -1) {
                                JOptionPane.showMessageDialog(null, "No se encontraron pagos pendientes para la placa " + placa);
                            } else {

                                double montoBase;
                                if (indiceReservacion != -1) {
                                    montoBase = reservaciones[indiceReservacion].getMonto_Total();
                                } else {
                                    montoBase = vehiculos[indiceVehiculo].getTiempoEstadia() * tarifaHora;
                                }

                                String[] opcionesPago = {"SINPE", "Efectivo", "Tarjeta"};
                                int seleccionPago = JOptionPane.showOptionDialog(null,
                                        "Seleccione la forma de pago:",
                                        "Procesar pago",
                                        JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        opcionesPago,
                                        opcionesPago[0]);

                                Metodo_Pago metodoPago;
                                if (seleccionPago == 0) {
                                    metodoPago = Metodo_Pago.SINPE;
                                } else if (seleccionPago == 1) {
                                    metodoPago = Metodo_Pago.EFECTIVO;
                                } else {
                                    metodoPago = Metodo_Pago.TARJETA;
                                }

                                double iva = montoBase * 0.13;
                                double total = montoBase + iva;

                                if (indiceReservacion != -1) {
                                    reservacionPagada[indiceReservacion] = true;
                                } else {
                                    vehiculoPagado[indiceVehiculo] = true;
                                }

                                ingresosTotales = ingresosTotales + total;

                                String factura = "----------- FACTURA -----------\n"
                                        + "Placa: " + placa + "\n"
                                        + "Metodo de pago: " + metodoPago + "\n"
                                        + "Monto: " + montoBase + "\n"
                                        + "IVA (13%): " + iva + "\n"
                                        + "Total: " + total + "\n"
                                        + "--------------------------------";

                                JOptionPane.showMessageDialog(null, factura);
                            }
                        }

                    } else if (seleccionCliente == 3) {

                        int espaciosOcupados = 0;
                        for (int i = 0; i < capacidadEspacios; i++) {
                            if (espacios[i].getDisponibilidad() == Estado_Espacio.OCUPADO
                                    || espacios[i].getDisponibilidad() == Estado_Espacio.RESERVADO) {
                                espaciosOcupados = espaciosOcupados + 1;
                            }
                        }

                        Reporte reporte = new Reporte(capacidadEspacios, espaciosOcupados, ingresosTotales);
                        reporte.mostrarReporte();

                    } else {
                        volverCliente = true;
                    }
                }

            
            // MENU ADMINISTRADOR //
            } else if (seleccionRol == 1) {

                JOptionPane.showMessageDialog(null, "Bienvenido administrador.\n" + administrador.mostrarDatos());

                boolean volverAdmin = false;
                String[] opcionesAdmin = {"Gestionar espacios de parqueo", "Revisar reportes mensuales", "Configurar tarifas", "Salir"};

                do {
                    int seleccionAdmin = JOptionPane.showOptionDialog(null,
                            "Menu Administrador",
                            "Menu Administrador",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcionesAdmin,
                            opcionesAdmin[0]);

                    if (seleccionAdmin == 0) {
                        administrador.gestionarEspacios();

                        String listado = "";
                        for (int i = 0; i < capacidadEspacios; i++) {
                            listado = listado + "Espacio #" + espacios[i].getId_Espacio()
                                    + " - " + espacios[i].getDisponibilidad() + "\n";
                        }

                        String textoId = JOptionPane.showInputDialog(null,
                                listado + "\nIngrese el numero de espacio que desea liberar (0 para cancelar):", "0");

                        int idEspacio = 0;
                        if (textoId != null) {
                            textoId = textoId.trim();
                            boolean esValidoId = true;
                            int cantidadDigitosId = 0;
                            int i = 0;
                            while (i < textoId.length() && esValidoId) {
                                char caracter = textoId.charAt(i);
                                if (Character.isDigit(caracter)) {
                                    cantidadDigitosId = cantidadDigitosId + 1;
                                } else {
                                    esValidoId = false;
                                }
                                i = i + 1;
                            }
                            if (esValidoId && cantidadDigitosId > 0) {
                                idEspacio = Integer.parseInt(textoId);
                            }
                        }

                        if (idEspacio >= 1 && idEspacio <= capacidadEspacios) {
                            espacios[idEspacio - 1].liberarEspacio();
                            JOptionPane.showMessageDialog(null, "Espacio " + idEspacio + " liberado con exito.");
                        }

                    } else if (seleccionAdmin == 1) {
                        administrador.revisarReportes();

                        int espaciosOcupados = 0;
                        for (int i = 0; i < capacidadEspacios; i++) {
                            if (espacios[i].getDisponibilidad() == Estado_Espacio.OCUPADO
                                    || espacios[i].getDisponibilidad() == Estado_Espacio.RESERVADO) {
                                espaciosOcupados = espaciosOcupados + 1;
                            }
                        }

                        Reporte reporte = new Reporte(capacidadEspacios, espaciosOcupados, ingresosTotales);
                        reporte.mostrarReporte();
                    } else if (seleccionAdmin == 2) {
                        String textoSemana = JOptionPane.showInputDialog(null,
                                "Tarifa entre semana. Actual: " + administrador.getTarifaSemana(),
                                String.valueOf(administrador.getTarifaSemana()));
                        String textoFinSemana = JOptionPane.showInputDialog(null,
                                "Tarifa de fin de semana. Actual: " + administrador.getTarifaFinSemana(),
                                String.valueOf(administrador.getTarifaFinSemana()));

                        double nuevaSemana = administrador.getTarifaSemana();
                        double nuevaFinSemana = administrador.getTarifaFinSemana();
                        if (textoSemana != null) {
                            textoSemana = textoSemana.trim();
                            boolean esValidoSemana = true;
                            int cantidadDigitosSemana = 0;
                            int cantidadPuntosSemana = 0;
                            int i = 0;
                            while (i < textoSemana.length() && esValidoSemana) {
                                char caracter = textoSemana.charAt(i);
                                if (Character.isDigit(caracter)) {
                                    cantidadDigitosSemana = cantidadDigitosSemana + 1;
                                } else if (caracter == '.') {
                                    cantidadPuntosSemana = cantidadPuntosSemana + 1;
                                } else {
                                    esValidoSemana = false;
                                }
                                i = i + 1;
                            }
                            if (esValidoSemana && cantidadDigitosSemana > 0 && cantidadPuntosSemana <= 1) {
                                nuevaSemana = Double.parseDouble(textoSemana);
                            }
                        }

                        if (textoFinSemana != null) {
                            textoFinSemana = textoFinSemana.trim();
                            boolean esValidoFinSemana = true;
                            int cantidadDigitosFinSemana = 0;
                            int cantidadPuntosFinSemana = 0;
                            int j = 0;
                            while (j < textoFinSemana.length() && esValidoFinSemana) {
                                char caracter = textoFinSemana.charAt(j);
                                if (Character.isDigit(caracter)) {
                                    cantidadDigitosFinSemana = cantidadDigitosFinSemana + 1;
                                } else if (caracter == '.') {
                                    cantidadPuntosFinSemana = cantidadPuntosFinSemana + 1;
                                } else {
                                    esValidoFinSemana = false;
                                }
                                j = j + 1;
                            }
                            if (esValidoFinSemana && cantidadDigitosFinSemana > 0 && cantidadPuntosFinSemana <= 1) {
                                nuevaFinSemana = Double.parseDouble(textoFinSemana);
                            }
                        }

                        administrador.setTarifaSemana(nuevaSemana);
                        administrador.setTarifaFinSemana(nuevaFinSemana);
                        administrador.configurarTarifas();

                        JOptionPane.showMessageDialog(null, "Tarifas actualizadas con exito.\n" + administrador.mostrarDatos());

                    } else {
                        volverAdmin = true;
                    }
                } while (!volverAdmin);

           
            } else {
                salirSistema = true;
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema de Parqueo 'El Descanso'.");
            }
        } while (!salirSistema);
    }
}