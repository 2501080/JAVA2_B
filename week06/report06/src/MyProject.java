import java.io.IOException;

public interface MyProject {

    default void error(String message) throws IOException {
        System.err.printf("ERROR : %s\n", message);
        System.out.println("계속하려면 Enter를 누르세요...");
        System.in.read();
    }
}