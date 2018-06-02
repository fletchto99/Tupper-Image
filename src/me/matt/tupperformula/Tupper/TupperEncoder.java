package me.matt.tupperformula.Tupper;

import java.math.BigInteger;

import me.matt.tupperformula.exception.EncoderException;

public class TupperEncoder {

    public static String encode(final String tupperValue)
            throws EncoderException {
        if (!tupperValue.matches("[0-9]+")) {
            throw new EncoderException();
        }
        String binaryString = new BigInteger(tupperValue).divide(
                Constants.TUPPER_CONSTANT).toString(2);
        if (binaryString.length() < Constants.TUPPER_BINARY_POWER) {
            while (binaryString.length() < 1802) {
                binaryString = "0" + binaryString;
            }
        } else if (binaryString.length() > Constants.TUPPER_BINARY_POWER) {
            throw new EncoderException();
        }
        return binaryString;
    }
}
