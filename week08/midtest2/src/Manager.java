public class Manager extends Regular {
    public Manager(String n, String id, Date b, int g, int s) { super(n, id, b, g, s); }
    @Override
    public long calculateTotalPay() {
        long base = super.calculateTotalPay();
        if (base <= 1800000) return base + (long)(base * 0.06);
        else if (base <= 2400000) return base + (long)(base * 0.05);
        else return base + (long)(base * 0.04);
    }
}