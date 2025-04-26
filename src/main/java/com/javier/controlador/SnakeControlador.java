package com.javier.controlador;

import com.javier.modelos.*;
import com.javier.utils.Orientacion;
import com.javier.vista.SnakeVista;

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

    private void eventos() {
        boolean comio = false;
        chocarCuerpo();


        for (GameObject objeto : obj) {
            if (serpiente.getCabeza().equals(objeto.getPosition())) {

                if (objeto instanceof Muro) {
                    if (orientacion.equals(((Muro) objeto).getOrientacion())) {
                        gameover();
                    }

                } else if (objeto instanceof Manzana) {
                    ((Manzana) objeto).regenerarManzana();
                    comio = true;
                }
            }
        }
        serpiente.mover(orientacion, comio);
    }

    public void chocarCuerpo() {
        List<Punto> cuerpo = serpiente.getCuerpo();
        for (Punto p : cuerpo) {
            if (serpiente.getCabeza().equals(p)) {
                gameover();
            }
        }
    }


    private void cambiarDireccion(Orientacion orientacion) {
        if ((this.orientacion.equals(Orientacion.ARRIBA) && orientacion.equals(Orientacion.ABAJO)) || (this.orientacion.equals(Orientacion.ABAJO) && orientacion.equals(Orientacion.ARRIBA))) {
            gameover();
        } else if ((this.orientacion.equals(Orientacion.IZQUIERDA) && orientacion.equals(Orientacion.DERECHA)) || (this.orientacion.equals(Orientacion.DERECHA) && orientacion.equals(Orientacion.IZQUIERDA))) {
            gameover();
        } else {
            this.orientacion = orientacion;
        }

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

    private void gameover() {
        timer.stop();
        JOptionPane.showMessageDialog(panel, "¡Game Over!", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);

    }


}
