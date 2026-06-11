import java.util.Scanner;

public class Researcher extends Regular {
    private static final int RESEARCH_ALLOWANCE = 300_000;

    public Researcher(String employeeID, String name, Date birthday, char grade, char step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.printf("[연구직] %s : 추가 입력 없음%n", getName());
    }

    @Override
    public int pay() {
        return getBasePay() + RESEARCH_ALLOWANCE;
    }

    @Override
    protected int taxablePay() {
        return getBasePay();
    }

    @Override
    public String type() {
        return "연구직";
    }

    @Override
    public int getResearchAllowance() {
        return RESEARCH_ALLOWANCE;
    }
}
