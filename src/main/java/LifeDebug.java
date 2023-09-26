import java.util.Arrays;

public class LifeDebug {
    public static String htmlize(int[][] cells) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] cell : cells) {
            for (int i : cell) {
                if (i == 1) {
                    stringBuilder.append('#');
                } else {
                    stringBuilder.append('.');
                }
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public static void print(int[][] cells) {
        for (int[] cell : cells) {
            for (int i : cell) {
                if (i == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static boolean equals(int[][] res, int[][] cells) {
        return Arrays.deepEquals(res, cells);
    }
}
