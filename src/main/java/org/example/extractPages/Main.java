package org.example.extractPages;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File oldFile = new File("/Users/tspencer/Desktop/50-page-sample.pdf");
        PDDocument document = PDDocument.load(oldFile);

        Splitter splitter = new Splitter();
        splitter.setStartPage(11);
        splitter.setEndPage(20);

        List<PDDocument> splitPages = splitter.split(document);
        PDDocument newDocument = new PDDocument();

        Path resourcePath = Paths.get("src", "main", "resources", "split-pages", "split.pdf");
        for (PDDocument myDocument : splitPages) {
            newDocument.addPage(myDocument.getPage(0));
        }

        newDocument.save(resourcePath.toString());
        newDocument.close();
        System.out.println("PDF Created");

    }
}
