package com.code.codingtest.dynamicprogramming;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GoingToSchoolOtherSolve2 {
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
//        int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};
        int[][] puddles = {{2,2}};

        System.out.println(new GoingToSchoolOtherSolve2().solution(width, height, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        //배열을 사용하지 않고 행렬이 아니라 좌표 개념으로 풀 수 있나?
        /*
        정확성은 모두 성공하는데 효율성에서 모두 실패함
        Key object를 비교하고 linkedHashMap에서 값을 찾아오는 과정에서 시간이 보다 오래 소요 되는것으로 보임.
        Key object를 String으로 변경해서 테스트 해 본 결과도 모두 효율성 테스트에서 시간초과 남.
        순차적으로 값을 채워 가야하기 때문에 LinkedHashMap을 사용했는데 효율성 부분에서는 마이너스 요인이 되는거 같음.
         */
        int mod = 1000000007;
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                String key = makeKey(i, j);

                if (i == 1 && j == 1) { map.put(key, 1); }
                else {
                    map.put(key, 0);

                    for (int[] puddle : puddles) {
                        if (i == puddle[0] && j == puddle[1]) {
                            map.put(key, -1);
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int keyX = Integer.parseInt(entry.getKey().split(",")[0]);
            int keyY = Integer.parseInt(entry.getKey().split(",")[1]);

            if (keyX > 0 && keyY > 0 && entry.getValue() != 1) {
                if (entry.getValue() == -1) {
                    entry.setValue(0);
                } else {
                    String preXKey = makeKey(keyX - 1, keyY);
                    String preYKey = makeKey(keyX, keyY - 1);

                    entry.setValue(map.get(preXKey) % mod + map.get(preYKey) % mod);
                }
            }
        }

        String resultKey = makeKey(m, n);
        return map.get(resultKey);
    }

    private String makeKey(int x, int y) {
        return String.join(",", String.valueOf(x), String.valueOf(y));
    }
}

class Key {
    private int x = 0;
    private int y = 0;

    public Key(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Key) {
            return x == ((Key)o).x && y == ((Key)o).y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x * 1000 + y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}