import java.util.Scanner; // IOException 제거

class Temporary extends Employee {
    int day, dailyPay;

    public Temporary(int id, String name, char grade, char ho) {
        super(id, name, grade, ho);
    }


    public void input(Scanner sc) {
        while (true) {
            System.out.print("[일용직] " + name + "님의 일당 입력 : ");
            dailyPay = sc.nextInt();

            if (dailyPay >= 25000 && dailyPay <= 95000) {
                break; // 정상 범위일 때 반복 종료
            } else {
                System.out.println("ERROR : 일당 범위 오류(25,000 ~ 95,000)");
            }
        }

        System.out.print("[일용직] " + name + "님의 작업 일수 입력 : ");
        day = sc.nextInt();
    }

    public int pay() { return day * dailyPay; }
    public String type() { return "일용직"; }
    public int getDay() { return day; }
    public int getDailyPay() { return dailyPay; }
}