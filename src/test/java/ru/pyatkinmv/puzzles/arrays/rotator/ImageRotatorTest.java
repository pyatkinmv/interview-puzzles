package ru.pyatkinmv.puzzles.arrays.rotator;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertTrue;

public class ImageRotatorTest {
    private ImageRotator rotator;

    @Before
    public void setUp() {
        rotator = new ImageRotator();
    }

    @Test
    public void testRotate() throws IOException {
        BufferedImage expected = getResourceImage("images/output.jpg");
        BufferedImage image = getResourceImage("images/input.jpg");
        BufferedImage actual = rotator.rotate(image, true);
        assertTrue(compareImages(expected, actual));
    }

    private BufferedImage getResourceImage(String name) throws IOException {
        File fileImage = new File(requireNonNull(getClass().getClassLoader().getResource(name)).getFile());
        return ImageIO.read(fileImage);
    }

    // TODO: fix image comparing
    private boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
        return imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight();
    }
}
