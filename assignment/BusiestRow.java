public class BusiestRow {
    static void busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            if (sum > maxTotal) {
                maxTotal = sum;
                bestRow = i;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}