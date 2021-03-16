package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.Set;
import java.util.TreeSet;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }
        Set<String> result = new TreeSet<>();
        for (char item : s.toCharArray()) {
            if (Character.isDigit(item)) {
                result.add(Character.toString(item));
            }
        }
        return result.size();
    }
}
