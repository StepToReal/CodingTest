package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class BadUser {
    public static void main(String[] args) {
//        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] bannedId = {"*rodo", "*rodo", "******"};

        String[] userId = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedId = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(new BadUser().solution(userId, bannedId));
    }

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> badUsers = new ArrayList<>();

        for (String bann : banned_id) {
            List<String> list = new ArrayList<>();
            String pattern = bann.replace("*", ".");

            for (String user : user_id) {
                if (Pattern.matches(pattern, user)) {
                    list.add(user);
                }
            }

            if (!list.isEmpty()) badUsers.add(list);
        }

        backtracking(badUsers, new HashSet<>(), 0);

        return result.size();
    }

    Set<Set<String>> result = new HashSet<>();

    private void backtracking(List<List<String>> badUsers, Set<String> set, int i) {
        if (i == badUsers.size()) {
            result.add(new HashSet<>(set));
            return;
        }

        List<String> list = badUsers.get(i);

        for (String id : list) {
            if (!set.contains(id)) {
                set.add(id);
                backtracking(badUsers, set, i + 1);
                set.remove(id);
            }
        }
    }


}
