import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static Library lib = new Library();

    public static void main(String[] args) {
        // 기본 도서 입고
        lib.addBook(new Book("자바의 정석"));
        lib.addBook(new Book("OOP 설계론"));

        while (true) {
            System.out.printf("\n[도서관 시스템] 1.대출 2.반납 3.현황 4.회원가입 5.종료\n선택: ");
            int menu = keyboard.nextInt();
            keyboard.nextLine();

            if (menu == 1) processBorrow();
            else if (menu == 2) processReturn();
            else if (menu == 3) lib.showStatus();
            else if (menu == 4) processJoin();
            else if (menu == 5) {
                System.out.printf("프로그램 종료.\n");
                break;
            }
        }
    }

    // 1. 대출 절차 (로그인 필수)
    static void processBorrow() {
        Member loginUser = auth();
        if (loginUser != null) {
            System.out.printf("대출할 책 제목: ");
            String title = keyboard.nextLine();
            lib.borrowBook(loginUser, title);
        }
    }

    // 2. 반납 절차 (로그인 필수)
    static void processReturn() {
        Member loginUser = auth();
        if (loginUser != null) {
            System.out.printf("반납할 책 제목: ");
            String title = keyboard.nextLine();
            lib.returnBook(title);
        }
    }


    // 4. 회원가입 절차
    static void processJoin() {
        System.out.printf("아이디 입력: "); String id = keyboard.nextLine();
        System.out.printf("비밀번호 입력: "); String pw = keyboard.nextLine();
        System.out.printf("이름 입력: "); String name = keyboard.nextLine();
        lib.joinMember(id, pw, name);
    }

    // 로그인 공통 모듈
    static Member auth() {
        System.out.printf("아이디: "); String id = keyboard.nextLine();
        System.out.printf("비밀번호: "); String pw = keyboard.nextLine();
        Member m = lib.login(id, pw);
        if (m == null) System.out.printf("오류: 로그인 정보가 틀립니다.\n");
        else System.out.printf("[%s] 님 인증되었습니다.\n", m.getName());
        return m;
    }
}