public class Movie {

    // State (속성)
    private String title;
    public String director;
    private int open;
    private String mainActor;
    private double rankPoint;

    public Movie() {
    }

    // 생성자
    public Movie(String title, String director, int open, String mainActor, double rankPoint) {
        this.title = title;
        this.director = director;
        this.open = open;
        this.mainActor = mainActor;
        this.rankPoint = rankPoint;
    }

    // 출력
    @Override
    public String toString() {
        return String.format("제목 : %s\n감독 : %s\n개봉 : %d\n주연 : %s\n평점 : %.1f",
                title, director, open, mainActor, rankPoint);
    }
}