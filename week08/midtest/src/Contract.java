import java.util.Scanner;

public class Contract extends Employee {

    public Contract(int id, String name, char grade, char ho) {
        super(id, name, grade, ho);
    }

    public void input(Scanner sc) {
        System.out.println("[계약직] 추가 입력 없음");
    }

    public int pay() {
        return 0;
    }

    public String type() {
        return "계약직";
    }
}