package com.chess.model.board;

import java.util.HashMap;

public class Tile {
    private static final HashMap<File, Integer> file2coord;
    private final File file;
    private final Rank row;
    private final Integer[] coordinates;

    static {
        file2coord = new HashMap<>();
        file2coord.put(File.A, 1);
        file2coord.put(File.B, 2);
        file2coord.put(File.C, 3);
        file2coord.put(File.D, 4);
        file2coord.put(File.E, 5);
        file2coord.put(File.F, 6);
        file2coord.put(File.G, 7);
        file2coord.put(File.H, 8);
    }

    public Tile(File file, Rank row) {
        this.file = file;
        this.row = row;
        coordinates = new Integer[2];
        coordinates[0] = file2coord.get(file);
        coordinates[1] = row.getValue();
    }
    
}
