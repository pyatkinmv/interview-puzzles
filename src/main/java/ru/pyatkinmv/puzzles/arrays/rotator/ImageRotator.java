package ru.pyatkinmv.puzzles.arrays.rotator;


import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRotator implements Rotator<BufferedImage> {
    public BufferedImage rotate(BufferedImage image, boolean clockwise) {
        int[][] arrImage = intArrayFromImage(image);
        int[][] rotatedArray;
        rotatedArray = new MatrixRotator().rotate(arrImage, clockwise);
        return imageFromIntArray(rotatedArray, image.getType());
    }

    private int[][] intArrayFromImage(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int[][] arrImage = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arrImage[i][j] = bufferedImage.getRGB(i, j);
            }
        }
        return arrImage;
    }

    private BufferedImage imageFromIntArray(int[][] matrix, int imageType) {
        BufferedImage image = new BufferedImage(matrix.length, matrix[0].length, imageType);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int intColor = matrix[i][j];
                Color newColor = new Color(intColor, true);
                image.setRGB(i, j, newColor.getRGB());
            }
        }
        return image;
    }
}

