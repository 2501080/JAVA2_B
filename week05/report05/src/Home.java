public class Home extends Customer {
    public Home(String id, String name, int usage) {
        super(id, name, usage);
    }

    @Override
    public int fee() {
        // 기본 요금 1,660원 + 구간별 계산된 사용 요금
        return (int)(1660 + calculateUsageFee(this.usage));
    }

    @Override
    public int tax() {
        // 사용 요금의 7%
        return (int)(fee() * 0.07);
    }

    @Override
    public int charge() {
        // 사용 요금 + 세금
        return fee() + tax();
    }
}