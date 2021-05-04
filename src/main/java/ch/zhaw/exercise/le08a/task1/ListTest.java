package ch.zhaw.exercise.le08a.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //Stringlist
        List<String> strList = new ArrayList<>();
        strList.add("Emma");
        strList.add("210");
        strList.add("Anna");
        strList.add("2");
        strList.add("Hans");
        strList.add("21");
        strList.add("51");
        strList.add("Zora");
        strList.add("Karl");

        //Collections.sort(strList);
        //strList.sort((str1, str2) -> str1.compareTo(str2));
        Collections.sort(strList, new StringComparator());
        //strList.sort(String::compareTo);
        //strList.sort(new StringComparator());
        strList.sort(Comparator.naturalOrder());
        //strList.sort(Comparator.reverseOrder());

        System.out.println(strList);


        //Integerlist
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
    }

    public static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

}
