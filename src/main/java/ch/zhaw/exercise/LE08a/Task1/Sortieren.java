package ch.zhaw.exercise.LE08a.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sortieren {

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
        Collections.sort(intList);
        System.out.println(intList);

//        Collections.sort(strList);
//        strList.sort((str1, str2) -> str1.compareTo(str2));
//        Collections.sort(strList, new StringComparator());
//        strList.sort(String::compareTo);
//        strList.sort(new StringComparator())
//        strList.sort(Comparator.naturalOrder());
//        strList.sort(Comparator.reverseOrder());
    }
}

    class StringComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
}

