import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ElectricOffice office = new ElectricOffice(10);
        office.inputData();
        office.display();
    }
}