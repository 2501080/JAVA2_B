import java.io.IOException;
import java.util.Scanner;

public class ElectricOffice {
    private Customer[] customers;

    public ElectricOffice(int size) {
        this.customers = new Customer[size];
    }

    public void inputData() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < customers.length; i++) {
            System.out.println("\n[" + (i + 1) + "번째 고객 정보 입력]");
            System.out.print("수도번호(5자리): ");
            String id = keyboard.next();
            System.out.print("이름: ");
            String name = keyboard.next();


            if (id.startsWith("9")) {
                customers[i] = new SupportBill(id, name, 0);
            } else {
                customers[i] = new Home(id, name, 0);
            }
            customers[i].inputUsage();
        }
    }

    public void display() {
        sortByCharge();
        System.out.println("*************************************************************************************");
        System.out.println(" 번호     이름      사용량       사용요금         세금        납부금액       비고");
        System.out.println("*************************************************************************************");
        for (Customer c : customers) {
            if (c != null) System.out.println(c);
        }
        System.out.println("*************************************************************************************");
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
}