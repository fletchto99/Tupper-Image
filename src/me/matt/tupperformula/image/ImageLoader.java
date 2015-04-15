package me.matt.tupperformula.image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import me.matt.tupperformula.exception.CancleException;
import me.matt.tupperformula.exception.ImageVerificationException;

public class ImageLoader {

    public static BufferedImage loadImage() throws IOException,
            CancleException, ImageVerificationException {
        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("BITMAP", "bmp"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        final int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            final BufferedImage image = ImageIO.read(chooser.getSelectedFile());
            if (ImageAnalyzer.verifyBinaryImage(image)) {
                return image;
            }
            throw new ImageVerificationException();
        }
        throw new CancleException();
    }

}
