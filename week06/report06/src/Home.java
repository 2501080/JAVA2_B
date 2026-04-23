class Home extends Customer {
    public Home(String id, String name, int usage) {
        super(id, name, usage);
    }

    @Override
    public int fee() {

        return 1660 + calculateBaseUsageFee(this.usage);
    }
}