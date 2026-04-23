//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("영희", 24);
        Doctor doctor = new Doctor("철수", 45);
        Engineer engineer = new Engineer("민수", 35);

        teacher.introduce();
        doctor.introduce();
        engineer.introduce();

        teacher.teach();
        teacher.check();

        doctor.patient();
        doctor.surgery();

        engineer.program();
        engineer.bug();

    }
}