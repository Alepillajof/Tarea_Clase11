package com.example.tarea_clase11.util;

import com.example.tarea_clase11.model.Usuario;

public class Sesion {

    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(
            Usuario usuarioActual) {

        Sesion.usuarioActual = usuarioActual;
    }
}