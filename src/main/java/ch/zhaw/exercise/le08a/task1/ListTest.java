package ch.zhaw.exercise.le08a.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("Emma");
        strList.add("210");
        strList.add("Anna");
        strList.add("2");
        strList.add("Hans");
        strList.add("21");
        strList.add("51");
        strList.add("Zora");
        strList.add("Karl");

        Collections.sort(strList);
        strList.sort(Comparator.naturalOrder());
        strList.sort(Comparator.reverseOrder());
        System.out.println(strList);
        Collections.sort(strList, new StringComparator());
        strList.sort(new StringComparator());
        strList.sort((str1, str2) -> str1.compareTo(str2));
        strList.sort(String::compareTo);
        System.out.println(strList);

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(2);
        intList.add(7);
        intList.add(-1);
        intList.add(5);
        intList.add(51);
        intList.add(4);
        intList.add(6);
        intList.add(3);
        intList.add(0);
        intList.add(1);
        intList.add(-2);

        System.out.println(intList);
        Collections.sort(intList);
        System.out.println(intList);
        // intList.sort(Integer::compareTo);
        // intList.sort(new IntegerComparator());
        intList.sort(Comparator.naturalOrder());
        System.out.println(intList);
        // intList.sort(new ReverseIntegerComparator());
        // intList.sort((int1, int2) -> int2.compareTo(int1));
        // intList.sort(Comparator.reverseOrder());
        intList.sort(Comparator.reverseOrder());
        System.out.println(intList);
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer int1, Integer int2) {
        return int1.compareTo(int2);
    }
}

class ReverseIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer int1, Integer int2) {
        return int2.compareTo(int1);
    }
}

