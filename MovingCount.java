/**
 * #13
 */

class MovingCount {

    private int m;
    private int n;
    private int k;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {

        this.m = m;
        this.n = n;
        this.k = k;
        int result = 0;
        this.visited = new boolean[m][n];

        bfs(0, 0);

        for (int i = 0; i < m; i += 1) {
            for (int j = 0 ; j < n; j += 1) {
                if (this.visited[i][j]) {
                    result += 1;
                }
            }
        }
        
        return result;
    }

    private void bfs (int i, int j) {
        this.visited[i][j] = true;
        int[][] offset = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int a = 0; a < offset.length; a += 1) {
            int x = offset[a][0] + i;
            int y = offset[a][1] + j;
            if (this.boundValid(x, y) && this.digitValid(x, y) && !this.visited[x][y]) {
                bfs(x, y);
            }
        }
    }

    private boolean boundValid(int i, int j) {
        return i >= 0 && i < this.m && j >= 0 && j < this.n;
    }

    private boolean digitValid(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= this.k;
    }
}