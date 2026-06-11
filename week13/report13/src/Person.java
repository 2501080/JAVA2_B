public class Person {
    private String hakbun;
    private String name;
    private String gender;

    public Person() {}

    public Person(String hakbun, String name, String gender) {
        this.hakbun = hakbun;
        this.name = name;
        this.gender = gender;
    }

    public String getHakbun() { return hakbun; }
    public String getName()   { return name; }
    public String getGender() { return gender; }

    public void setHakbun(String hakbun) { this.hakbun = hakbun; }
    public void setName(String name)     { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
}