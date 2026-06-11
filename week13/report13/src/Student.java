public class Student extends Person {
    private Subject subject;
    private int rank;
    private int gradeRank;

    public Student() {}

    public Student(String hakbun, String name, String gender, Subject subject) {
        super(hakbun, name, gender);
        this.subject = subject;
    }

    public Subject getSubject()  { return subject; }
    public int getRank()         { return rank; }
    public int getGradeRank()    { return gradeRank; }

    public void setSubject(Subject subject) { this.subject = subject; }
    public void setRank(int rank)           { this.rank = rank; }
    public void setGradeRank(int gradeRank) { this.gradeRank = gradeRank; }
}