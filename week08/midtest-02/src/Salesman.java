import java.util.Scanner;

public class Salesman extends Regular {
    private int sale;
    private double commissionRate;

    public Salesman(String employeeID, String name, Date birthday, char grade, char step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    public void input(Scanner scanner) {
        System.out.printf("[영업직] %s 판매 금액 입력: ", getName());
        sale = scanner.nextInt();

        while (true) {
            System.out.printf("[영업직] %s 커미션 비율 입력 : ", getName());
            commissionRate = scanner.nextDouble();

            if (commissionRate >= 0.0 && commissionRate <= 5.0) {
                break;
            }

            System.out.println("ERROR : 커미션 비율 오류(0~5%)");
        }
    }

    @Override
    public int pay() {
        return getBasePay() + getCommission();
    }

    @Override
    public String type() {
        return "영업직";
    }

    @Override
    public int getSale() {
        return sale;
    }

    @Override
    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public int getCommission() {
        return (int)(sale * commissionRate / 100.0);
    }
}