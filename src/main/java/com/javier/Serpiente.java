package com.javier;

import java.awt.*;
import java.util.LinkedList;


public class Serpiente {
    private final LinkedList<Punto> serpiente;

    public Serpiente() {
        this.serpiente = new LinkedList<>();
        serpiente.add(new Punto(10, 12));
    }

    public void mover(Orientacion o, boolean haComido) {
        Punto posActual = serpiente.getFirst();
        Punto posPosterior = null;

        switch (o) {
            case ARRIBA -> posPosterior = new Punto(posActual.getX(), posActual.getY() - 1);
            case ABAJO -> posPosterior = new Punto(posActual.getX(), posActual.getY() + 1);
            case IZQUIERDA -> posPosterior = new Punto(posActual.getX() - 1, posActual.getY());
            case DERECHA -> posPosterior = new Punto(posActual.getX() + 1, posActual.getY());
        }

        serpiente.addFirst(posPosterior);
        if (!haComido) {
            serpiente.removeLast();
        }
    }

    public Punto getCabeza() {
        return serpiente.getFirst();
    }

    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        for (Punto p : serpiente) {
            g.fillRect(p.getX() * Config.CELL_SIZE, p.getY() * Config.CELL_SIZE, Config.CELL_SIZE, Config.CELL_SIZE);
        }

    }


}
