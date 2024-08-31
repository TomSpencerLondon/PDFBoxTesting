package org.example.loadPDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("/Users/tspencer/Desktop/sample-pdf.pdf");
        Path resourcePath = Paths.get("src", "main", "resources", "sample-pdf-1.pdf");
        PDDocument document = PDDocument.load(oldFile);
        document.addPage(new PDPage());
        document.save(resourcePath.toString());
    }
}
