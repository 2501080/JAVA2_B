public class Student extends Person{
    public Student(String name) {
        super(name);
    }
    //extends Person 넣고 생성자 넣어줘야만 에러 안 생김

    public void study(Book book) {
        System.out.printf("학생(%s) : 네~ %s으로 공부할게요!\n", super.toString(), book);
    }
}
