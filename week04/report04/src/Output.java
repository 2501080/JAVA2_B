public class Output {

    Employee[] employees;

    public Output(Employee[] employees) {
        this.employees = employees;
    }

    public void line() {
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    public void display() {

        line();
        System.out.printf("%3s %6s %5s %7s %4s %6s %10s %8s %9s %5s %9s\n",
                "이름", "사번", "부서명", "원호", "급-호",
                "본봉", "업무수당", "직급수당", "공제금액", "세금", "수령액");
        line();

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

        line();
    }
}