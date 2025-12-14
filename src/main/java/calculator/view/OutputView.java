package calculator.view;

public class OutputView {
    private static final String PRINT_RESULT = "결과 : ";

    private OutputView() {
    }

    public static void printResult(Long result) {
        System.out.printf(PRINT_RESULT + result);
    }
}
