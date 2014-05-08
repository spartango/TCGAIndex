package com.irislabs.deploy;

import com.irislabs.tcga.SlideIndex;
import com.irislabs.tcga.TCGAConstants;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Author: spartango
 * Date: 5/8/14
 * Time: 1:47 PM.
 */
public class Main {

    public static void main(String[] args) {
        final String selection = TCGAConstants.DISEASES.get(JOptionPane.showInputDialog(null,
                                                                                        "Choose Study",
                                                                                        "Choose Study",
                                                                                        JOptionPane.QUESTION_MESSAGE,
                                                                                        null,
                                                                                        TCGAConstants.DISEASES.keySet()
                                                                                                              .toArray(),
                                                                                        "Breast invasive carcinoma"
        ));

        if (selection == null) {
            System.err.println("No study selected!");
            return;
        }

        System.out.println("Searching for " + selection + " slides...");

        SlideIndex index = new SlideIndex(selection, SlideIndex.FFPE_AND_FROZEN);

        System.out.println(index.getSlideUrls().size()
                           + " slides found for "
                           + index.getSlideUrls().keySet().size()
                           + " patients");

        try {
            FileWriter writer = new FileWriter(selection + "_slides.txt");
            for (Map.Entry<String, String> entry : index.getSlideUrls().entries()) {
                writer.write(entry.getKey() + "\t"
                             + (entry.getValue().contains("-DX") ? "FFPE" : "Frozen") + "\t"
                             + entry.getValue() + "\n");

            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to write list because of " + e);
        }

        JOptionPane.showMessageDialog(null, index.getSlideUrls().size()
                                            + " slides found for "
                                            + index.getSlideUrls().keySet().size()
                                            + " "
                                            + selection
                                            + " patients");
    }
}
