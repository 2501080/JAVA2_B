import java.util.ArrayList;
import java.util.List;

public class Staff implements MyProject {
    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee e) {
        list.add(e);
    }

    public void printAll() {
        for (Employee e : list) {
            long pay = e.calculateTotalPay();
            int tax = e.calculateTax();
            System.out.printf("사원: %s | 급여: %d | 세금: %d | 실수령액: %d%n",
                    e.name, pay, tax, (pay - tax));
        }
    }
}