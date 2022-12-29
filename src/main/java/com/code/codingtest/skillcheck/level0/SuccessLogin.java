package com.code.codingtest.skillcheck.level0;

import java.util.HashMap;
import java.util.Map;

public class SuccessLogin {
    public static void main(String[] args) {

    }

    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> dbMap = new HashMap<>();

        for (String[] info : db) {
            dbMap.put(info[0], info[1]);
        }

        if (dbMap.containsKey(id_pw[0])) {
            if (dbMap.get(id_pw[0]).equals(id_pw[1])) {
                return "login";
            } else {
                return "wrong pw";
            }
        } else {
            return "fail";
        }
    }
}
