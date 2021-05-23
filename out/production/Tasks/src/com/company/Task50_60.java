package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Task50_60 {

    public static int bell(int n){
        int ans = 0;
        for (int i = 0; i <= n; i++){
            ans += stirling(n,i);
        }
        return ans;
    }
    private static int stirling(int n, int k){
        if(n == 0 && k == 0) return 1;
        if(k == 0) return 0;
        if(k > n) return 0;
        return stirling(n - 1, k - 1) + k * stirling(n - 1, k);
    }

    public static String translateWord(String word){
        String vowelString = "aeiouyAEIOUY";
        String translatedWord = word.substring(1) + word.charAt(0);
        if(vowelString.contains(translatedWord.charAt(word.length() - 1) + ""))translatedWord += "yay";
        else translatedWord += "ay";
        return translatedWord;
    }
    public static String translateSentence(String sentence){
        String translatedSentence = "";
        String[] words = sentence.split(" ");
        for(String word: words){
            if(word.charAt(word.length() - 1) == '.'
                    ||word.charAt(word.length() - 1) == '!'
                    ||word.charAt(word.length() - 1) == '?'
                    ||word.charAt(word.length() - 1) == ','){
                translatedSentence += translateWord(word.substring(0,word.length() - 2)) + word.charAt(word.length() - 1) + " ";
            }
            else translatedSentence += translateWord(word) + " ";
        }
        return translatedSentence.trim();
    }

    public static boolean validColor(String string) {
        String type = string.substring(0, string.indexOf("("));
        String[] numbers = string.substring(string.indexOf("(") + 1, string.indexOf(")")).split(",");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("")) return false;
        }
        boolean first = Integer.parseInt(numbers[0]) < 256 && Integer.parseInt(numbers[0]) >= 0;
        boolean second = Integer.parseInt(numbers[1]) < 256 && Integer.parseInt(numbers[1]) >= 0;
        boolean third = Integer.parseInt(numbers[2]) < 256 && Integer.parseInt(numbers[2]) >= 0;
        switch (type) {
            case "rgb":
                if (numbers.length != 3) return false;
                return first && second && third;
            case "rgba":
                if (numbers.length != 4) return false;
                boolean forth = Double.parseDouble(numbers[3]) >= 0 && Double.parseDouble(numbers[3]) < 256;
                return first && second && third && forth;
        }
        return false;
    }

    public static String stripUrlParams(String url){
        if (!url.contains("?"))return url;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String paramsAfter = "";
        String host = url.substring(0, url.indexOf("?"));
        String[] parms = url.substring(url.indexOf("?")+1).split("&");
        for (String parm:parms){
            map.put(parm.substring(0,parm.indexOf("=")), Integer.parseInt(parm.substring(parm.indexOf("=")+1)));
        }
        for(String parm:map.keySet()){
            paramsAfter += "&" + parm + "=" + map.get(parm);
        }
        if (paramsAfter.equals(""))return host;
        return host + "?" + paramsAfter.substring(1) ;
    }
    public static String stripUrlParams(String url, String[] params){
        if (!url.contains("?"))return url;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String paramsAfter = "";
        String host = url.substring(0, url.indexOf("?"));
        String[] parms = url.substring(url.indexOf("?")).split("&");
        for (String parm:parms){
            map.put(parm.substring(0,parm.indexOf("=")), Integer.parseInt(parm.substring(parm.indexOf("="))));
        }
        for (String parm:params){
            if(map.containsKey(parm))map.remove(parm);
        }
        for(String parm:map.keySet()){
            paramsAfter += "&" + parm + "=" + map.get(parm);
        }
        if (paramsAfter.equals(""))return host;
        return host + "?" + paramsAfter.substring(1) ;
    }

    public static String[] getHashTags(String string){
        String[] ans;
        String[] words = string.split(" ");
        Comparator<String> comparator = new MyComparator();
        Queue<String> list = new PriorityQueue<String>(comparator);
        for (String word:words){
            list.add(word);
        }
        if(list.size() > 2){
            ans = new String[3];
            for(int i = 0; i < 3; i++)ans[i] = "#" + list.poll().toLowerCase();
        }
        else {
            ans = new String[list.size()];
            for(int i = 0; i < list.size(); i++)ans[i] = "#" + list.poll().toLowerCase();
        }
        return ans;
    }
    private static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length()) {
                return -1;
            }
            if (o1.length() > o2.length()) {
                return 1;
            }
            return 0;
        }
    }

    public static int ulam(int n) {
        int[] posl = new int[n];
        int num = 3;
        posl[0] = 1; posl[1] = 2;
        for (int i = 2; i < n;i++) {
            int counter = 0;
            for (int j = 0; j < i;j++)
                for (int k = j + 1; k < i;k++)
                    if (posl[j] + posl[k] == num) counter += 1;
            if (counter == 1) {
                posl[i] = num;
            } else {
                i--;
            }
            num += 1;
        }
        return posl[n - 1];
    }

    public static String longestNonrepeatingSubstring(String string){
        String ans = "", temp = "";
        int longest = 0;
        for(int j = 0; j < string.length(); j++) {
            for (int i = j; i < string.length(); i++) {
                if (temp.contains(string.charAt(i) + "")) {
                    if (temp.length() > longest) {
                        longest = temp.length();
                        ans = temp;
                    }
                }
                temp += string.charAt(i);
                if (i == string.length() - 1 && temp.length() > longest) {
                    longest = temp.length();
                    ans = temp;
                }
            }
        }
        return ans;

    }

    public static String convertToRoman(int n) {
        List<RomanNumeral> romNum = RomanNumeral.getReverseSortedValues();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((n > 0) && (i < romNum.size())) {
            RomanNumeral symb = romNum.get(i);
            if (symb.getValue() <= n) {
                stringBuilder.append(symb.name());
                n -= symb.getValue();
            } else i++;
        }
        return stringBuilder.toString();
    }

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);
        private int value;
        RomanNumeral(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values()).sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed()).collect(Collectors.toList());
        }
    }

    public static boolean formula(String string){
        String[] expressions = string.split("=");
        double[] n = new double[expressions.length];
        for(int i = 0; i < n.length; i++){
            n[i] = readExp(expressions[i]);
            for(int j = i; j > 0; j--){
                if(n[i] != n[j])return false;
            }
        }
        return true;
    }
    private static double readExp(String exp) {
        ArrayList<Double> numbers = new ArrayList<Double>();
        ArrayList<Character> operators = new ArrayList<Character>();
        int begin = 0;
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '*' || exp.charAt(i) == '/' ||exp.charAt(i) == '+' ||exp.charAt(i) == '-'){
                numbers.add(Double.parseDouble(exp.substring(begin, i)));
                operators.add(exp.charAt(i));
                begin = i;
            }
        }
        numbers.add(Double.parseDouble(exp.substring(begin+1)));
        for (int i = 0; i < operators.size(); i++){
            switch (operators.get(i)){
                case '*':
                    numbers.add(i + 1, numbers.get(i) * numbers.get(i + 1));
                    break;
                case '/':
                    numbers.add(i + 1, numbers.get(i) / numbers.get(i + 1));
                    break;
                case '+':
                    numbers.add(i + 1, numbers.get(i) + numbers.get(i + 1));
                    break;
                case '-':
                    numbers.add(i + 1, numbers.get(i) - numbers.get(i + 1));
                    break;
            }
        }
        return numbers.get(numbers.size() - 1);
    }

    public static boolean palindromedescendant(String num){
        if(num.length() == 2 || isPalindrome(num))return isPalindrome(num);
        String num2 = "";
        for(int i = 0; i < num.length(); i += 2){
            num2 += String.valueOf(Integer.parseInt(num.charAt(i)+"") + Integer.parseInt(num.charAt(i + 1)+""));
        }
        return palindromedescendant(num2);
    }
    public static String reverseString(String s){
        String s1 = "";
        for(int i = s.length()-1;i >= 0; i--){
            s1+=s.charAt(i);
        }
        return s1;
    }
    public static boolean isPalindrome(String s1){
        String s2 = reverseString(s1);
        return s1.equals(s2);
    }



}
