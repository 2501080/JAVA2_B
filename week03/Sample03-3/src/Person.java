public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }

    //Is-a 관계
}
