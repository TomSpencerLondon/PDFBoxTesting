package org.example.documentProperties;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

        Path resourcePath = Paths.get("src", "main", "resources", "properties.pdf");
        document.save(resourcePath.toString());
        document.close();

        System.out.println("First Page added to PDF");




    }
}
