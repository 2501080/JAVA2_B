public class Regular extends Employee {
    protected int grade;
    protected int step;

    public Regular(String n, String id, Date b, int g, int s) {
        super(n, id, b);
        this.grade = g;
        this.step = s;
    }

    @Override
    public long calculateTotalPay() {
        // 급여표에 따른 로직 (예시: 1호봉 200만원)
        return 2000000 + (grade * 100000) + (step * 50000);
    }

    @Override
    public double getTax() {
        return calculateTax();
    }
}