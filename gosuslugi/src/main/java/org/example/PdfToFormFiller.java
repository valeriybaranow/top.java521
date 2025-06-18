package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;


public class PdfToFormFiller {
    public static void main(String[] args) {
        try (
                PDDocument migrationCard = PDDocument.load(new File("data/gosuslugi/imonjon/migration.pdf"));
                PDDocument passport = PDDocument.load(new File("data/gosuslugi/imonjon/passport.pdf"));
        ) {
            DocumentParser documentParser = new DocumentParser();
            documentParser.parse(migrationCard);
            documentParser.parse(passport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}