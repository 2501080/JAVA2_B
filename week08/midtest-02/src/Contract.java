import java.util.Scanner;

public class Contract extends Employee {
    private static final int CONTRACT_PAY = 2_000_000;

    public Contract(String employeeID, String name, Date birthday) {
        super(employeeID, name, birthday, '0', '0');
    }

    @Override
    public void input(Scanner scanner) {
        System.out.printf("[계약직] %s : 추가 입력 없음%n", getName());
    }

    @Override
    public int pay() {
        return CONTRACT_PAY;
    }

    @Override
    public String type() {
        return "계약직";
    }

    @Override
    public int getBasePay() {
        return CONTRACT_PAY;
    }
}
