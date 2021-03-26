/**
 * #12
 */

class ShortestPathMatrix {

    private int m;
    private int n;
    private boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        this.m = board.length;
        this.n = board[0].length;
        char head = word.charAt(0);
        this.isVisited = new boolean[this.m][this.n];
        boolean temp = false;
        for (int i = 0; i < this.m; i += 1) {
            for (int j = 0; j < this.n; j += 1) {
                if (board[i][j] == head) {
                    if (word.length() == 1) {
                        return true;
                    } else {
                        this.isVisited[i][j] = true;
                        temp = dfs(board, i, j, 1, word);
                        if (temp == true) {
                            return temp;
                        } else {
                            this.isVisited[i][j] = false;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int k, String word) {

        int[][] offset = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int a = 0; a < offset.length; a += 1) {
            
            int x = offset[a][0];
            int y = offset[a][1];
            if (this.isValid(i + x, j + y) && board[i + x][j + y] == word.charAt(k)) {
                if (k == word.length() - 1) {
                    return true;
                } else {
                    this.isVisited[i + x][j + y] = true;
                    boolean temp = dfs(board, i + x, j + y, k + 1, word);
                    if (temp) {
                        return true;
                    } else {
                        this.isVisited[i + x][j + y] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < this.m && j >= 0 && j < this.n && !this.isVisited[i][j];
    }
}