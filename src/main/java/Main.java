public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];

        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
