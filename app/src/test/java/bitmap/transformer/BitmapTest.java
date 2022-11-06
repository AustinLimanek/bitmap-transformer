package bitmap.transformer;

import org.junit.jupiter.api.Test;

import static bitmap.transformer.Bitmap.getFilePath;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class BitmapTest {
    @Test
    void outputFileInvertExists() {
            String out = "invert.bmp";
            String in = "baldy-8bit.bmp";
        try {
            new Bitmap(in, out, "invert", "none");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File(getFilePath() + out).exists());
    }
    @Test
    void outputFileGrayScaleExists() {
        String out = "grayscale.bmp";
        String in = "baldy-8bit.bmp";
        try {
            new Bitmap(in, out, "grayscale", "none");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File(getFilePath() + out).exists());
    }
}
