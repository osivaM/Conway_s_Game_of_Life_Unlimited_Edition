public class ConwayLife {
    public static int[][] getGeneration(int[][] cells, int generations) {
        int[][] result = new int[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            System.arraycopy(cells[i], 0, result[i], 0, cells[i].length);
        }

        for (int count = 0; count < generations; count++) {
            int[][] temp = new int[result.length + 4][result[0].length + 4];
            int[][] interRes = new int[temp.length][temp[0].length];
            int up, down, left, right;
            boolean firstOne;

            for (int i = 0; i < result.length; i++) {
                System.arraycopy(result[i], 0, temp[i + 2], 2, result[i].length);
            }

            for (int i = 1; i < temp.length - 1; i++) {
                for (int j = 1; j < temp[i].length - 1; j++) {
                    int liveCell = 0;

                    if (temp[i - 1][j - 1] == 1) {
                        liveCell++;
                    }
                    if (temp[i - 1][j] == 1) {
                        liveCell++;
                    }
                    if (temp[i - 1][j + 1] == 1) {
                        liveCell++;
                    }
                    if (temp[i + 1][j - 1] == 1) {
                        liveCell++;
                    }
                    if (temp[i + 1][j] == 1) {
                        liveCell++;
                    }
                    if (temp[i + 1][j + 1] == 1) {
                        liveCell++;
                    }
                    if (temp[i][j - 1] == 1) {
                        liveCell++;
                    }
                    if (temp[i][j + 1] == 1) {
                        liveCell++;
                    }

                    if (temp[i][j] == 0 && liveCell == 3) {
                        interRes[i][j] = 1;
                    } else if (temp[i][j] == 1 && (liveCell < 2 || liveCell > 3)) {
                        interRes[i][j] = 0;
                    } else {
                        interRes[i][j] = temp[i][j];
                    }
                }
            }

            left = interRes[0].length;
            right = down = up = 0;
            firstOne = false;
            for (int i = 0; i < interRes.length; i++) {

                for (int j = 0; j < interRes[0].length; j++) {
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

            result = new int[down - up + 1][right - left + 1];
            for (int i = 0; i < result.length; i++) {
                System.arraycopy(interRes[i + up], left, result[i], 0, result[i].length);
            }
        }

        return result;
    }
}
