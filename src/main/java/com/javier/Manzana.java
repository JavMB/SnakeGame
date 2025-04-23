package com.javier;

import java.awt.*;
import java.util.Random;

public class Manzana extends GameObject {
    private static final Random rnd = new Random();
    private boolean isEaten;

    public Manzana() {
        super(0, 0);
        isEaten = false;
        setPosition(new Punto(rnd.nextInt(20), rnd.nextInt(15)));
    }

    public void setEaten() {
        isEaten = true;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getPosition().getX() * 25, getPosition().getY() * 25, 25, 25);

    }

    public void regenerarManzana() {
        setPosition(new Punto(rnd.nextInt(20), rnd.nextInt(15)));
        isEaten = false;
    }

}
