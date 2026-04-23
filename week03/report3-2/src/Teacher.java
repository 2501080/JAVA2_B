public class Teacher extends Person{
    public Teacher(String name, int age) {
        super(name, age);
    }
    public void teach() {
        System.out.printf("%s 선생님이 수업을 합니다.\n", name);
    }

    public void check() {
        System.out.printf("%s 선생님이 과제를 채점합니다.\n", name);
    }
}
