import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
상근이는 빈 공간과 벽으로 이루어진 건물에 갇혀있다. 건물의 일부에는 불이 났고, 상근이는 출구를 향해 뛰고 있다.
매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다.
벽에는 불이 붙지 않는다. 상근이는 동서남북 인접한 칸으로 이동할 수 있으며, 1초가 걸린다.
상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다.
상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
빌딩의 지도가 주어졌을 때, 얼마나 빨리 빌딩을 탈출할 수 있는지 구하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.
각 테스트 케이스의 첫째 줄에는 빌딩 지도의 너비와 높이 w와 h가 주어진다. (1 ≤ w,h ≤ 1000)
다음 h개 줄에는 w개의 문자, 빌딩의 지도가 주어진다.

'.': 빈 공간
'#': 벽
'@': 상근이의 시작 위치
'*': 불
각 지도에 @의 개수는 하나이다.
 */
public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static int w, h;
    static char[][] map;
    static boolean[][] isVisited;
    static int MinTime = (int) 1e9;

    static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }


    }

    static Point currentPoint; //상근이의 현재 위치 : @
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Point> fireList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            fireList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') currentPoint = new Point(i, j);
                    else if (map[i][j] == '*') fireList.add(new Point(i, j));
                }
            }

            MinTime = (int) 1e9;

            escape_bfs();

            sb.append(MinTime == (int) 1e9 ? "IMPOSSIBLE" : MinTime + 1).append("\n");


        }
        System.out.println(sb);
    }

    public static void escape_bfs() {
        //상근이 탈출
        isVisited = new boolean[h][w];  //방문 기록 체크
        Queue<Point> q = new ArrayDeque<>();
        //현재 상근이 위치를 방문 체크 후 들어간다.
        isVisited[currentPoint.x][currentPoint.y] = true;
        q.add(currentPoint);
        int curDepth = -1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            if (curDepth < cur.depth) {
                fire_bfs();
                curDepth = cur.depth;
            }

            if (isEscaped(curX, curY)) {
                MinTime = Math.min(MinTime, cur.depth);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                //범위인가?
                if (!inRange(nextX, nextY)) continue;

                //갈수 있는 곳인가?
                if (map[nextX][nextY] != '.') continue;
                //갔었던 곳인가?
                if (isVisited[nextX][nextY]) continue;

                isVisited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY, cur.depth + 1));
            }

        }
    }

    public static void fire_bfs() {

        ArrayList<Point> newFireList = new ArrayList<>();
        //depth가 맞는 친구들만 번진다.
        //불이 번져 나간다.
        for (int f = 0; f < fireList.size(); f++) {
            //한 불에서 4방향으로 번진다.
            Point fire = fireList.get(f);
            for (int i = 0; i < 4; i++) {
                int nextX = fire.x + dx[i];
                int nextY = fire.y + dy[i];

                if (!inRange(nextX, nextY)) continue;
                if (map[nextX][nextY] != '.') continue;    //빈 공간에만 불이 붙는다.

                newFireList.add(new Point(nextX, nextY, fire.depth + 1));
                map[nextX][nextY] = '*';
            }
        }

        fireList.clear();
        fireList.addAll(newFireList);

/*        for (Point p :
                fireList) {
            map[p.x][p.y] = '*';
        }*/

    }

    public static boolean inRange(int x, int y) {
        return x < h && y < w && x >= 0 && y >= 0;
    }

    public static boolean isEscaped(int x, int y) {
        //가장 자리에 도달?
        if (x == 0 || x == h - 1) return true;
        else return y == 0 || y == w - 1;
    }

    public static void print() {
        System.out.println("=====================================");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=======================================");
    }
}