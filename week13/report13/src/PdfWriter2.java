import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfWriter2 {


    private static final String FONT_PATH = "/System/Library/Fonts/AppleSDGothicNeo.ttc,0";

    public static void writePdf(Grade grade, String outputPath) throws Exception {
        Document doc = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(doc, new FileOutputStream(outputPath));
        doc.open();

        BaseFont baseFont = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);


        Font titleFont = new Font(baseFont, 16, Font.BOLD, BaseColor.RED); // 크고 굵은 레드 제목
        Font headerFont = new Font(baseFont, 9, Font.BOLD);              // 표머리용 굵은 폰트
        Font dataBoldFont = new Font(baseFont, 9, Font.BOLD);            // 일반 데이터도 두껍게 처리
        Font blueBoldFont = new Font(baseFont, 11, Font.BOLD, BaseColor.BLUE); // 우측상단 및 석차용 크고 굵은 블루


        BaseColor lightYellow = new BaseColor(255, 255, 204);

        boolean firstPage = true;

        for (ClassRoom classRoom : grade.getClassRooms()) {
            if (!firstPage) {
                doc.newPage();
            }
            firstPage = false;


            Paragraph title = new Paragraph("1학년 A반 성적표", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);


            Paragraph classAvg = new Paragraph(
                    String.format("반 평균 : %06.2f", classRoom.getClassAvg()), blueBoldFont);
            classAvg.setAlignment(Element.ALIGN_RIGHT);
            doc.add(classAvg);

            Paragraph gradeAvg = new Paragraph(
                    String.format("학년 평균 : %06.2f", grade.getGradeAvg()), blueBoldFont);
            gradeAvg.setAlignment(Element.ALIGN_RIGHT);
            doc.add(gradeAvg);

            doc.add(new Paragraph(" "));

            float[] colWidths = {
                    55, 40, 18,
                    25, 25,
                    30, 30,
                    25, 25,
                    30, 30,
                    25, 35, 30, 30
            };

            PdfPTable table = new PdfPTable(colWidths.length);
            table.setWidthPercentage(100);
            table.setWidths(colWidths);

            String[] headers = {
                    "학번", "이름", "성별",
                    "국어\n점수", "국어\n학점",
                    "영어\n점수", "영어\n학점",
                    "수학\n점수", "수학\n학점",
                    "선택\n점수", "선택\n학점",
                    "총점", "평균", "반 석차", "학년\n석차"
            };


            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }

            List<Student> students = classRoom.getStudents();

            for (Student s : students) {
                Subject sub = s.getSubject();


                addCell(table, s.getHakbun(), dataBoldFont);
                addCell(table, s.getName(), dataBoldFont);
                addCell(table, s.getGender(), dataBoldFont);

                addCell(table, String.valueOf(sub.getKor()), dataBoldFont);
                addCell(table, sub.getKorGrade(), dataBoldFont);

                addCell(table, String.valueOf(sub.getEng()), dataBoldFont);
                addCell(table, sub.getEngGrade(), dataBoldFont);

                addCell(table, String.valueOf(sub.getMath()), dataBoldFont);
                addCell(table, sub.getMathGrade(), dataBoldFont);

                addCell(table, String.valueOf(sub.getOption()), dataBoldFont);
                addCell(table, sub.getOptionGrade(), dataBoldFont);

                addCell(table, String.valueOf(sub.getSum()), dataBoldFont);
                addCell(table, String.format("%.2f", sub.getAvg()), dataBoldFont);


                addCell(table, String.valueOf(s.getRank()), blueBoldFont, lightYellow);
                addCell(table, String.valueOf(s.getGradeRank()), blueBoldFont, lightYellow);
            }

            doc.add(table);
        }

        doc.close();
        System.out.println("PDF 저장 완료: " + outputPath);
    }


    private static void addCell(PdfPTable table, String text, Font font) {
        addCell(table, text, font, null);
    }


    private static void addCell(PdfPTable table, String text, Font font, BaseColor backgroundColor) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if (backgroundColor != null) {
            cell.setBackgroundColor(backgroundColor);
        }
        table.addCell(cell);
    }
}