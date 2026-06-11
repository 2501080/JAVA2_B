public class Staff extends Person {
    private String employeeID;

    public Staff(String employeeID, String name, Date birthday) {
        super(name, birthday);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }
}