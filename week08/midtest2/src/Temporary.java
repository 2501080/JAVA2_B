public class Temporary extends Employee {
    private int dailyPay, days;
    public Temporary(String n, String id, Date b, int dPay, int d) {
        super(n, id, b); this.dailyPay = dPay; this.days = d;
    }
    @Override
    public long calculateTotalPay() {
        return (long)dailyPay * days;
    }

    @Override
    public double getTax() {
        return calculateTotalPay() * 0.066;
    } // 일용직 전용
}