public class Compute {

    public static int getBasePay(int grade, int clazz) {

        int[][] base = {
                {1250000, 950000, 750000},
                {1200000, 925000, 725000},
                {1150000, 900000, 700000},
                {1100000, 875000, 675000},
                {1050000, 850000, 650000}
        };

        return base[clazz - 1][grade - 1];
    }


    public static int getGradePay(int grade) {
        if (grade == 1) return 300000;
        if (grade == 2) return 200000;
        return 100000;
    }


    public static int getPartPay(int part) {
        switch (part) {
            case 1:
            case 2: return 250000;
            case 3:
            case 4: return 350000;
            case 5: return 300000;
        }
        return 0;
    }


    public static int getTax(Employee e, int base, int total, int aid) {

        if (e.special) {
            return (int)(base * 0.03);
        }

        int taxable = total - aid;

        if (taxable < 700000) return 0;
        else if (taxable < 800000) return (int)(taxable * 0.05);
        else if (taxable < 1000000) return (int)(taxable * 0.07);
        else return (int)(taxable * 0.09);
    }
}