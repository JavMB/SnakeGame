package com.javier;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


public class SnakeControlador {
    private final Serpiente serpiente;
    private final SnakeVista panel;
    private final Timer timer;
    private final List<GameObject> obj;
    private Orientacion orientacion;

    public SnakeControlador(Serpiente serpiente, SnakeVista panel, List<GameObject> obj) {
        this.serpiente = serpiente;
        this.panel = panel;
        this.obj = obj;
        this.orientacion = Orientacion.ARRIBA;

        timer = new Timer(200, e -> {
            eventos();
            panel.repaint();
        });
    }

    public void iniciar() {
        timer.start();
    }

    public void eventos() {
        boolean comio = false;
        for (GameObject objeto : obj) {
            if (serpiente.getCabeza().equals(objeto.getPosition())) {
                if (objeto instanceof Muro) {
                    timer.stop();
                } else if (objeto instanceof Manzana) {
                    serpiente.mover(orientacion, true);
                    ((Manzana) objeto).regenerarManzana();
//                    comio = true;
                }

            }
        }

        serpiente.mover(orientacion, comio);


    }


    public KeyListener getKeyListener() {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> cambiarDireccion(Orientacion.ARRIBA);
                    case KeyEvent.VK_DOWN -> cambiarDireccion(Orientacion.ABAJO);
                    case KeyEvent.VK_LEFT -> cambiarDireccion(Orientacion.IZQUIERDA);
                    case KeyEvent.VK_RIGHT -> cambiarDireccion(Orientacion.DERECHA);
                }
            }
        };
    }

    private void cambiarDireccion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }


}
