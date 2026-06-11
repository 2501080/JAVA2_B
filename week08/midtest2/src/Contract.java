public class Contract extends Employee {
    public Contract(String n, String id, Date b) { super(n, id, b); }
    @Override
    public long calculateTotalPay() {
        return 2000000;
    }
    @Override
    public double getTax() {
        return calculateTax();
    }
}