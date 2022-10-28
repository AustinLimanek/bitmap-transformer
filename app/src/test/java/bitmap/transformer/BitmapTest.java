package bitmap.transformer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class BitmapTest {
    @Test
    void outputFileInvertExists() {
        try {
            Path in = Path.of("src", "main", "resources", "baldy-8bit.bmp");
            Path out = Path.of("src", "main", "resources", "invert.bmp");
            new Bitmap(in.toString(), out.toString(), "invert");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File("C:/Users/bhlie/Desktop/code401/bitmap-transformer/app/src/main/resources/invert.bmp").exists());
    }
    @Test
    void outputFileGrayScaleExists() {
        try {
            Path in = Path.of("src", "main", "resources", "baldy-8bit.bmp");
            Path out = Path.of("src", "main", "resources", "grayscale.bmp");
            new Bitmap(in.toString(), out.toString(), "grayscale");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File("C:/Users/bhlie/Desktop/code401/bitmap-transformer/app/src/main/resources/grayscale.bmp").exists());
    }
}
