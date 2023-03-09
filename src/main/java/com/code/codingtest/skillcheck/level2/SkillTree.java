package com.code.codingtest.skillcheck.level2;

import java.awt.*;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.function.IntPredicate;

public class SkillTree {
    public static void main(String[] args) {

    }

    public int solution3(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            if (skill.indexOf(skillTree.replaceAll("[^" + skill + "]", "")) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        int[] learnOrder = new int[skill.length()];

        for (String skill_tree : skill_trees) {
            for (int i = 0; i < skill.length(); i++) {
                learnOrder[i] = skill_tree.indexOf(skill.charAt(i));
            }

            boolean isPossible = true;
            for (int i = 1; i < learnOrder.length; i++) {
                if (learnOrder[i] != -1 && (learnOrder[i - 1] > learnOrder[i] || learnOrder[i - 1] == -1)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) answer++;
        }


        return answer;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] arr = new int[skill.length()];

        for (String skillTree : skill_trees) {
            boolean isPossible = true;
            Arrays.fill(arr, 30);

            for (int i = 0; i < skill.length(); i++) {
                int index = skillTree.indexOf(skill.charAt(i));

                if (index != -1) {
                    arr[i] = index;
                }
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) answer++;
        }

        return answer;
    }
}
