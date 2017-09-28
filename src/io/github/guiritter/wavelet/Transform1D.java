package io.github.guiritter.wavelet;

import static io.github.guiritter.wavelet.Math.box;
import static io.github.guiritter.wavelet.Math.convolution;
import static io.github.guiritter.wavelet.Math.downsample;
import static io.github.guiritter.wavelet.Math.unbox;
import static java.lang.Math.sqrt;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Guilherme Alan Ritter
 */
public final class Transform1D {

    private final LinkedList<Double[]> detailList = new LinkedList<>();

    /**
     * Low pass synthesis filter;
     */
    private final double filterC[];

    /**
     * High pass synthesis filter;
     */
    private final double filterD[];

    /**
     * Low pass analysis filter;
     */
    private final double filterF[];

    /**
     * High pass analysis filter;
     */
    private final double filterG[];

    private int i;

    private int j;

    private double returnArrayArray[][];

    /**
     * First element is the original signal.
     */
    private double smooth[];

    private double vDetail[];

    private double vSmooth[];

    private double yDetail[];

    private double ySmooth[];

    public void transformForward() {
        detailList.add(box(downsample(convolution(smooth, filterD))));
        smooth = downsample(convolution(smooth, filterC));
        /*
        System.out.println("smooth " + detailList.size());
        System.out.println(Arrays.toString(smooth));
        System.out.println("detail " + detailList.size());
        System.out.println(Arrays.toString(detailList.getLast()));
        /**/
    }

    public double[][] transformInverse(int J) {
        if (J < 0) {
            returnArrayArray = null;
        } else if (J > detailList.size()) {
            for (i = detailList.size(); i < J; i++) {
                transformForward();
            }
        }
        if (J == detailList.size()) {
            returnArrayArray = new double[J + 1][];
            returnArrayArray[0] = new double[smooth.length];
            System.arraycopy(smooth, 0, returnArrayArray[0], 0, smooth.length);
            for (i = 0; i < detailList.size(); i++) {
                returnArrayArray[i + 1] = unbox(detailList.get(detailList.size() - i - 1));
            }
        } else if (J < detailList.size()) {
            // TODO
        }
        return returnArrayArray;
    }

    public Transform1D(double[] original, double[] filterC, double[] filterD, double[] filterF, double[] filterG, int J) {
             smooth = new double[original.length]; System.arraycopy(original, 0, smooth, 0, original.length);
        this.filterC = new double[filterC.length]; System.arraycopy(filterC, 0, this.filterC, 0, filterC.length);
        this.filterD = new double[filterD.length]; System.arraycopy(filterD, 0, this.filterD, 0, filterD.length);
        this.filterF = new double[filterF.length]; System.arraycopy(filterF, 0, this.filterF, 0, filterF.length);
        this.filterG = new double[filterG.length]; System.arraycopy(filterG, 0, this.filterG, 0, filterG.length);
        for (i = 0; i < J; i++) {
            transformForward();
        }
        /*
        double y0[] = convolution(original, filterC);
        double y1[] = convolution(original, filterD);
        double v0[] = downsample(y0);
        double v1[] = downsample(y1);
        double u0[] = upsample(v0);
        double u1[] = upsample(v1);
        double w0[] = convolution(u0, filterF);
        double w1[] = convolution(u1, filterG);
        */
//        System.out.println(Arrays.toString(v0));
//        System.out.println(Arrays.toString(v1));
//        System.out.println();
//        for (int i = 0; i < w0.length; i++) {
//            System.out.print(w0[i] + w1[i]);
//            System.out.print("\t");
//        }
//        System.out.println();
    }

    public static void main(String args[]) {
        double x = 1 / sqrt(2);
        Transform1D transform1D = new Transform1D(
         TestData.signalWithNoise,
         new double[]{x, x},
         new double[]{x, -x},
         new double[]{x, x},
         new double[]{-x, x},
         4);
//        transform1D.transformForward();
//        transform1D.transformForward();
//        transform1D.transformForward();
//        transform1D.transformForward();
        double transformInverse[][] = transform1D.transformInverse(4);
        System.out.println(Arrays.deepToString(transformInverse));
    }
}
