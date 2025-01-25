
import java.util.*;
import java.awt.Point;

public class Main1 {

    private static Random random = new Random();

    public static void main(String[] args) {

    }

    public static int getNumberOfIslands(boolean[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                boolean i1 = i - 1 > -1;
                boolean i2 = i + 1 > matrix.length;
                boolean j1 = j - 1 > -1;
                boolean j2 = j - 1 > matrix[i].length;

                if (matrix[i][j]) {

                    Queue<Point> que = new LinkedList<>();

                    que.offer(new Point(i, j));

                    while (!que.isEmpty()) {

                        Point point = que.poll();
                        matrix[point.x][point.y] = false;
                        if (i1 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x - 1, point.y));
                        if (i2 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x + 1, point.y));
                        if (j1 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x, point.y - 1));
                        if (j2 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x, point.y + 1));

                        if (i1 && j1 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x - 1, point.y - 1));
                        if (i1 && j2 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x - 1, point.y + 1));
                        if (i2 && j1 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x + 1, point.y - 1));
                        if (i2 && j2 && matrix[point.x - 1][point.y] == true)
                            que.offer(new Point(point.x + 1, point.y + 1));

                    }
                    count++;
                }

            }
        }

        return count;
    }

}
