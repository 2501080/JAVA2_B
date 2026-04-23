public class SupportBill extends Customer {
    public SupportBill(String id, String name, int usage) {
        super(id, name, usage);
        this.note = "지원가구";
    }

    @Override
    public int fee() {
        // 지원 가구는 100Kw까지 무료이므로 요금 부과 대상에서 100을 뺌
        int billableUsage = Math.max(0, usage - 100);
        return (int)(1660 + calculateUsageFee(billableUsage));
    }

    @Override
    public int tax() {
        return (int)(fee() * 0.07);
    }

    @Override
    public int charge() {
        return fee() + tax();
    }
}