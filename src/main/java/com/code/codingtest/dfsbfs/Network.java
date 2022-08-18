package com.code.codingtest.dfsbfs;

import java.util.*;

public class Network {
    public static void main(String[] args) {
//        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n = 6;
        int[][] computers = {
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {0,1,1,0,0,1},
                {0,1,0,1,1,0},
                {1,0,0,1,1,0},
                {0,0,1,0,0,1}
        };

        System.out.println(new Network().solution(n, computers));
    }

    //통과가 되긴 했는데 나이스한 방법은 아닌거 같고.. 의도한 바를 구현하지도 못한거 같음. 어거지로 만듦. for 문도 너무 많음.
    public int solution(int n, int[][] computers) {

        List<Set<Integer>> networkList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int networkListIndex = -1;

            //해당 노드가 network set 에 포함되어 있는지 확인 (가장 처음 나오는 set을 선택)
            for (int index = 0; index < networkList.size(); index++) {
                Set<Integer> set = networkList.get(index);

                if (set.contains(i)) {
                    networkListIndex = index;
                    break;
                }
            }

            Set<Integer> networkSet = null;

            //해당 노드가 포함된 network set이 없다면 새로 만들고 있다면 그 set에 연결된 노드를 저장함.
            if (networkListIndex == -1) {
                networkSet = new HashSet<>();
            } else {
                networkSet = networkList.get(networkListIndex);
            }

            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    networkSet.add(j);
                }
            }

            if (networkListIndex == -1) { networkList.add(networkSet); }
            else {
                //한 노드가 여러 network set에 있는 경우 가장 먼저 선택된 set으로 통합 후 삭제 
                List<Integer> removeIndexList = new ArrayList<>();

                for (int k = networkListIndex + 1; k < networkList.size(); k++) {
                    Set<Integer> set = networkList.get(k);

                    if (set.contains(i)) {
                        networkList.get(networkListIndex).addAll(set);
                        removeIndexList.add(k);
                    }
                }

                if (removeIndexList.size() > 0) {
                    for (int l = networkList.size() - 1; l >= 0; l--) {
                        if (removeIndexList.contains(l)) {
                            networkList.remove(l);
                        }
                    }
                }
            }
        }

        return networkList.size();
    }
}
