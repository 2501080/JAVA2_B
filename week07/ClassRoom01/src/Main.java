import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Person[] persons = new Person[]{
                new Person("0501003", "홍길동"),
                new Person("0501007", "이재명"),
                new Person("0501013", "이희망"),
                new Person("0501024", "김지호"),
                new Person("0501026", "최현준"),
                new Person("0501058", "이나영"),
                new Person("0501077", "박찬호"),
                new Person("0501085", "여주림"),
                new Person("0501096", "박재혁"),
                new Person("0501110", "임지환")
        };

        Setting setting = new Setting();
        int type = setting.setting();
        Student[] students = setting.prepare(type, persons);

        ClassRoom classRoom = new ClassRoom(students);
        classRoom.inputData();
        classRoom.display();
    }
}