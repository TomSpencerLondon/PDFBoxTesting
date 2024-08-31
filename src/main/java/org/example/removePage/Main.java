package org.example.removePage;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("/Users/tspencer/Desktop/50-page-sample.pdf");

        PDDocument document = PDDocument.load(oldFile);
        document.removePage(0);

        Path resourcePath = Paths.get("src", "main", "resources", "removed-page.pdf");
        document.save(resourcePath.toString());
        document.close();

        System.out.println("Removed 1st page");

        File oldFile2 = new File("/Users/tspencer/Desktop/50-page-sample.pdf");
        PDDocument document2 = PDDocument.load(oldFile2);
        int pageRangeStart = 1;
        int pageRangeEnd = 20;

        for (int i = pageRangeEnd; i >= pageRangeStart; i--) {
            document2.removePage(i - 1);
        }
        Path resourcePath2 = Paths.get("src", "main", "resources", "removed-range.pdf");
        document2.save(resourcePath2.toString());
        document2.close();

        System.out.println("Deleted first 20 pages");
    }
}
