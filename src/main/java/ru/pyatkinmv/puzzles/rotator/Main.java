package ru.pyatkinmv.puzzles.rotator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) return;

        // workingDirectory = src\\ru\\pyatkinmv\\interviewPuzzles\\ImageRotator\\
        String workingDirectory = args[0];
        System.out.println(workingDirectory);
        File fileImage = new File(workingDirectory + "images\\image.jpg");
        try {
            BufferedImage image = ImageIO.read(fileImage);
            ImageRotator rotator = new ImageRotator();
            BufferedImage rotatedImage = rotator.rotate(image, true);
            File output = new File(workingDirectory + "images\\result_image.jpg");
            ImageIO.write(rotatedImage, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}