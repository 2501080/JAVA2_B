import java.util.Scanner;

public class ElectricOffice {
    private Customer[] customers;

    public ElectricOffice(int size) {
        this.customers = new Customer[size];
    }

    protected void inputData() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(customers.length + "명의 데이터를 입력하세요.");

        for (int i = 0; i < customers.length; i++) {
            System.out.println("\n[" + (i + 1) + "번째 고객 입력]");
            System.out.print("수도번호(5자리): ");
            String id = keyboard.next();
            System.out.print("이름: ");
            String name = keyboard.next();
            System.out.print("사용량(Kw): ");
            int usage = keyboard.nextInt();


            if (id.startsWith("9")) {
                customers[i] = new SupportBill(id, name, usage);
            } else {
                customers[i] = new Home(id, name, usage);
            }
        }
    }

    protected void display() {
        sortByCharge();
        line();
        System.out.println(" 수도번호   이름       사용량       사용요금         세금        납부금액       비고");
        line();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
        }
        line();
    }


    private void sortByCharge() {
        for (int i = 0; i < customers.length - 1; i++) {
            for (int j = i + 1; j < customers.length; j++) {
                if (customers[i].charge() < customers[j].charge()) {
                    Customer temp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = temp;
                }
            }
        }
    }

    private void line() {
        for (int i = 0; i < 85; i++) System.out.print("*");
        System.out.println();
    }
}