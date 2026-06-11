import java.io.IOException;
import java.util.Scanner;

public abstract class Employee extends Staff implements MyProject {
    private char grade;
    private char step;

    public Employee(String employeeID, String name, Date birthday, char grade, char step) {
        super(employeeID, name, birthday);
        this.grade = grade;
        this.step = step;
    }

    public abstract void input(Scanner scanner) throws IOException;

    protected int taxablePay() {
        return pay();
    }

    @Override
    public int tax() {
        int taxablePay = taxablePay();

        if (this instanceof Temporary || taxablePay <= 2_000_000) {
            return (int)(taxablePay * 0.066);
        }
        if (taxablePay <= 4_000_000) {
            return (int)(taxablePay * 0.073);
        }
        return (int)(taxablePay * 0.085);
    }

    @Override
    public int realPay() {
        return pay() - tax();
    }

    public char getGrade() {
        return grade;
    }

    public char getStep() {
        return step;
    }

    public int getDay() {
        return 0;
    }

    public int getDailyPay() {
        return 0;
    }

    public int getBasePay() {
        return 0;
    }

    public int getSale() {
        return 0;
    }

    public double getCommissionRate() {
        return 0.0;
    }

    public int getCommission() {
        return 0;
    }

    public int getAllowance() {
        return 0;
    }

    public int getResearchAllowance() {
        return 0;
    }

    public void display() {
        System.out.printf(
                "%-8s %-22s %-8s %6d %,9d %,11d %,11d %,11d %,11d %,11d %,9d %,11d  %-6s%n",
                getEmployeeID(), getName() + "(" + getBirthday() + ")", getGradeStep(),
                getDay(), getDailyPay(), getBasePay(), getCommission(), getAllowance(),
                getResearchAllowance(), pay(), tax(), realPay(), type()
        );
    }
    public String getGradeStep() {
        return String.format("%c급-%c호", getGrade(), getStep());
    }
}
