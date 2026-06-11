public class Main {
    public static void main(String[] args) {

        String excelPath  = ".//data//student.xlsx";
        String pdfPath    = ".//data//student.pdf";
        String gradeName  = "1학년";

        try {

            Grade grade = ExcelReader.readExcel(excelPath, gradeName);


            System.out.println("=== " + grade.getGradeName() + " 학년 평균: " + grade.getGradeAvg() + " ===");
            for (ClassRoom cr : grade.getClassRooms()) {
                System.out.println("\n[" + cr.getClassName() + "]  반 평균: " + cr.getClassAvg());
                System.out.printf("%-10s %-6s %-4s %4s %4s %4s %4s %5s %7s %5s %5s%n",
                        "학번", "이름", "성별", "국어", "영어", "수학", "선택", "총점", "평균", "반석차", "학년석차");
                for (Student s : cr.getStudents()) {
                    Subject sub = s.getSubject();
                    System.out.printf("%-10s %-6s %-4s %4d %4d %4d %4d %5d %7.2f %5d %5d%n",
                            s.getHakbun(), s.getName(), s.getGender(),
                            sub.getKor(), sub.getEng(), sub.getMath(), sub.getOption(),
                            sub.getSum(), sub.getAvg(),
                            s.getRank(), s.getGradeRank());
                }
            }


            PdfWriter2.writePdf(grade, pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}