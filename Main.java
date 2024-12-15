import java.awt.*;

public class Main {
    public static final int RESOLUTION = 4096;
    public static final int ITERATIONS = 200;
    public static final int RADIUS = 2;

    public static void main(String[] args) {

        //for(int iter = 0; iter < ITERATIONS; iter++) {

            Picture pic = new Picture(RESOLUTION, RESOLUTION);
            Color[][] pixels = new Color[RESOLUTION][RESOLUTION];
            Complex[][] grid = new Complex[RESOLUTION][RESOLUTION];

            for (int i = 0; i < RESOLUTION; i++) {
                for (int j = 0; j < RESOLUTION; j++)
                    grid[i][j] = new Complex((-1 * RADIUS) + ((double) 2 * RADIUS * j / (RESOLUTION)),
                            RADIUS - ((double) 2 * RADIUS * i / (RESOLUTION)));
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int divergence = iterate(ITERATIONS, grid[i][j]);
                    if (divergence == 0) {
                        pixels[i][j] = new Color(0, 0, 0);
                    } else {
                        // pixels[i][j] = new Color(divergence, divergence, divergence);
                        pixels[i][j] = new Color (divergence, divergence, 255);
                    }
                }
            }

            String filename = "image";
            filename = filename.concat(Integer.toString(ITERATIONS));
            filename = filename + "res";
            filename = filename.concat(Integer.toString(RESOLUTION));
            filename = filename.concat(".jpg");
            pic.setPixels(pixels);
            pic.save(filename);

        //}

    }
    // 
    public static int iterate(int n, Complex c) {
        Complex point = new Complex(0, 0);
        Complex seed = new Complex(c.getReal(), c.getImag());
        for(int i = 0; i < n; i++) {
            point = point.multiply(point);
            point = point.add(seed);

            if(magnitudeGreaterThan2(point)) {
                //return 1;
                if(i < 2) return 1;
                if(i < 3) return 25;
                if(i < 4) return 50;
                if(i < 10) return 100;
                if(i < 50) return 150;
                if(i < 100) return 200;
                if(i < 150) return 225;
                return 255;
            }

//            if (point.getReal() > 2 || point.getImag() > 2) {
//                return (int) (255 - (2*i)) ;
//            }
        }
        return 0;
    }

    public static boolean magnitudeGreaterThan2(Complex c) {
        return (c.getReal() * c.getReal()) + (c.getImag() * c.getImag()) > 4;
    }
}