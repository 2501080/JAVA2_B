class SupportBill extends Customer {
    public SupportBill(String id, String name, int usage) {
        super(id, name, usage);
        this.note = "지원"; 
    }

    @Override
    public int fee() {

        int billableUsage = Math.max(0, usage - 100);
        return 1660 + calculateBaseUsageFee(billableUsage);
    }
}