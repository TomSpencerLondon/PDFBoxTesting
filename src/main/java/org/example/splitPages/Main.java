package org.example.splitPages;

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

        List<PDDocument> splitPages = splitter.split(document);
        int fileNumber = 0;
        for (PDDocument myDoc : splitPages) {
            Path resourcePath = Paths.get("src", "main", "resources", String.format("sample-pdf-%s.pdf", fileNumber++));
            myDoc.save(resourcePath.toString());
            myDoc.close();
        }

        System.out.println("Split Done");
    }
}
