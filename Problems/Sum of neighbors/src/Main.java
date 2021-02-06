import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

class Main {
    private static final Pattern SPACE = Pattern.compile("\\s+");
    private static final Pattern NEW_LINE = Pattern.compile("\\R");
    private static final int[][] OFFSETS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        final var matrix = new Scanner(System.in)
                .useDelimiter(NEW_LINE).tokens()
                .takeWhile(not("end"::equals))
                .map(s -> SPACE.splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        final var rows = matrix.length;
        final var cols = matrix[0].length;

        final var result = range(0, rows)
                .mapToObj(x -> range(0, cols)
                        .map(y -> Arrays.stream(OFFSETS)
                                .mapToInt(o -> matrix[(x + rows + o[0]) % rows][(y + cols + o[1]) % cols]).sum())
                        .mapToObj(String::valueOf)
                        .collect(joining(" ")))
                .collect(joining(System.lineSeparator()));

        System.out.println(result);
    }
}