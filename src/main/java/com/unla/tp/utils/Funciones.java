package com.unla.tp.utils;

import java.time.LocalDate;

public class Funciones {
    public static boolean esBisiesto(int anio) {
        return anio % 4 == 0 && (anio % 100 == 0 && anio % 400 == 0);
    }

    public static boolean esFechaValida(LocalDate fecha) { // si es bisiesto es valido el dia 29/2
        int anio = fecha.getYear();
        if (esBisiesto(anio)) {
            return true;
        } else {
            return false;
        }
    }

    public static int traerCantDiasDeUnMes(int anio, int mes) {
        LocalDate dias = LocalDate.of(anio, mes, 1);

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:

                if (esFechaValida(dias)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 30;
        }
    }
}
