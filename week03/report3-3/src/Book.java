public class Book {
    private String title;
    private boolean isBorrowed; // 대출 중인지 여부

    public Book(String title) {
        this.title = title;
        this.isBorrowed = false; // 처음 입고 시에는 대출 가능 상태
    }

    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setBorrowed(boolean status) { this.isBorrowed = status; }

    @Override
    public String toString() {
        return String.format("책 제목: %-15s | 상태: %s", title, (isBorrowed ? "대출 중" : "대출 가능"));
    }
}