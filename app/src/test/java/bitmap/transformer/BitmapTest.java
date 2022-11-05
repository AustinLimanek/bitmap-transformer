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
        try {
            new Bitmap(out, "invert");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File(getFilePath() + out).exists());
    }
    @Test
    void outputFileGrayScaleExists() {
        String out = "grayscale.bmp";
        try {
            new Bitmap(out, "grayscale");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(new File(getFilePath() + out).exists());
    }
}
