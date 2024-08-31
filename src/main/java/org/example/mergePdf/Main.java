package org.example.mergePdf;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File firstFile = new File("/Users/tspencer/Desktop/50-page-sample.pdf");
        File secondFile = new File("/Users/tspencer/Desktop/sample-pdf.pdf");
        Path resultPath = Paths.get("src", "main", "resources", "merged.pdf");

        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.setDestinationFileName(resultPath.toString());

        pdfMergerUtility.addSource(firstFile);
        pdfMergerUtility.addSource(secondFile);

        pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        System.out.println("PDFs merged");
    }
}
