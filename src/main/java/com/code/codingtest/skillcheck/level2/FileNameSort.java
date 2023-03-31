package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileNameSort {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] result = new FileNameSort().solution(files);

        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileName> list = new ArrayList<>();

        for (String file : files) {
            list.add(new FileName(file));
        }
        Collections.sort(list);

        int index = 0;
        for (FileName fileName : list) {
            answer[index++] = fileName.fileName;
        }

        return answer;
    }

    class FileName implements Comparable<FileName>{
        String fileName;
        String head;
        Long number;

        public FileName(String fileName) {
            this.fileName = fileName;
            setNumIndex();
        }

        private void setNumIndex() {
            int firstNumIndex = 101;
            boolean isNumberSet = false;

            for (int i = 0; i < fileName.length(); i++) {
                if (firstNumIndex == 101 && Character.isDigit(fileName.charAt(i))) {
                    head = fileName.substring(0, i).toLowerCase();
                    firstNumIndex = i;
                }

                if (firstNumIndex < i && !Character.isDigit(fileName.charAt(i))) {
                    number = Long.parseLong(fileName.substring(firstNumIndex, i));
                    isNumberSet = true;
                    break;
                }
            }

            if (!isNumberSet) {
                number = Long.parseLong(fileName.substring(firstNumIndex));
            }
        }

        @Override
        public int compareTo(FileName o) {
            if (this.head.compareTo(o.head) == 0) {
                    return this.number.compareTo(o.number);
            } else {
                return this.head.compareTo(o.head);
            }
        }
    }
}
