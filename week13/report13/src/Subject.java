public class Subject {
    private int kor;
    private int eng;
    private int math;
    private int option; // 기술(남) or 가정(여)

    public Subject() {}

    public Subject(int kor, int eng, int math, int option) {
        this.kor    = kor;
        this.eng    = eng;
        this.math   = math;
        this.option = option;
    }

    public int getKor()    { return kor; }
    public int getEng()    { return eng; }
    public int getMath()   { return math; }
    public int getOption() { return option; }

    public void setKor(int kor)       { this.kor = kor; }
    public void setEng(int eng)       { this.eng = eng; }
    public void setMath(int math)     { this.math = math; }
    public void setOption(int option) { this.option = option; }

    // 국어 평점: 수/우/미/양/가  (switch~case)
    public String getKorGrade() {
        switch (kor / 10) {
            case 10:
            case 9:  return "수";
            case 8:  return "우";
            case 7:  return "미";
            case 6:  return "양";
            default: return "가";
        }
    }


    public String getLetterGrade(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                if (score >= 95) return "A+";
                else             return "A0";
            case 8:
                if (score >= 85) return "B+";
                else             return "B0";
            case 7:
                if (score >= 75) return "C+";
                else             return "C0";
            case 6:
                if (score >= 65) return "D+";
                else             return "D0";
            default:             return "F";
        }
    }

    public String getEngGrade()  { return getLetterGrade(eng); }
    public String getMathGrade() { return getLetterGrade(math); }


    public String getOptionGrade() {
        if      (option >= 90) return "A";
        else if (option >= 80) return "B";
        else if (option >= 70) return "C";
        else if (option >= 60) return "D";
        else                   return "F";
    }


    public int getSum() {
        return kor + eng + math + option;
    }


    public double getAvg() {
        return Math.round((getSum() / 4.0) * 100.0) / 100.0;
    }
}