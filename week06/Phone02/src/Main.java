import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[] {
                new Customer("홍길동", new Date(2000, 7, 12),
                        "010-2345-5678", new DiscountPlan()),
                new Customer("박길동", new Date(2007, 7, 12),
                        "010-2345-5678", new BasicPlan()),
                new Customer("정길동", new Date(1930, 7, 12),
                        "010-2345-5678", new BasicPlan())
        };

        PhoneOffice office = new PhoneOffice(customers);
        office.inputData();
        office.display();

    }
}