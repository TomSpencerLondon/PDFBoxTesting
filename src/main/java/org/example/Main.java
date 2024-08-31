package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path resourcePath = Paths.get("src", "main", "resources", "myDocument.pdf");

        PDDocument document = new PDDocument();

        document.save(resourcePath.toString());
    }
}