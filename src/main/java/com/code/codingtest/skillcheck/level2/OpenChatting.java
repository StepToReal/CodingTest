package com.code.codingtest.skillcheck.level2;

import java.util.*;
import java.util.function.IntFunction;

public class OpenChatting {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = new OpenChatting().solution(record);
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] record) {
        Map<String, User> userMap = new HashMap<>();
        List<ChatHistory> chatList = new ArrayList<>();

        for (String r : record) {
            String[] recordElement = r.split(" ");
            Execution execution = Execution.valueOf(recordElement[0]);
            String id = recordElement[1];
            String name = "";

            if (recordElement.length == 3) {
                name = recordElement[2];
            }

            if (userMap.containsKey(id) && execution != Execution.Leave) {
                userMap.get(id).setName(name);
            } else if (!userMap.containsKey(id)) {
                userMap.put(id, new User(id, name));
            }

            if (execution != Execution.Change) {
                chatList.add(new ChatHistory(execution, userMap.get(id)));
            }
        }

        return chatList
                .stream()
                .map(ChatHistory::toString)
                .toArray(String[]::new);
    }
}

enum Execution {
    Enter("님이 들어왔습니다."), Leave("님이 나갔습니다."), Change("");

    final String desc;

    Execution(String desc) {
        this.desc = desc;
    }
}

class User {
    String id;
    String name;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String name) {
        this(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ChatHistory {
    Execution execution;
    User user;

    public ChatHistory(Execution execution, User user) {
        this.execution = execution;
        this.user = user;
    }

    @Override
    public String toString() {
        return user.name + execution.desc;
    }
}