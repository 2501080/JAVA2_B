import java.io.IOException;
import java.util.Scanner;

public class Temporary extends Employee {
    private int day;
    private int dailyPay;

    public Temporary(String employeeID, String name, Date birthday) {
        super(employeeID, name, birthday, '0', '0');
    }

    @Override
    public void input(Scanner scanner) throws IOException {
        while (true) {
            System.out.printf("[일용직] %s 일당 입력 : ", getName());
            dailyPay = scanner.nextInt();

            if (dailyPay >= 25_000 && dailyPay <= 95_000) {
                break;
            }

            System.err.println("ERROR : 일당 범위 오류(25,000 ~ 95,000원)");
            System.in.read();
        }

        System.out.printf("[일용직] %s 작업 일수 입력: ", getName());
        day = scanner.nextInt();
    }

    @Override
    public int pay() {
        return day * dailyPay;
    }

    @Override
    public String type() {
        return "일용직";
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getDailyPay() {
        return dailyPay;
    }

    @Override
    public int getBasePay() {
        return pay();
    }
}