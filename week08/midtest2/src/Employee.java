public abstract class Employee extends Person implements MyProject {
    protected String employeeID;
    protected Date birthday;

    public Employee(String name, String id, Date bday) {
        super(name);
        this.employeeID = id;
        this.birthday = bday;
    }

    public abstract long calculateTotalPay(); // 기본급 + 수당
    public abstract double getTax();

    // 세금 계산 로직 (MyProject 인터페이스의 상수 활용)
    public int calculateTax() {
        long pay = calculateTotalPay();
        if (pay <= 2000000) return (int) (pay * TAX_RATE_LOW);
        else if (pay <= 4000000) return (int) (pay * TAX_RATE_MID);
        else return (int) (pay * TAX_RATE_HIGH);
    }
}