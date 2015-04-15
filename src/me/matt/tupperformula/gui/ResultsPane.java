package me.matt.tupperformula.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultsPane {

    public static void displayResultsPane(final String binaryNumber,
            final String tupperValue) {
        final JTextArea binary = new JTextArea(binaryNumber);
        final JTextArea tupper = new JTextArea(tupperValue);

        binary.setEditable(false);
        tupper.setEditable(false);

        binary.setLineWrap(true);
        tupper.setLineWrap(true);

        binary.setToolTipText("This is the binary representation of the image you entered. The most signifigant bit is the bottom left of the image, while the least signifigant bit is the top right.");
        tupper.setToolTipText("This is your tupper constant. If you were to plot Tupper's self-referential formula, you would find your image at this y-value.");

        final JScrollPane binaryScrollPane = new JScrollPane(binary);
        final JScrollPane tupperScrollPane = new JScrollPane(tupper);
        binaryScrollPane.setPreferredSize(new Dimension(600, 200));
        tupperScrollPane.setPreferredSize(new Dimension(600, 200));

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 20));
        panel.add(binaryScrollPane, BorderLayout.NORTH);
        panel.add(tupperScrollPane, BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null, panel, "Results",
                JOptionPane.PLAIN_MESSAGE);
    }
}
