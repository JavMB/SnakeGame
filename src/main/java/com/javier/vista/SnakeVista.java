package com.javier.vista;

import com.javier.utils.Config;
import com.javier.modelos.GameObject;
import com.javier.modelos.Serpiente;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SnakeVista extends JPanel {
    private final Serpiente s;
    private final List<GameObject> comp;

    public SnakeVista(Serpiente s, List<GameObject> o) {
        this.s = s;
        this.comp = o;
    }

    @Override
    public Dimension getPreferredSize() {
        return Config.BOARD_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(85, 170, 0));
        g.fillRect(0, 0, getWidth(), getHeight());

        for (GameObject obj : comp) {
            obj.draw(g);
        }
        s.draw(g);

        pintarRejilla(g);
    }

    private void pintarRejilla(Graphics g) {
        g.setColor(new Color(0, 0, 0, 50));

        // Dibujar líneas verticales (una cada CELL_SIZE píxeles)
        for (int i = 0; i <= Config.BOARD_SIZE.width; i += Config.CELL_SIZE) {
            g.drawLine(i, 0, i, Config.BOARD_SIZE.height);
        }

        // Dibujar líneas horizontales
        for (int i = 0; i <= Config.BOARD_SIZE.height; i += Config.CELL_SIZE) {
            g.drawLine(0, i, Config.BOARD_SIZE.width, i);
        }
    }


}