public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.printf("안녕하세요, 제 이름은 %s 이고 %d 살 입니다.\n", name, age);
    }
}
