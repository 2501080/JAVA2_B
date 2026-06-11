import java.time.LocalDate;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        int age = today.getYear() - birthday.getYear();

        if (today.getDayOfYear() < birthday.getDayOfYear()) {
            age--;
        }

        return age;
    }

    @Override
    public String toString() {
        return String.format("%04d년 %02d월 %02d일",
                year, month, day);
    }
}
