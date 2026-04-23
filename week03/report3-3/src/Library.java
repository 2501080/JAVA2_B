import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // 회원가입
    public void joinMember(String id, String pw, String name) {
        members.add(new Member(id, pw, name));
        System.out.printf("시스템: [%s] 님의 회원가입이 완료되었습니다.\n", name);
    }

    // 로그인 확인 (성공 시 Member 객체 반환, 실패 시 null)
    public Member login(String id, String pw) {
        for (Member m : members) {
            if (m.getId().equals(id) && m.getPassword().equals(pw)) {
                return m;
            }
        }
        return null;
    }

    public void borrowBook(Member member, String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.printf("성공: %s 님이 [%s]을(를) 대출했습니다.\n", member.getName(), bookTitle);
                    return;
                } else {
                    System.out.printf("오류: [%s]은(는) 이미 대출 중입니다.\n", bookTitle);
                    return;
                }
            }
        }
        System.out.printf("오류: [%s] 도서를 찾을 수 없습니다.\n", bookTitle);
    }

    public void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                book.setBorrowed(false);
                System.out.printf("성공: [%s] 도서가 반납되었습니다.\n", bookTitle);
                return;
            }
        }
        System.out.printf("오류: [%s] 도서를 찾을 수 없습니다.\n", bookTitle);
    }

    public void showStatus() {
        System.out.printf("\n--- 도서 현황 조회 ---\n");
        for (Book b : books) {
            System.out.printf("%s\n", b.toString());
        }
    }
}