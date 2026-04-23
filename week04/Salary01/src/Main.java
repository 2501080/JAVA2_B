import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[] {
                new Employee("홍길동", "1234", new Date(1999,3,26), '1', '3'),
                new Employee("이나라", "1345", new Date(1995, 5, 10), '3', '2'),
                new Employee("나정산", "1362", new Date(2002, 8, 30), '4', '3'),
                new Employee("박정환", "1422", new Date(1996, 6, 18), '4', '4'),
                new Employee("김대한", "3456", new Date(2003, 12, 4), '2', '5'),
                new Employee("이민국", "5634", new Date(1993, 6, 17), '3', '1'),
                new Employee("황정민", "1456", new Date(1996, 9, 20), '5', '4'),
                new Employee("길대연", "1345", new Date(1997, 4, 24), '5', '5'),
                new Employee("박대국", "1789", new Date(2000, 1, 7), '4', '2'),
                new Employee("하충민", "4521", new Date(1994, 3, 16), '1', '1')};

        Company company = new Company(employees);
        company.inputData();
        company.display();

    }
}