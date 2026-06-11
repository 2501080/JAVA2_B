import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int LINE_SIZE = 150;

    private static void line() {
        for (int i = 0; i < LINE_SIZE; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        employees.add(new Salesman("2501080", "문초연", new Date(2006, 3, 12), '3', '2'));
        employees.add(new Researcher("1246845", "정통파", new Date(1998, 5, 17), '4', '3'));
        employees.add(new Regular("3478963", "진접읍", new Date(1999, 8, 21), '2', '2'));
        employees.add(new Salesman("1240526", "한송이", new Date(2000, 2, 5), '4', '4'));
        employees.add(new Regular("2314567", "홍길동", new Date(1997, 10, 7), '3', '1'));
        employees.add(new Manager("4756821", "이대한", new Date(1995, 6, 1), '1', '3'));
        employees.add(new Contract("1234265", "한양대", new Date(2001, 12, 24)));
        employees.add(new Temporary("5657890", "경복대", new Date(2002, 4, 9)));


        for (Employee employee : employees) {
            employee.input(scanner);
        }

        employees.sort(Comparator.comparingInt(Employee::realPay).reversed());

        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t경북주식회사 급여 대장");
        line();
        System.out.printf(
                "%5s %12s %18s %9s %9s %8s %7s %9s %9s %10s %10s %10s %5s%n",
                "사번", "이름", "급-호", "일수", "일당", "기본급",
                "판매수당", "관리수당", "연구수당", "지급액", "세금", "실수령액", "비고"
        );
        line();

        int totalRealPay = 0;

        for (Employee employee : employees) {
            employee.display();
            totalRealPay += employee.realPay();
        }

        line();
        System.out.printf("%109s %,11d\n", "지급액 합계 : ",totalRealPay);
        line();

        System.out.println();
        System.out.println("\t\t\t\t\t\t영업직 사원 커미션 산출 내역");
        line();
        System.out.printf("%-8s %-5s %11s %9s %13s%n", "사번", "이름", "판매금액", "요율", "판매수당");
        line();

        for (Employee employee : employees) {
            if (employee instanceof Salesman) {
                Salesman salesman = (Salesman)employee;
                System.out.printf(
                        "%-8s %-5s %,15d %9.1f%% %,15d%n",
                        salesman.getEmployeeID(), salesman.getName(), salesman.getSale(),
                        salesman.getCommissionRate(), salesman.getCommission()
                );
            }
        }

        line();
        scanner.close();
    }
}
