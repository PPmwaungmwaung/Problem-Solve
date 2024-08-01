// 1. 원이 목적지를 감싸고 있는 경우
// ㄴ 원의 중점부터 목적지까지의 거리가 반지름 이하인 경우
// 2. 원이 출발지를 감싸고 있는 경우
// ㄴ 원의 중점부터 출발지까지의 거리가 반지름 이하인 경우
// 3. 원이 목적지와 출발지를 둘 다 감싸고 있는 경우
// ㄴ 원의 중점부터 출발지와 목적지까지의 거리가 반지름 이하인 경우
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Num1004 {
    static class Planet {
        public double x, y, r;
        public Planet(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, planetNum, cnt;
        double toStart, toDest;
        Planet start, dest, planet;
        String[] input;

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            cnt = 0;
            input = br.readLine().split(" ");
            start = new Planet(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0);
            dest = new Planet(Integer.parseInt(input[2]), Integer.parseInt(input[3]), 0);

            planetNum = Integer.parseInt(br.readLine());
            for(int j = 0; j < planetNum; j++) {
                input = br.readLine().split(" ");
                planet = new Planet(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));

                toStart = Math.sqrt(Math.pow(planet.x - start.x, 2) + Math.pow(planet.y - start.y, 2));
                toDest = Math.sqrt(Math.pow(planet.x - dest.x, 2) + Math.pow(planet.y - dest.y, 2));

                if (toStart < planet.r && toDest < planet.r) {
                    continue;
                }
                if (toStart < planet.r || toDest < planet.r) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
