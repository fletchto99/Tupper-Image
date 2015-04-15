package me.matt.tupperformula.image;

import java.awt.image.BufferedImage;

import me.matt.tupperformula.Tupper.Constants;

public class ImageAnalyzer {

    public static String toBinaryString(final BufferedImage image) {
        String binaryRepresentation = "";
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = image.getHeight() - 1; y >= 0; y--) {
                binaryRepresentation += image.getRGB(x, y) == 0xFFFFFFFF ? "0"
                        : "1";
            }
        }
        return binaryRepresentation;
    }

    public static boolean verifyBinaryImage(final BufferedImage image) {
        if (image.getHeight() != Constants.TUPPER_HEIGHT
                || image.getWidth() != Constants.TUPPER_WIDTH) {
            return false;
        }
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                final int rgb = image.getRGB(x, y);
                if (rgb == 0xFFFFFFFF || rgb == 0xFF000000) {
                    continue;
                }
                System.out.println("x: " + x + "y:" + y + rgb);
                return false;
            }
        }
        return true;
    }
}
