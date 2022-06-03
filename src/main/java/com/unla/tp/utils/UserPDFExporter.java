package com.unla.tp.utils;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.tp.entities.User;

public class UserPDFExporter {
    private List<User> users;

    public UserPDFExporter(List<User> users) {
        this.users = users;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.getHSBColor(345.0f, 0.94f, 0.63f));
        cell.setPadding(4);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(10);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("User ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Apellido", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rol", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Habilitado", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (User user : users) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getEmail());
            table.addCell(user.getNombre());
            table.addCell(user.getApellido());
            table.addCell(user.getRole().toString());
            table.addCell(String.valueOf(user.isEnabled()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(14);
        font.setColor(Color.getHSBColor(345.0f, 0.94f, 0.63f));

        Paragraph p1 = new Paragraph("UNLa - Gestión de Aulas", font);
        p1.setAlignment(Element.ALIGN_TOP);
        document.add(p1);

        Paragraph p = new Paragraph("Listado de Usuarios", font);
        p.setAlignment(Element.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] { 1.2f, 3.5f, 2.7f, 2.7f, 3.0f, 1.7f });
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
