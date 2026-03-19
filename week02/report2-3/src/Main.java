import java.io.IOException;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {

        Date birthday = new Date(2005, 2, 8);
        Date today = new Date(2026, 3, 19);
        Date error = new Date(2025, 2, 29);

        System.out.println(birthday);
        System.out.println(today);
        System.err.println(error);


        error = new Date(2023, 2, 29);
        System.err.println(error);


    }
}