public class Engineer extends Person{
    public Engineer(String name, int age) {
        super(name, age);
    }
    public void program() {
        System.out.printf("%s 엔지니어가 프로그램을 개발합니다.\n",name);
    }

    public void bug() {
        System.out.printf("%s 엔지니어가 프로젝트의 버그를 수정합니다.\n", name);
    }
}
