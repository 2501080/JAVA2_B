import java.io.IOException;

public interface MyProject {
    // 세율 상수 정의
    double TAX_RATE_LOW = 0.066;    // 200만원 이하
    double TAX_RATE_MID = 0.08;     // 200~400만원
    double TAX_RATE_HIGH = 0.1;     // 400만원 초과

    // 공통 오류 처리 로직
    default void error(String message) throws IOException {
        System.err.printf("ERROR : %s%n", message);
        System.in.read(); // 사용자 입력 대기
    }
}