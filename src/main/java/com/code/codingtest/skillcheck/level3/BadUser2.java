package com.code.codingtest.skillcheck.level3;

import java.util.*;
import java.util.regex.Pattern;

public class BadUser2 {
    public static void main(String[] args) {
//        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] bannedId = {"*rodo", "*rodo", "******"};

        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(new BadUser2().solution(userId, bannedId));
    }

    public int solution(String[] user_id, String[] banned_id) {
        Map<String, Set<String>> badUsersMap = new HashMap();

        for (String bann : banned_id) {
            if (!badUsersMap.containsKey(bann)) {
                badUsersMap.put(bann, new HashSet<>());

                for (String user : user_id) {
                    if (bann.length() == user.length()) {
                        boolean isEqual = true;

                        for (int i = 0; i < bann.length(); i++) {
                            if (bann.charAt(i) != '*' && bann.charAt(i) != user.charAt(i)) {
                                isEqual = false;
                                break;
                            }
                        }

                        if (isEqual) {
                            badUsersMap.get(bann).add(user);
                        }
                    }
                }
            }
        }

        backtracking(banned_id, badUsersMap, 0, new HashSet<String>());

        return resultSet.size();
    }

    Set<Set<String>> resultSet = new HashSet<>();

    private void backtracking(String[] banned_id, Map<String, Set<String>> badUsersMap, int i, HashSet<String> set) {
        if (i == banned_id.length) {
            resultSet.add(new HashSet<>(set));
            return;
        }

        Set<String> badUsersSet = badUsersMap.get(banned_id[i]);

        for (String badUser : badUsersSet) {
            if (i == 0) {
                set = new HashSet<>();
            }

            if (!set.contains(badUser)) {
                set.add(badUser);
                backtracking(banned_id, badUsersMap, i + 1, set);
                set.remove(badUser);
            }
        }
    }
}
