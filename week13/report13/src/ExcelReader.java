import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static Grade readExcel(String filePath, String gradeName) throws Exception {
        Grade grade = new Grade(gradeName);

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        int sheetCount = workbook.getNumberOfSheets();

        for (int si = 0; si < sheetCount; si++) {
            Sheet sheet = workbook.getSheetAt(si);
            String className = sheet.getSheetName();
            ClassRoom classRoom = new ClassRoom(className);

            for (int ri = 1; ri <= sheet.getLastRowNum(); ri++) {
                Row row = sheet.getRow(ri);
                if (row == null) continue;


                Cell firstCell = row.getCell(0);
                if (firstCell == null || firstCell.getCellType() == CellType.BLANK) continue;

                String hakbun = getCellString(row.getCell(0));
                String name   = getCellString(row.getCell(1));
                String gender = getCellString(row.getCell(2));
                int kor    = (int) row.getCell(3).getNumericCellValue();
                int eng    = (int) row.getCell(4).getNumericCellValue();
                int math   = (int) row.getCell(5).getNumericCellValue();
                int option = (int) row.getCell(6).getNumericCellValue();

                Subject subject = new Subject(kor, eng, math, option);
                Student student = new Student(hakbun, name, gender, subject);
                classRoom.addStudent(student);
            }


            classRoom.calcRank();
            grade.addClassRoom(classRoom);
        }

        workbook.close();
        fis.close();


        grade.calcGradeRank();

        return grade;
    }

    private static String getCellString(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        }
        return cell.getStringCellValue().trim();
    }
}