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

    public Bitmap(String outFile, String transform) throws IOException {
        String path = getFilePath();
        BufferedImage in = ImageIO.read(new File(path + "baldy-8bit.bmp"));
        for (int i = 0; i < in.getWidth(); i++) {
            for (int j = 0; j < in.getHeight(); j++) {
                int rgb = in.getRGB(i, j);
                Color current = new Color(rgb);
                //System.out.println(current);
                //System.out.println(rgb);
                int[] colors = {current.getRed(), current.getGreen(), current.getBlue()};
                in.setRGB(i, j, transform(transform, rgb, colors, i));
            }
        }
        ImageIO.write(in, "bmp", new File(path + outFile));
    }

    private int transform(String transform, int i, int[] colors, int a) {
        return switch (transform) {
            case "invert" -> invert(i);
            case "grayscale" -> grayscale(colors);
            case "random" -> random(i);
            case "red" -> red(colors, a);
            default -> 0;
        };
    }

    private int invert(int i) {
        int r = ~i & 0xff;
        System.out.println(r);
        return r;
    }

    private int grayscale(int[] colors) {
        int sum = 0;
        for (int i : colors) {
            sum += i;
            Color current = new Color(i);
            System.out.println(current);
            System.out.println(sum);
        }
        int ans = sum / colors.length;
        return 65536*ans + 256*ans + ans;
    }

    private int random(int i) {
        System.out.println(i);
        if (i == -131076){
            return (int) (255*Math.random());
        }
        return i;
    }

    //rgb = 65536 * r + 256 * g + b;
    private int red(int[] colors, int a){
        int red = colors[0];//(int) (127.5*Math.sin(2*Math.PI*a/110)+127.5);
        int green = colors[1];//colors[1];
        int blue = colors[2]; //colors[2];
        int ans = 65536*red + 256*green + blue;
        //System.out.println(ans);
        return 65536*red + 256*green + blue;

    }

}
