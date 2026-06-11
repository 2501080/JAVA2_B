public class Salesman extends Regular {
    private long commission;
    public Salesman(String n, String id, Date b, int g, int s, long comm) {
        super(n, id, b, g, s);
        this.commission = comm;
    }
    @Override
    public long calculateTotalPay() {
    return super.calculateTotalPay() + commission;
    }
}