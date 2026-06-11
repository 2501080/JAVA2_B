public class Researcher extends Regular {
    public Researcher(String n, String id, Date b, int g, int s) { super(n, id, b, g, s); }
    @Override
    public long calculateTotalPay() {
        return super.calculateTotalPay() + 300000;
    }
}