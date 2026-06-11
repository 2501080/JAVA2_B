import java.util.Scanner;

public class Manager extends Regular {
    public Manager(String employeeID, String name, Date birthday, char grade, char step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.printf("[점장직] %s : 추가 입력 없음%n", getName());
    }

    @Override
    public int pay() {
        return getBasePay() + getAllowance();
    }

    @Override
    public String type() {
        return "점장직";
    }

    @Override
    public int getAllowance() {
        int basePay = getBasePay();

        if (basePay <= 1_800_000) {
            return (int)(basePay * 0.06);
        }
        if (basePay <= 2_400_000) {
            return (int)(basePay * 0.05);
        }
        return (int)(basePay * 0.04);
    }
}
