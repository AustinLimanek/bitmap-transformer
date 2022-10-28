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
                int red = current.getRed();
                int green = current.getGreen();
                int blue = current.getBlue();
                in.setRGB(i, j, transform(transform, rgb));
            }
        }
        ImageIO.write(in, "bmp", new File(outFile));
    }

    private int transform(String transform, int i) {
        return switch (transform) {
            case "invert" -> ~i & 0xff;
            case "grayscale" -> ;
            default -> 0;
        };
    }
}
