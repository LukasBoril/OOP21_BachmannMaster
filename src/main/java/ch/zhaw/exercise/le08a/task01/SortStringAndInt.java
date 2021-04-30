package ch.zhaw.exercise.le08a.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class StringComparator implements Comparator<String> {

    @Override
    public int compare(String str, String str2) {
        return str.compareTo(str2);
    }
}

class IntComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer integer, Integer t1) {
        return integer.compareTo(t1);
    }
}

public class SortStringAndInt {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Emma");
        stringList.add("210");
        stringList.add("Anna");
        stringList.add("2");
        stringList.add("Hans");
        stringList.add("21");
        stringList.add("51");
        stringList.add("Zora");
        stringList.add("Karl");

        System.out.println(stringList);

        Collections.sort(stringList);
        stringList.sort((str1, str2) -> str1.compareTo(str2));
        Collections.sort(stringList, new StringComparator());
        stringList.sort(String::compareTo);
        stringList.sort(new StringComparator());
        stringList.sort(Comparator.naturalOrder());
        stringList.sort(Comparator.reverseOrder());

        List<Integer> intList = new ArrayList<>();
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
        intList.sort((int1, int2) -> int1.compareTo(int2));
        Collections.sort(intList, new IntComparator());
        intList.sort(Integer::compareTo);
        intList.sort(new IntComparator());
        intList.sort(Comparator.naturalOrder());
        intList.sort(Comparator.reverseOrder());
    }

}
