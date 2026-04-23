import java.io.IOException;
import java.util.Scanner;

public abstract class Customer extends Person implements MyProject, ElectricProject {
    protected String note = "";

    public Customer(String id, String name, int usage) {
        super(id, name, usage);
    }


    protected void inputUsage() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.printf("%s님의 전기 사용량(Kw) 입력 : ", name);
            int input = keyboard.nextInt();
            if (input >= 0 && input <= 9999) {
                this.usage = input;
                break;
            } else {
                error("사용량 범위 오류 (0~9999)");
            }
        }
    }


    protected int calculateBaseUsageFee(int targetUsage) {
        double total = 0;
        int temp = targetUsage;
        double[] rates = {184.1, 223.8, 278.3, 353.6, 466.4};

        for (double rate : rates) {
            if (temp <= 0) break;
            int step = Math.min(temp, 100);
            total += step * rate;
            temp -= step;
        }
        if (temp > 0) total += temp * 643.9;

        return (int) total;
    }

    @Override
    public int tax() {
        return (int) (fee() * 0.07);
    }

    @Override
    public int charge() {
        return fee() + tax();
    }

    @Override
    public String toString() {
        return String.format("%-8s %-5s %,7dKw  %,10d원  %,9d원  %,10d원  %3s",
                id, name, usage, fee(), tax(), charge(), note);
    }
}