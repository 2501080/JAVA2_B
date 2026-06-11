
public class Date {
    int year;
    int month;
    int day;

    public Date(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d; }

    @Override
    public String toString() {
        return String.format("%d년 %d월 %d일",
                year,month,day);
    }
}


