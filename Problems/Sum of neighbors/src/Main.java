import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.function.Predicate.not;

class Main {
    private static final Pattern SPACE = Pattern.compile("\\s+");
    private static final Pattern NEW_LINE = Pattern.compile("\\R");

    public static void main(String[] args) {
        final var matrix = new Scanner(System.in)
                .useDelimiter(NEW_LINE).tokens()
                .takeWhile(not("end"::equals))
                .map(s -> SPACE.splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        final var rows = matrix.length;
        final var cols = matrix[0].length;

    }
}