import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.pyatkinmv.puzzles.rotator.ImageRotator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import static java.util.Objects.requireNonNull;

public class ImageRotatorTest {
    private ImageRotator rotator;

    @Before
    public void setUp() {
        rotator = new ImageRotator();
    }

    @Test
    public void testRotate() throws URISyntaxException, IOException {
        BufferedImage expected = getResourceImage("images/output.jpg");
        BufferedImage image = getResourceImage("images/input.jpg");
        BufferedImage actual = rotator.rotate(image, true);
        Assert.assertTrue(compareImages(expected, actual));
    }

    private BufferedImage getResourceImage(String name) throws IOException, URISyntaxException {
        File fileImage = Path.of(requireNonNull(this.getClass().getClassLoader().getResource(name)).toURI()).toFile();
        return ImageIO.read(fileImage);
    }

    private boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
        return imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight();
    }
}
