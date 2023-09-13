package com.chess.model.utils;

import java.nio.file.Path;
import java.nio.file.Paths;


public class ImageUtils {
    public static String getImageFolder(String relativePath) {
        Path fullPath = Paths.get(System.getProperty("user.dir"), relativePath);
        return fullPath.toAbsolutePath().toString();
    }
}
