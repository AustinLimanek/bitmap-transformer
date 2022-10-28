package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    public Bitmap(String inFile, String outFile, String transform) throws IOException {
        BufferedImage in = ImageIO.read(new File(inFile));
        for (int i = 0; i < in.getWidth(); i++) {
            for (int j = 0; j < in.getHeight(); j++) {
                int rgb = in.getRGB(i, j);
                Color current = new Color(rgb);
                int[] colors = {current.getRed(), current.getGreen(), current.getBlue()};
                in.setRGB(i, j, transform(transform, rgb, colors));
            }
        }
        ImageIO.write(in, "bmp", new File(outFile));
    }

    private int transform(String transform, int i, int[] colors) {
        return switch (transform) {
            case "invert" -> invert(i);
            case "grayscale" -> grayscale(colors);
            default -> 0;
        };
    }

    private int invert(int i) {
        return ~i & 0xff;
    }

    private int grayscale(int[] colors) {
        int sum = 0;
        for (int i : colors) {
            sum += i;
        }
        return sum / colors.length;
    }
}
