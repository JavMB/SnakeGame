package com.javier.modelos;

import com.javier.utils.Config;
import com.javier.utils.Orientacion;

import java.awt.*;


public class Muro extends GameObject {

    private final Orientacion orientacion;
    private static final int THICK = 3;

    public Muro(int x, int y, Orientacion orientacion) {
        super(x, y);
        this.orientacion = orientacion;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    @Override
    public void draw(Graphics g) {
        int px = position.getX() * Config.CELL_SIZE;
        int py = position.getY() * Config.CELL_SIZE;

        g.setColor(new Color(255, 255, 255, 200));
        switch (orientacion) {
            case ARRIBA:
                // línea en el borde interior superior
                g.fillRect(px, py, Config.CELL_SIZE, THICK);
                break;
            case ABAJO:
                // línea en el borde interior inferior
                g.fillRect(px, py + Config.CELL_SIZE - THICK, Config.CELL_SIZE, THICK);
                break;
            case IZQUIERDA:
                // línea en el borde interior izquierdo
                g.fillRect(px, py, THICK, Config.CELL_SIZE);
                break;
            case DERECHA:
                // línea en el borde interior derecho
                g.fillRect(px + Config.CELL_SIZE - THICK, py, THICK, Config.CELL_SIZE);
                break;
        }
    }

}
