package com.code.functest;

import java.util.*;

public class TestHashSet {
    public static void main(String[] args) {
        testSetInSet();
        testSetInList();
        testSetInLinkedSet();
        testSetInTreeSet();

        //Set 객체는 linkedHash, Hash, Tree 상관없이 내부에 값이 같으면 동일한 객체로 판단한다.
        //ContainsAll 해서 비교 객체에 모든 값이 나에게 있으면 equals true 가 됨.
        //따라서 Set<Set<String>> a 인 경우 내부 Set의 주소값이 서로 달라도 데이터 값이 동일하면 중복이 제거되어 들어감.
    }

    private static void testSetInTreeSet() {
        Set<Set<String>> setset = new HashSet<>();

        Set<String> value1 = new TreeSet<>();
        Set<String> value2 = new TreeSet<>();
        Set<String> value3 = new TreeSet<>();
        Set<String> value4 = new TreeSet<>();

        value1.add("a");
        value1.add("b");
        value1.add("c");

        value2.add("b");
        value2.add("a");
        value2.add("c");

        value3.add("a1");
        value3.add("b1");
        value3.add("c1");

        value4.add("a1");
        value4.add("b1");
        value4.add("c2");

        setset.add(value1);
        setset.add(value2);
        setset.add(value3);
        setset.add(value4);

        System.out.println(setset.size());
        System.out.println(value1 == value2);
        System.out.println(value1.equals(value2));
        System.out.println(value1.hashCode() + ", " + value2.hashCode());

        for (Set<String> set : setset) {
            for (String s : set) {
                System.out.print(s + ", ");
            }

            System.out.println();
        }
    }

    private static void testSetInLinkedSet() {
        Set<Set<String>> setset = new HashSet<>();

        Set<String> value1 = new LinkedHashSet<>();
        Set<String> value2 = new LinkedHashSet<>();
        Set<String> value3 = new LinkedHashSet<>();
        Set<String> value4 = new LinkedHashSet<>();

        value1.add("b");
        value1.add("a");
        value1.add("c");

        value2.add("a");
        value2.add("b");
        value2.add("c");

        value3.add("a1");
        value3.add("b1");
        value3.add("c1");

        value4.add("a1");
        value4.add("b1");
        value4.add("c2");

        setset.add(value1);
        setset.add(value2);
        setset.add(value3);
        setset.add(value4);

        System.out.println(setset.size());
        System.out.println(value1 == value2);
        System.out.println(value1.equals(value2));
        System.out.println(value1.hashCode() + ", " + value2.hashCode());

        for (Set<String> set : setset) {
            for (String s : set) {
                System.out.print(s + ", ");
            }

            System.out.println();
        }
    }

    private static void testSetInList() {
        Set<List<String>> setList = new HashSet<>();

        List<String> value1 = new ArrayList<>();
        List<String> value2 = new ArrayList<>();
        List<String> value3 = new ArrayList<>();
        List<String> value4 = new ArrayList<>();

        value1.add("a");
        value1.add("b");
        value1.add("c");

        value2.add("b");
        value2.add("a");
        value2.add("c");

        value3.add("a1");
        value3.add("b1");
        value3.add("c1");

        value4.add("a1");
        value4.add("b1");
        value4.add("c2");

        setList.add(value1);
        setList.add(value2);
        setList.add(value3);
        setList.add(value4);

        System.out.println(setList.size());
        System.out.println(value1 == value2);
        System.out.println(value1.equals(value2));
        System.out.println(value1.hashCode() + ", " + value2.hashCode());

        for (List<String> set : setList) {
            for (String s : set) {
                System.out.print(s + ", ");
            }

            System.out.println();
        }

    }

    private static void testSetInSet() {
        Set<Set<String>> setset = new HashSet<>();

        Set<String> value1 = new HashSet<>();
        Set<String> value2 = new HashSet<>();
        Set<String> value3 = new HashSet<>();
        Set<String> value4 = new HashSet<>();

        value1.add("a");
        value1.add("b");
        value1.add("c");

        value2.add("b");
        value2.add("a");
        value2.add("c");

        value3.add("a1");
        value3.add("b1");
        value3.add("c1");

        value4.add("a1");
        value4.add("b1");
        value4.add("c2");

        setset.add(value1);
        setset.add(value2);
        setset.add(value3);
        setset.add(value4);

        System.out.println(setset.size());
        System.out.println(value1 == value2);
        System.out.println(value1.equals(value2));
        System.out.println(value1.hashCode() + ", " + value2.hashCode());

        for (Set<String> set : setset) {
            for (String s : set) {
                System.out.print(s + ", ");
            }

            System.out.println();
        }
    }
}
