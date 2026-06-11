import java.io.IOException;
import java.util.Scanner;

abstract class Employee implements MyProject {
    int id; String name; char grade, ho;

    public Employee(int id, String name, char grade, char ho) {
        this.id = id; this.name = name; this.grade = grade; this.ho = ho;
    }

    public abstract void input(Scanner sc) throws IOException;


    public int tax() {
        int p = pay();
        if (this instanceof Temporary) return (int)(p * 0.066);
        if (p <= 2000000) return (int)(p * 0.066);
        else if (p <= 4000000) return (int)(p * 0.085);
        else return (int)(p * 0.1);
    }

    public int realPay() { return pay() - tax(); }

    public void display() {
        System.out.printf("%-8d %-5s %c-%c %4d %,8d원 %,9d원 %,8d원 %,8d원 %,9d원 %,10d원 %,10d원 %,10d원 %-6s\n",
                id, name, grade, ho, getDay(), getDailyPay(), getSalary(),
                getIncentive(), getCommission(), getResearchAllowance(), pay(), tax(), realPay(), type());
    }


    public int getDay() { return 0; }
    public int getDailyPay() { return 0; }
    public int getSalary() { return 0; }
    public int getIncentive() { return 0; }
    public int getCommission() { return 0; }
    public int getResearchAllowance() { return 0; }
}