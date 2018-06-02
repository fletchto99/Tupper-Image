package me.matt.tupperformula.Tupper;

import java.awt.image.BufferedImage;
import java.math.BigInteger;

import me.matt.tupperformula.image.ImageAnalyzer;

public class TupperDecoder {

    private final String binaryRepresentation;

    public TupperDecoder(final BufferedImage image) {
        binaryRepresentation = ImageAnalyzer.toBinaryString(image);
    }

    public String binaryRepresentation() {
        return binaryRepresentation;
    }

    public String decode() {
        return "k = "  + new BigInteger(binaryRepresentation, 2).multiply(Constants.TUPPER_CONSTANT).toString();
    }
}
