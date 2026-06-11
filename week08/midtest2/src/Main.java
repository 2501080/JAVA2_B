//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Staff staff = new Staff();

        staff.addEmployee(new Researcher("홍길동", "R001", new Date(1990, 1, 1), 1, 1));
        staff.addEmployee(new Temporary("김알바", "T001", new Date(2000, 5, 5), 100000, 20));

        staff.printAll();
    }
}