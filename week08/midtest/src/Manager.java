import java.util.Scanner;
class Manager extends Employee {
    int salary, incentive;
    public Manager(int id, String name, char grade, char ho) { super(id, name, grade, ho); }
    public void input(Scanner sc) {
        System.out.print("[점장직] " + name + " 기본급: ");
        salary = sc.nextInt();
        System.out.print("[점장직] " + name + " 인센티브: ");

        incentive = sc.nextInt();
    }
    public int pay() {
        double allowance = (salary <= 1800000) ? 0.06 : (salary <= 2400000) ? 0.05 : 0.04;
        return salary + incentive + (int)(salary * allowance);
    }
    public String type() { return "점장직"; }
    public int getSalary() { return salary; }
    public int getIncentive() { return incentive; }
}