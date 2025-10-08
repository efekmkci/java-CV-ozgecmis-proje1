// CvGenerator.java 

package org.example; 

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font; 
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.Color;
import java.io.File; 
import java.io.IOException;
import java.util.List;

public class CvGenerator {

    public void generate(Person person, List<JobExperience> experiences, String filePath) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

       
        PDType0Font fontRegular = PDType0Font.load(document, new File("src/main/resources/DejaVuSans.ttf"));
        PDType0Font fontBold = PDType0Font.load(document, new File("src/main/resources/DejaVuSans-Bold.ttf"));
        PDType0Font fontItalic = PDType0Font.load(document, new File("src/main/resources/DejaVuSans-Oblique.ttf"));
     

        PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/profile-photo.jpg", document);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.drawImage(pdImage, 450, 675, 100, 120);

     
        contentStream.beginText();
        contentStream.setFont(fontBold, 24); // Değişti
        contentStream.setNonStrokingColor(Color.DARK_GRAY);
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText(person.getFullName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(fontRegular, 12); // Değişti
        contentStream.setNonStrokingColor(Color.GRAY);
        contentStream.newLineAtOffset(50, 730);
        contentStream.showText(person.getEmail() + " | " + person.getPhoneNumber());
        contentStream.newLine();
        contentStream.setLeading(15f);
        contentStream.newLineAtOffset(0, -15);
        contentStream.showText(person.getAddress());
        contentStream.endText();

        addSectionTitle(contentStream, "Özet", 50, 680, fontBold); // Değişti
        float currentY = addParagraph(contentStream, person.getSummary(), 50, 660, 500, fontRegular); // Değişti

        addSectionTitle(contentStream, "İş Deneyimi", 50, currentY - 40, fontBold); // Değişti
        currentY = currentY - 60; // İş deneyimlerinin yazılmaya başlayacağı Y koordinatı

        for (JobExperience job : experiences) {
            contentStream.beginText();
            contentStream.setFont(fontBold, 12); // Değişti
            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.newLineAtOffset(50, currentY);
            contentStream.showText(job.getJobTitle());
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(fontItalic, 10); // Değişti
            contentStream.setNonStrokingColor(Color.DARK_GRAY);
            contentStream.newLineAtOffset(50, currentY - 15);
            contentStream.showText(job.getCompany() + " | " + job.getDates());
            contentStream.endText();

            currentY = addParagraph(contentStream, job.getDescription(), 60, currentY - 30, 480, fontRegular); // Değişti
            currentY -= 20;
        }

        contentStream.close();

        document.save(filePath);
        document.close();

        System.out.println("CV başarıyla oluşturuldu: " + filePath);
    }

 
    private void addSectionTitle(PDPageContentStream contentStream, String title, float x, float y, PDType0Font font) throws IOException { // Değişti
        contentStream.beginText();
        contentStream.setFont(font, 16); // Değişti
        contentStream.setNonStrokingColor(new Color(0, 76, 153));
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(title);
        contentStream.endText();
        contentStream.setStrokingColor(new Color(0, 76, 153));
        contentStream.moveTo(x, y - 5);
        contentStream.lineTo(x + 500, y - 5);
        contentStream.stroke();
    }

    private float addParagraph(PDPageContentStream contentStream, String text, float x, float y, float width, PDType0Font font) throws IOException { // Değişti
        float fontSize = 10;
        float leading = 1.5f * fontSize;
        contentStream.setFont(font, fontSize); // Değişti
        contentStream.setNonStrokingColor(Color.BLACK);

        String[] words = text.split(" ");
        String line = "";
        float currentY = y;

        for (String word : words) {
            float size = fontSize * font.getStringWidth(line + word) / 1000; // Değişti
            if (size > width) {
                contentStream.beginText();
                contentStream.newLineAtOffset(x, currentY);
                contentStream.showText(line);
                contentStream.endText();
                line = word + " ";
                currentY -= leading;
            } else {
                line += word + " ";
            }
        }
        contentStream.beginText();
        contentStream.newLineAtOffset(x, currentY);
        contentStream.showText(line);
        contentStream.endText();

        return currentY;
    }
}
