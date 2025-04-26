package com.javier.modelos;

import java.awt.Graphics;


public abstract class GameObject {
    protected Punto position;

    public GameObject(int x, int y) {
        this.position = new Punto(x, y);
    }

    // para que sepan pintarse
    public abstract void draw(Graphics g);

    public Punto getPosition() {
        return position;
    }

    protected void setPosition(Punto position) {
        this.position = position;
    }
}

// podemos hacer mas como obstaculos o powerups