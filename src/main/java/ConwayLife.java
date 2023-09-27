public class ConwayLife {

    public static int[][] getGeneration(int[][] cells, int generations) {
        int[][] result = cells;

        for (int count = 0; count < generations; count++) {
            int[][] te = result;
            result = new int[result.length + 4][result[0].length + 4];
            int[][] temp = new int[result.length][result[0].length];

            for (int i = 0; i < te.length; i++) {
                System.arraycopy(te[i], 0, result[i + 2], 2, te[i].length);
            }

            for (int lin = 1; lin < result.length - 1; lin++) {
                for (int col = 1; col < result[lin].length - 1; col++) {
                    int liveCell = 0;

                    if (result[lin - 1][col] == 1) {
                        liveCell++;
                    }
                    if (result[lin - 1][col + 1] == 1) {
                        liveCell++;
                    }
                    if (result[lin][col + 1] == 1) {
                        liveCell ++;
                    }
                    if (result[lin + 1][col + 1] == 1) {
                        liveCell++;
                    }
                    if (result[lin + 1][col] == 1) {
                        liveCell++;
                    }
                    if (result[lin + 1][col - 1] == 1) {
                        liveCell++;
                    }
                    if (result[lin][col - 1] == 1) {
                        liveCell++;
                    }
                    if (result[lin - 1][col - 1] == 1) {
                        liveCell++;
                    }

                    if (result[lin][col] == 0 && liveCell == 3) {
                        temp[lin][col] = 1;
                    } else if (result[lin][col] == 1 && (liveCell < 2 || liveCell > 3)) {
                        temp[lin][col] = 0;
                    } else {
                        temp[lin][col] = result[lin][col];
                    }
                }
            }

            int left = 0;
            int right = 0;
            int up = 0;
            int down = 0;

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    if (temp[i][j] == 1) {
                        right = j;
                        down = i;
                    }
                }
            }
            for (int i = temp.length - 1; i >= 0; i--) {
                for (int j = temp[0].length - 1; j >= 0; j--) {
                    if (temp[i][j] == 1) {
                        up = i;
                        break;
                    }
                }
            }
            for (int[] t : temp) {
                for (int j = t.length - 1; j >= 0; j--) {
                    if (t[j] == 1) {
                        left = j;
                    }
                }
            }

            result = new int[(up + down) / 2][(left + right) / 2];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(temp[i + up], left, result[i], 0, result.length);
            }
        }

        System.out.println("result:");
        LifeDebug.print(result);

        return result;
    }

}

/*
 * 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
 * 3. Any live cell with two or three live neighbours lives on to the next generation.
 * 4. Any dead cell with exactly three live neighbours becomes a live cell.
 */