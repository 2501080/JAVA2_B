import java.util.Scanner;
class Regular extends Employee {
    int salary;
    public Regular(int id, String name, char grade, char ho) { super(id, name, grade, ho); }
    public void input(Scanner sc) { System.out.print("[정규직] " + name + " 기본급: "); salary = sc.nextInt(); }
    public int pay() { return salary; }
    public String type() { return "정규직"; }
    public int getSalary() { return salary; }
}