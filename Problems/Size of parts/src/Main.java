import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Main {
    private static final String PERFECT = "0";
    private static final String LARGER = "1";
    private static final String SMALLER = "-1";

    public static void main(String[] args) {
        final var scanner = new java.util.Scanner(System.in);
        final var partsCount = scanner.nextInt();

        final var report = scanner.tokens()
                .limit(partsCount)
                .collect(groupingBy(identity(), counting()));

        System.out.printf("%d %d %d",
                report.getOrDefault(PERFECT, 0L),
                report.getOrDefault(LARGER, 0L),
                report.getOrDefault(SMALLER, 0L)
        );
    }
}