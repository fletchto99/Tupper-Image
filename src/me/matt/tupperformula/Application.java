package me.matt.tupperformula;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.matt.tupperformula.Tupper.TupperDecoder;
import me.matt.tupperformula.Tupper.TupperEncoder;
import me.matt.tupperformula.exception.CancleException;
import me.matt.tupperformula.exception.EncoderException;
import me.matt.tupperformula.exception.ImageVerificationException;
import me.matt.tupperformula.gui.ResultsPane;
import me.matt.tupperformula.image.ImageLoader;
import me.matt.tupperformula.image.ImageSaver;

public class Application {

    public static void main(final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities
                .invokeLater(() -> {
                    try {
                        final String option = (String) JOptionPane
                                .showInputDialog(null, "", "Method Selection",
                                        JOptionPane.PLAIN_MESSAGE, null,
                                        new String[] { "Open Tupper Image",
                                                "Save Tupper Image" }, null);
                        if (option == "Open Tupper Image") {
                            final TupperDecoder decoder = new TupperDecoder(
                                    ImageLoader.loadImage());
                            ResultsPane.displayResultsPane(
                                    decoder.binaryRepresentation(),
                                    decoder.decode());
                        } else {
                            final String tupper = JOptionPane
                                    .showInputDialog("What is your tupper number");
                            final String encodedValue = TupperEncoder
                                    .encode(tupper);
                            ImageSaver.saveBMP(encodedValue);
                        }
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(null,
                                "Error Loading File.");
                    } catch (final ImageVerificationException e) {
                        JOptionPane
                                .showMessageDialog(
                                        null,
                                        "Invalid Image. Please ensure the file is a 106x17 bitmap containing only black and white pixles");

                    } catch (final EncoderException e) {
                        JOptionPane.showMessageDialog(null,
                                "Invalid tupper number entered!");
                    } catch (NullPointerException | CancleException e) {
                        System.exit(0);
                    }
                });
    }
}
