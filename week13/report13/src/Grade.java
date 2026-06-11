import java.util.ArrayList;
import java.util.List;

public class Grade {
    private String gradeName;
    private List<ClassRoom> classRooms;

    public Grade(String gradeName) {
        this.gradeName  = gradeName;
        this.classRooms = new ArrayList<>();
    }

    public String getGradeName()            { return gradeName; }
    public List<ClassRoom> getClassRooms()  { return classRooms; }

    public void addClassRoom(ClassRoom cr)  { classRooms.add(cr); }


    public List<Student> getAllStudents() {
        List<Student> all = new ArrayList<>();
        for (ClassRoom cr : classRooms) {
            all.addAll(cr.getStudents());
        }
        return all;
    }


    public double getGradeAvg() {
        List<Student> all = getAllStudents();
        if (all.isEmpty()) return 0;
        double total = 0;
        for (Student s : all) total += s.getSubject().getAvg();
        return Math.round((total / all.size()) * 100.0) / 100.0;
    }


    public void calcGradeRank() {
        List<Student> all = getAllStudents();
        for (Student s : all) {
            int rank = 1;
            for (Student other : all) {
                if (other.getSubject().getSum() > s.getSubject().getSum()) {
                    rank++;
                }
            }
            s.setGradeRank(rank);
        }
    }
}