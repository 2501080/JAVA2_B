public class Employee {

    int id;
    String name;
    int part;
    boolean special;
    int grade;
    int clazz;
    int aid;

    public Employee(int id, String name, int part, boolean special, int grade, int clazz, int aid) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.special = special;
        this.grade = grade;
        this.clazz = clazz;
        this.aid = aid;
    }

    public String getPartName() {
        switch (part) {
            case 1: return "경리과";
            case 2: return "인사과";
            case 3: return "영업팀";
            case 4: return "생산과";
            case 5: return "A/S팀";
        }
        return "";
    }

    @Override
    public String toString() {

        int base = Compute.getBasePay(grade, clazz);
        int gradePay = Compute.getGradePay(grade);
        int partPay = Compute.getPartPay(part);

        int total = base + gradePay + partPay;

        int deduction = aid;
        int tax = Compute.getTax(this, base, total, aid);


        int net = total - tax - deduction;

        return String.format("%-6s %-6d %-8s %-4s %d-%d %10s %10s %10s %10s %6d %12s",
                name,
                id,
                getPartName(),
                special ? "O" : "X",
                grade,
                clazz,
                String.format("%,d", base),
                String.format("%,d", partPay),
                String.format("%,d", gradePay),
                String.format("%,d", deduction),
                tax,
                String.format("%,d", net)
        );
    }
}