import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var h = scanner.nextInt();
        final var a = scanner.nextInt();
        final var b = scanner.nextInt();

        final var result = (h - b - 1) / (a - b) + 1;
        System.out.println(result);
    }
}