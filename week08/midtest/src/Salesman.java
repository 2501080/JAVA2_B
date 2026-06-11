import java.util.Scanner;
class Salesman extends Employee {
    int salary, commission;
    public Salesman(int id, String name, char grade, char ho) { super(id, name, grade, ho); }
    public void input(Scanner sc) {
        System.out.print("[영업직] " + name + " 기본급: ");
        salary = sc.nextInt();
        System.out.print("[영업직] " + name + " 커미션: ");
        commission = sc.nextInt();
    }
    public int pay() { return salary + commission; }
    public String type() { return "영업직"; }
    public int getSalary() { return salary; }
    public int getCommission() { return commission; }
}