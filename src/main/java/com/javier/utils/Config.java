package com.javier.utils;

import java.awt.*;

public class Config {
    private Config() { /* no instanciable */ }

    public static final int CELL_SIZE = 25;
    public static final int GRID_COLS = 20;
    public static final int GRID_ROWS = 15;
    public static final Dimension BOARD_SIZE =
            new Dimension(GRID_COLS * CELL_SIZE, GRID_ROWS * CELL_SIZE);

}
