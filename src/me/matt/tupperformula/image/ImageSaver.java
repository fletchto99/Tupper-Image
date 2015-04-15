package me.matt.tupperformula.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import me.matt.tupperformula.Tupper.Constants;
import me.matt.tupperformula.exception.CancleException;

public class ImageSaver {

    public static void saveBMP(final String positions) throws IOException,
            CancleException {

        final JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("BITMAP", "bmp"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        final int choice = chooser.showSaveDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {

            final BufferedImage image = new BufferedImage(
                    Constants.TUPPER_WIDTH, Constants.TUPPER_HEIGHT,
                    BufferedImage.TYPE_BYTE_BINARY);
            final Graphics g = image.getGraphics();

            g.setColor(Color.WHITE);

            for (int x = 0; x < Constants.TUPPER_WIDTH; x++) {
                for (int y = 0; y < Constants.TUPPER_HEIGHT; y++) {
                    if (positions.charAt((x * (Constants.TUPPER_HEIGHT)) + y) == '0') {
                        g.fillRect(x, 16 - y, 1, 1);
                    }
                }
            }

            ImageIO.write(
                    image,
                    "BMP",
                    new File(chooser.getSelectedFile()
                            + (chooser.getSelectedFile().getName()
                                    .endsWith(".bmp") ? "" : ".bmp")));
            g.dispose();
            System.exit(0);
        } else {
            throw new CancleException();
        }

    }
}