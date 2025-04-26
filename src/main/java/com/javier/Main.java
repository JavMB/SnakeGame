package com.javier;


import com.javier.controlador.SnakeControlador;
import com.javier.modelos.GameObject;
import com.javier.modelos.Manzana;
import com.javier.modelos.Muro;
import com.javier.modelos.Serpiente;
import com.javier.utils.Config;
import com.javier.utils.Orientacion;
import com.javier.vista.SnakeVista;
import com.javier.vista.Ventana;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Serpiente serpiente = new Serpiente();
        List<GameObject> objects = new ArrayList<>();

        SnakeVista panel = new SnakeVista(serpiente, objects);
        SnakeControlador controlador = new SnakeControlador(serpiente, panel, objects);

        Ventana ventana = new Ventana(panel);
        ventana.add(panel);
        ventana.addKeyListener(controlador.getKeyListener());

        objects.add(new Manzana());

        for (int i = 0; i < Config.GRID_COLS; i++) {
            objects.add(new Muro(i, 0, Orientacion.ARRIBA));
            objects.add(new Muro(i, Config.GRID_ROWS - 1, Orientacion.ABAJO));
        }
        for (int i = 0; i < Config.GRID_ROWS; i++) {
            objects.add(new Muro(0, i, Orientacion.IZQUIERDA));
            objects.add(new Muro(Config.GRID_COLS - 1, i, Orientacion.DERECHA));
        }
        controlador.iniciar();


    }
}
