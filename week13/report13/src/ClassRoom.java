import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private String className;
    private List<Student> students;

    public ClassRoom(String className) {
        this.className = className;
        this.students  = new ArrayList<>();
    }

    public String getClassName()       { return className; }
    public List<Student> getStudents() { return students; }

    public void addStudent(Student s)  { students.add(s); }


    public double getClassAvg() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student s : students) {
            total += s.getSubject().getAvg();
        }
        return Math.round((total / students.size()) * 100.0) / 100.0;
    }


    public void calcRank() {
        for (Student s : students) {
            int rank = 1;
            for (Student other : students) {
                if (other.getSubject().getSum() > s.getSubject().getSum()) {
                    rank++;
                }
            }
            s.setRank(rank);
        }
    }
}