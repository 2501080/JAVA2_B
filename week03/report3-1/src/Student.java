import java.time.LocalDate;
import java.time.Period;

public class Student {
    protected String name;
    protected int number;
    protected String depart;
    protected LocalDate birthday;

    public Student(String name, int number, String depart, String birthday) {
        this.name = name;
        this.number = number;
        this.depart = depart;
        this.birthday = LocalDate.parse(birthday);
    }

    public int getAge() {
        LocalDate today = LocalDate.now(); // 현재 날짜
        return Period.between(this.birthday, today).getYears();
    }


    public void printInfo() {
        System.out.println("--- 학생 정보 ---");
        System.out.printf("이름: %s\n",name);
        System.out.printf("학번: %d\n", number);
        System.out.printf("학과: %s\n", depart);
        System.out.printf("생년월일: %s\n", birthday);
        System.out.printf("현재 나이: %d 세\n", getAge());
    }
}
