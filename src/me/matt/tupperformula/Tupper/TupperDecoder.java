package me.matt.tupperformula.Tupper;

import java.awt.image.BufferedImage;
import java.math.BigInteger;

import me.matt.tupperformula.image.ImageAnalyzer;

public class TupperDecoder {

    private final BigInteger binaryImage;

    public TupperDecoder(final BufferedImage image) {
        binaryImage = new BigInteger(ImageAnalyzer.toBinaryString(image), 2);
    }

    public String binaryRepresentation() {
        return binaryImage.toString(2);
    }

    public String decode() {
        return "k = "
                + binaryImage.multiply(Constants.TUPPER_BINARY_CONSTANT)
                        .toString();
    }
}
