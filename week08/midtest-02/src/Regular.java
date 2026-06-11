import java.util.Scanner;

public class Regular extends Employee {
    private static final int[][] BASE_PAY_TABLE = {
            {2_600_000, 2_800_000, 3_100_000, 3_400_000, 3_800_000},
            {2_650_000, 2_860_000, 3_170_000, 3_480_000, 3_890_000},
            {2_700_000, 2_920_000, 3_240_000, 3_560_000, 3_980_000},
            {2_750_000, 2_980_000, 3_310_000, 3_640_000, 4_070_000},
            {2_800_000, 3_040_000, 3_380_000, 3_720_000, 4_160_000}
    };

    public Regular(String employeeID, String name, Date birthday, char grade, char step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.printf("[정규직] %s : 추가 입력 없음%n", getName());
    }

    @Override
    public int pay() {
        return getBasePay();
    }

    @Override
    public String type() {
        return "정규직";
    }

    @Override
    public int getBasePay() {
        int gradeIndex = getGrade() - '1';
        int stepIndex = getStep() - '1';

        if (gradeIndex < 0 || gradeIndex >= 5 || stepIndex < 0 || stepIndex >= 5) {
            return 0;
        }

        return BASE_PAY_TABLE[stepIndex][gradeIndex];
    }
}
