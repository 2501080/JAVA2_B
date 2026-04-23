public abstract class Customer extends Person {
    protected String note = "";

    public Customer(String id, String name, int usage) {
        super(id, name, usage);
    }

    // 누진제 구간별 계산 로직 (이름 변경 없이 내부 식만 수정)
    protected double calculateUsageFee(int targetUsage) {
        double totalUsageFee = 0;
        int tempUsage = targetUsage;

        // 1단계: 100Kw 이하 (184.1원)
        if (tempUsage > 0) {
            int step = Math.min(tempUsage, 100);
            totalUsageFee += step * 184.1;
            tempUsage -= step;
        }
        // 2단계: 101~200Kw (223.8원)
        if (tempUsage > 0) {
            int step = Math.min(tempUsage, 100);
            totalUsageFee += step * 223.8;
            tempUsage -= step;
        }
        // 3단계: 201~300Kw (278.3원)
        if (tempUsage > 0) {
            int step = Math.min(tempUsage, 100);
            totalUsageFee += step * 278.3;
            tempUsage -= step;
        }
        // 4단계: 301~400Kw (353.6원)
        if (tempUsage > 0) {
            int step = Math.min(tempUsage, 100);
            totalUsageFee += step * 353.6;
            tempUsage -= step;
        }
        // 5단계: 401~500Kw (466.4원)
        if (tempUsage > 0) {
            int step = Math.min(tempUsage, 100);
            totalUsageFee += step * 466.4;
            tempUsage -= step;
        }
        // 6단계: 500Kw 초과 (643.9원)
        if (tempUsage > 0) {
            totalUsageFee += tempUsage * 643.9;
        }

        return totalUsageFee;
    }

    public abstract int fee();
    public abstract int tax();
    public abstract int charge();

    @Override
    public String toString() {
        return String.format("%-8s %-5s %,7dKw  %,10d원  %,9d원  %,10d원  %3s",
                id, name, usage, fee(), tax(), charge(), note);
    }
}