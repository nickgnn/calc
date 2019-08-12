import java.io.IOException;
import java.util.*;

public class StringParcer {
    public String parseString(String string) throws IOException {
        Calculator calculator = new Calculator();
        Map<String, Integer> arabicDigits = initArabicDigits();
        Map<Integer, String> romeDigits = initRomeDigits();

        int result = 0;
        String[] strings = string.split(" ");
        List<String> list = Arrays.asList(strings);

        if ((isRomeDigit(list.get(0), romeDigits) && !isRomeDigit(list.get(2), romeDigits)) ||
                (!isRomeDigit(list.get(0), romeDigits) && isRomeDigit(list.get(2), romeDigits))) {
            throw new IOException();
        }

        if (list.get(1).equals("+") ||
            list.get(1).equals("-") ||
            list.get(1).equals("*") ||
            list.get(1).equals("/")) {

            if (list.get(1).equals("+")) {
                result = calculator.add(arabicDigits.get(list.get(0)), arabicDigits.get(list.get(2)));
            }

            if (list.get(1).equals("-")) {
                result = calculator.subtract(arabicDigits.get(list.get(0)), arabicDigits.get(list.get(2)));
            }

            if (list.get(1).equals("*")) {
                result = calculator.multiply(arabicDigits.get(list.get(0)), arabicDigits.get(list.get(2)));
            }

            if (list.get(1).equals("/")) {
                result = calculator.divide(arabicDigits.get(list.get(0)), arabicDigits.get(list.get(2)));
            }

        } else {
            throw new IOException();
        }

        if (isRomeDigit(list.get(0), romeDigits) && isRomeDigit(list.get(2), romeDigits)) {
            return romeDigits.get(result);
        }

        return String.valueOf(result);
    }

    private Map<String, Integer> initArabicDigits() {
        Map<String, Integer> map = new HashMap<>();

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        return map;
    }

    private Map<Integer, String> initRomeDigits() {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i < 200; i++){
            map.put(i, convertToRomeDigits(i));
        }

        return map;
    }

    private boolean isRomeDigit(String digit, Map<Integer, String> map) {
        if (map.containsValue(digit)) {
            return true;
        }

        return false;
    }

    private String convertToRomeDigits(int num) {
        LinkedHashMap<String, Integer> romeDigits = new LinkedHashMap<>();

        romeDigits.put("M", 1000);
        romeDigits.put("CM", 900);
        romeDigits.put("D", 500);
        romeDigits.put("CD", 400);
        romeDigits.put("C", 100);
        romeDigits.put("XC", 90);
        romeDigits.put("L", 50);
        romeDigits.put("XL", 40);
        romeDigits.put("X", 10);
        romeDigits.put("IX", 9);
        romeDigits.put("V", 5);
        romeDigits.put("IV", 4);
        romeDigits.put("I", 1);

        String result = "";

        for(Map.Entry<String, Integer> entry : romeDigits.entrySet()){
            int matches = num/entry.getValue();
            result += repeat(entry.getKey(), matches);
            num = num % entry.getValue();
        }

        return result;
    }

    private String repeat(String s, int n) {
        if(s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(s);
        }

        return sb.toString();
    }
}
