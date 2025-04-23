package com.javier;

import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana(SnakeVista vista) {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(vista);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();

    }
}
