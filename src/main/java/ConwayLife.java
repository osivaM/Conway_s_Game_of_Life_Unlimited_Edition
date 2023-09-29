public class ConwayLife {
    public static int[][] getGeneration(int[][] cells, int generations) {
        for (int count = 0; count < generations; count++) {
            int[][] temp = new int[cells.length + 4][cells[0].length + 4];
            int[][] interRes = new int[temp.length][temp[0].length];
            int[] neighbors = {-1, -1, -1, 0, -1, 1, 1, -1, 1, 0, 1, 1, 0, -1, 0, 1};
            int up = 0, down = 0, left = interRes.length, right = 0;
            boolean firstOne = false;

            for (int i = 0; i < cells.length; i++) {
                System.arraycopy(cells[i], 0, temp[i + 2], 2, cells[i].length);
            }

            for (int i = 1; i < temp.length - 1; i++) {
                for (int j = 1; j < temp[i].length - 1; j++) {
                    int liveCell = 0;

                    for (int k = 0; k < 16; k += 2) {
                        if (temp[i + neighbors[k]][j + neighbors[k + 1]] == 1) {
                            liveCell++;
                        }
                    }

                    if (temp[i][j] == 0 && liveCell == 3) {
                        interRes[i][j] = 1;
                    } else if (liveCell >= 2 && liveCell <= 3) {
                        interRes[i][j] = temp[i][j];
                    }

                    if (interRes[i][j] == 1) {
                        if (!firstOne) {
                            up = i;
                            firstOne = true;
                        }
                        if (i > down) {
                            down = i;
                        }
                        if (j < left) {
                            left = j;
                        }
                        if (j > right) {
                            right = j;
                        }
                    }
                }
            }

            cells = new int[down - up + 1][right - left + 1];
            for (int i = 0; i < cells.length; i++) {
                System.arraycopy(interRes[i + up], left, cells[i], 0, cells[i].length);
            }
        }

        return cells;
    }
}
