import java.io.IOException;
import java.util.*;

public class Main {

    public static void line() {
        for (int i = 0; i < 80; i++) System.out.print("*");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        // 🔥 데이터
        list.add(new Salesman(2501080, "문초연", '3', '2'));
        list.add(new Researcher(1246455, "정통파", '4', '3'));
        list.add(new Regular(3489637, "진접읍", '2', '2'));
        list.add(new Salesman(1245267, "한송이", '4', '4'));
        list.add(new Regular(2345676, "홍길동", '3', '1'));
        list.add(new Manager(4568213, "이대한", '1', '3'));
        list.add(new Manager(1234256, "한양대", '1', '5'));
        list.add(new Temporary(1234256, "경복대", '5', '5'));


        for (Employee e : list) {
            e.input(sc);
            System.out.println();
        }


        list.sort((a, b) -> b.realPay() - a.realPay());


        System.out.println("\t\t\t\t경북주식회사 급여 대장");
        line();

        System.out.println("  사번    이름     급-호     day     일당      기본급      인센      커미션      급여       세금        비고");

        line();

        int total = 0;

        for (Employee e : list) {
            e.display();
            total += e.realPay();
        }

        line();
        System.out.printf("\t\t\t\t지급액 합계 : %,d 원\n", total);
        line();

        System.out.println();
        System.out.println("\t\t\t\t영업직 사원 커미션 산출 내역");
        line();

        System.out.printf("%-8s %-20s %-15s %-6s %-12s\n",
                "사번", "이름", "판매 실적", "요율", "커미션 금액");

        line();

        for (Employee e : list) {
            if (e instanceof Salesman) {
                Salesman s = (Salesman) e;

                int sales = s.getSalary();
                int commission = s.getCommission();

                double rate = 0;
                if (sales >= 50000000) rate = 3.6;
                else if (sales >= 30000000) rate = 2.7;
                else rate = 2.6;

                System.out.printf("%-8d %-20s %,12d원 %5.1f %% %,12d\n",
                        s.id,
                        s.name,
                        sales,
                        rate,
                        commission
                );
            }
        }

        line();
        sc.close();
    }
}