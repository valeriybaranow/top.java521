package org.example;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentParser {
    Map<String, String> data = new HashMap<>();

    public void parse(PDDocument migrationCard) throws IOException, TesseractException {
        PDFRenderer renderer = new PDFRenderer(migrationCard);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("resources/tessdata"); // Путь к tessdata
        tesseract.setLanguage("rus+eng"); // Языки распознавания
        tesseract.setTessVariable("user_defined_dpi", "300"); // Явно указываем DPI

        StringBuilder fullText = new StringBuilder();

        for (int i = 0; i < migrationCard.getNumberOfPages(); i++) {
            BufferedImage image = renderer.renderImage(i);
            String text = tesseract.doOCR(image);
            fullText.append(text);
        }

        Map<String, String> result = parsePdfData(fullText.toString());
        System.out.println(fullText);
    }

    private Map<String, String> parsePdfData(String text) {
        extractField(text, "вн \\[Ег \\| (\\d{4})", "serial");
        extractField(text, "№ \\| (\\d{7})", "number");

        return data;
    }

    private void extractField(String text, String regex, String fieldName) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            data.put(fieldName, matcher.group(1).trim());
        }
    }
}
