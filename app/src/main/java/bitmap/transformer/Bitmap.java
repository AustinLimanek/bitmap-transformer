package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    public static String getFilePath(){
        String userPath = System.getProperty("user.dir");
        if(userPath.endsWith("app")){
            return userPath + "/src/main/resources/";
        }
        else{
            return userPath + "/app/src/main/resources/";
        }
    }

    public Bitmap(String inFile, String outFile, String transform, String type) throws IOException {
        if (transform.equals("flip")) flip(inFile, outFile, type);
        else {
            String path = getFilePath();
            BufferedImage in = ImageIO.read(new File(path + inFile));
            for (int i = 0; i < in.getWidth(); i++) {
                for (int j = 0; j < in.getHeight(); j++) {
                    int rgb = in.getRGB(i, j);
                    Color current = new Color(rgb);
                    int[] colors = {current.getRed(), current.getGreen(), current.getBlue()};
                    in.setRGB(i, j, transform(transform, rgb, colors, i));
                }
            }
            ImageIO.write(in, "bmp", new File(path + outFile));
        }
    }

    private int transform(String transform, int i, int[] colors, int a) {
        return switch (transform) {
            case "invert" -> invert(i);
            case "grayscale" -> grayscale(colors);
            case "random" -> random(i);
            default -> 0;
        };
    }

    private int invert(int i) {
        int r = ~i & 0xff;
        return r;
    }

    private int grayscale(int[] colors) {
        int sum = 0;
        for (int i : colors) {
            sum += i;
        }
        int ans = sum / colors.length;
        return 65536*ans + 256*ans + ans;
    }

    private int random(int i) {
        if (i == -131076){
            int red = (int) (255*Math.random());
            int green = (int) (255*Math.random());
            int blue = (int) (255*Math.random());
            return 65536*red + 256*green + blue;
        }
        return i;
    }

    public void flip(String inFile, String outFile, String type) throws IOException {
        if (!type.equals("horizontal") && !type.equals("vertical")) throw new IllegalArgumentException("Please input either horizontal or vertical for flip transform.");
        String path = getFilePath();
        BufferedImage read = ImageIO.read(new File(path + inFile));
        BufferedImage newImage = ImageIO.read(new File(path + inFile));
        int width = read.getWidth();
        int height = read.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = read.getRGB(i, j);
                if(type.equals("horizontal")) newImage.setRGB(width - i - 1, j, rgb);
                else{newImage.setRGB(i, height - j - 1, rgb);}
            }
        }
        ImageIO.write(newImage, "bmp", new File(path + outFile));
    }

}
