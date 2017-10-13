package io.github.guiritter.wavelet;

import static io.github.guiritter.wavelet.Math.parseDoubleArray;
import io.github.guiritter.wavelet.gui.MainFrame;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Guilherme Alan Ritter
 */
public final class Main {

    private static int i;

    private static int j;

    private static int k;

    private static final Set<Transform> set = Collections.newSetFromMap(new WeakHashMap<Transform, Boolean>());

    private static int x;

    private static int y;

    /**
     * https://stackoverflow.com/questions/21176754/how-can-i-convert-an-image-to-grayscale-without-losing-transparency
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage create2ByteGrayAlphaImage(int width, int height) {
        int[] bandOffsets = new int[]{1, 0}; // gray + alpha
        int bands = bandOffsets.length; // 2, that is

        // Init data buffer of type byte
        DataBuffer buffer = new DataBufferByte(width * height * bands);

        // Wrap the data buffer in a raster
        WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, width * bands, bands, bandOffsets, new Point(0, 0));

        // Create a custom BufferedImage with the raster and a suitable color model
        return new BufferedImage(new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE), raster, false, null);
    }

    public static final double[][] imageToMatrix(BufferedImage image, int componentIndex) {
        double[][] doubleMatrix = new double[image.getHeight()][image.getWidth()];
        int x;
        int y;
        WritableRaster raster = image.getRaster();
        int color[] = raster.getPixel(0, 0, (int[]) null);
        for (y = 0; y < image.getHeight(); y++) {
            for (x = 0; x < image.getWidth(); x++) {
                raster.getPixel(x, y, color);
                doubleMatrix[y][x] = color[componentIndex];
            }
        }
        return doubleMatrix;
    }

    /**
     * Assumes the transform originated from an image: the original values
     * ranged from 0 to 255. The smooth coefficients must be divided by
     * 2 * J and the detail coefficients must be summed by 2 * J * 255 and
     * divided by 4 * J.
     * @param componentArray
     */
    public static final void normalize2DImage(double componentArray[][][][][]) {
        int J = componentArray[0].length - 1;
        for (i = 0; i < componentArray.length; i++) {
            for (y = 0; y < componentArray[i][0][0].length; y++) {
                for (x = 0; x < componentArray[i][0][0][0].length; x++) {
                    componentArray[i][0][0][y][x] /= pow(2, J);//2.0 * ((double) J);
                }
            }
        }
        FitLinear fit;
        double minimum;
        double maximum;
        for (i = 0; i < componentArray.length; i++) {
            for (j = 1; j <= J; j++) {
                for (k = 0; k < 3; k++) {
                    minimum = Double.POSITIVE_INFINITY;
                    maximum = Double.NEGATIVE_INFINITY;
                    for (y = 0; y < componentArray[i][j][k].length; y++) {
                        for (x = 0; x < componentArray[i][j][k][0].length; x++) {
                            minimum = min(minimum, componentArray[i][j][k][y][x]);
                            maximum = max(maximum, componentArray[i][j][k][y][x]);
//                            componentArray[i][j][k][y][x] += 2.0 * ((double) J) * 255.0;
//                            componentArray[i][j][k][y][x] /= 4.0 * ((double) J);
                        }
                    }
                    fit = new FitLinear(minimum, 0, maximum, 255);
                    for (y = 0; y < componentArray[i][j][k].length; y++) {
                        for (x = 0; x < componentArray[i][j][k][0].length; x++) {
                            componentArray[i][j][k][y][x] = fit.f(componentArray[i][j][k][y][x]);
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        double a = 1 / sqrt(2);
        //*
        double c[] = new double[]{ a,  a};
        double d[] = new double[]{-a,  a};
        double f[] = new double[]{ a,  a};
        double g[] = new double[]{ a, -a};
        /**/
        /*
        double c[] = new double[]{-0.1294,  0.2241,  0.8365,  0.4830};
        double d[] = new double[]{-0.4830,  0.8365, -0.2241, -0.1294};
        double f[] = new double[]{ 0.4830,  0.8365,  0.2241, -0.1294};
        double g[] = new double[]{-0.1294, -0.2241,  0.8365, -0.4830};
        /**/
        /*
        double c[] = new double[]{-0.1294,  0.2241,  0.8365,  0.4830};
        double d[] = new double[]{-0.4830,  0.8365, -0.2241, -0.1294};
        double f[] = new double[]{ 0.4830,  0.8365,  0.2241, -0.1294};
        double g[] = new double[]{-0.1294, -0.2241,  0.8365, -0.4830};
        /**/
        /*
        double c[] = new double[]{-0.0157, -0.0727,  0.3849,  0.8526,  0.3379, -0.0727};
        double d[] = new double[]{ 0.0727,  0.3379, -0.8526,  0.3849,  0.0727, -0.0157};
        double f[] = new double[]{-0.0727,  0.3379,  0.8526,  0.3849, -0.0727, -0.0157};
        double g[] = new double[]{-0.0157,  0.0727,  0.3849, -0.8526,  0.3379,  0.0727};
        /**/
        int b = 6;
//        String s = "C:/users/guir/documents/Lenna.png";
//        String s = "C:/users/guir/documents/test downsampling without smoothing.png";
        String s = "/home/guir/Imagens/thumb-1920-262599.jpg";
        int e = b;
        /*
        Transform2D transform2D = new Transform2D(
         imageToMatrix(ImageIO.read(new File(s)), 0),
         new double[]{ a,  a},
         new double[]{-a,  a},
         new double[]{ a,  a},
         new double[]{ a, -a},
         b);
        double componentArray[][][][][] = new double[][][][][]{transform2D.transformInverse(b)};
        /**/
        /*
        Transform2D transform2D = new Transform2D(imageToMatrix(ImageIO.read(new File(s)), 0), c, d, f, g, b);
        double componentArray[][][][][] = new double[][][][][]{transform2D.transformInverse(e), null, null};
        transform2D = new Transform2D(imageToMatrix(ImageIO.read(new File(s)), 1), c, d, f, g, b);
        componentArray[1] = transform2D.transformInverse(e);
        transform2D = new Transform2D(imageToMatrix(ImageIO.read(new File(s)), 2), c, d, f, g, b);
        componentArray[2] = transform2D.transformInverse(e);
//        transform2D = new Transform2D(imageToMatrix(ImageIO.read(new File(s)), 3), c, d, f, g, b);
//        componentArray[3] = transform2D.transformInverse(e);
        /**/
//        ImageIO.write(transform2DToImage(componentArray), "png", new File("/home/guir/Imagens/test out.png"));
        final MainFrame gui = new MainFrame() {

            @Override
            public void onImageButtonPressed() {
                File file = fileOpen();
                if (file == null) {
                    return;
                }
                double c[] = parseDoubleArray(getFilterC());
                double d[] = parseDoubleArray(getFilterD());
                double f[] = parseDoubleArray(getFilterF());
                double g[] = parseDoubleArray(getFilterG());
                int level = getLevel();
                BufferedImage image;
                try {
                    image = ImageIO.read(file);
                } catch (IOException ex) {
                    showError(ex.getLocalizedMessage(), ex);
                    return;
                }
                int componentAmount = image.getRaster().getPixel(0, 0, (int[]) null).length;
                TransformData transformArray[] = new TransformData[componentAmount];
                for (int i = 0; i < componentAmount; i++) {
                    transformArray[i] = new Transform2D(imageToMatrix(image, i), c, d, f, g, level);
                }
                set.add(new Transform(transformArray, level));
            }
        };
    }
}
