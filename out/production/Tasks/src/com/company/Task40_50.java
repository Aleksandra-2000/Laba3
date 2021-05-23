package com.company;

import java.security.MessageDigest;
import java.util.ArrayList;
/*вычисляем числовые коэффициенты по таблицe ascii и смотрим разницу следующего символа от предыдущего, ее и записываем*/
public class Task40_50 {
    public static int ctoa(char a){
        return a;
    }

    public static String encrypt(String s){
        char[] arr = s.toCharArray();
        String s1 = "";
        int k = ctoa(arr[0]);
        s1 += k + ", ";
        for (int i = 1; i < arr.length; i++){
            s1 += ctoa(arr[i]) - k + ", ";
            k = ctoa(arr[i]);
        }
        return s1.substring(0, s1.length() - 2);
    }
/*переводим в стринг первое значние чар, и дальше уже прибавляем предыдущее значение чара к следующему и добавляем
* букву в строку стринг*/
public static String decrypt(String s){
    String[] arr = s.split(", ");
    String s1 = "";
    s1 += (char) Integer.parseInt(arr[0]);
    int k = Integer.parseInt(arr[0]);
    for (int i = 1; i < arr.length; i++){
        s1 += (char) (k + Integer.parseInt(arr[i]));
        k += Integer.parseInt(arr[i]);
    }
    return s1;
}
/**/
    public static boolean canMove(String piece, String start, String end){ //task42
        boolean can = false;
        int first = Math.abs(start.charAt(0) - end.charAt(0));
        int second = Math.abs(start.charAt(1) - end.charAt(1));
        switch (piece){
            case "Rook":
                if((first == 0 && second != 0)
                        || (first != 0 && second == 0))can = true;
                break;
            case "Bishop":
                if(first == second)can = true;
                break;
            case "Queen":
                if((first == 0 && second != 0)
                        ||(first != 0 && second == 0)
                        || first == second)can = true;
                break;
            case "Pawn":
                if((first == 1 && second <= 1) || (first == 2 && second == 0))can = true;
                break;
            case "King":
                if(first <= 1 && second <= 1) can = true;
                break;
            case "Knight":
                if((first == 2 && second == 1) || (first == 1 && second == 2)) can = true;
                break;
            default:
                break;
        }
        return can;
    }
    //проходимся по второму и его длинне, далее сравнием буквы обоих слов, и если они совпадают мы прибавляем счетчик, и если счеткик равен длинне первого слова то можно.
    public static boolean canComplete(String word1, String word2){ //task 43
        int i = 0;
        for (int j = 0; j < word2.length(); j++){
            if(word1.charAt(i) == word2.charAt(j)){
                i++;
            }
            if(i == word1.length())return true;
        }
        return  false;
    }

    public static int sumDigProd(int[] a){ //task 44
        int n = 0;
        for (int value : a) n += value;
        int temp = n;
        while (n > 9) {
            temp = temp * (n % 10);
            n = n / 10;
            if (n < 10) {
                temp = temp * (n % 10);
                n = temp;
                temp = 1;
            }
        }
        return n;
    }

    public static ArrayList<String> sameVowelGroup(String[] strings){ //task 45
        ArrayList<String> list = new ArrayList<String>();
        list.add(strings[0]);
        String vowelGroup = "aeiouy";
        String firstVowels = "";
        for (char c:strings[0].toCharArray()){
            if(vowelGroup.contains(c+""))firstVowels+=c;
        }
        for (int i = 1; i < strings.length; i++){
            list.add(strings[i]);
            for (char c:firstVowels.toCharArray()){
                if(!strings[i].contains(c+"")){
                    list.remove(strings[i]);
                    break;
                }
            }
        }
        return list;
    }

    public static boolean validateCard(String num){ //task 46
        if(num.length() > 19 || num.length() < 14)return false;
        int checkDigit = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1)));
        int sum = 0;
        for (int i = 0; i < num.length() - 1; i++){
            int temp = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1 - i)));
            if(i % 2 != 0)temp = temp * 2;
            if(temp > 10){
                sum += temp % 10;
                temp = temp / 10;
                sum += temp % 10;
            }
            else sum += temp;
        }
        if(10 - (sum % 10) == checkDigit)return true;
        return false;
    }

    public static String numToEng(int num){ //task 47
        String first = "", second = "", third = "";
        switch (num % 10){
            case 1:
                first = "one";
                break;
            case 2:
                first = "two";
                break;
            case 3:
                first = "three";
                break;
            case 4:
                first = "four";
                break;
            case 5:
                first = "five";
                break;
            case 6:
                first = "six";
                break;
            case 7:
                first = "seven";
                break;
            case 8:
                first = "eight";
                break;
            case 9:
                first = "nine";
                break;
        }
        num = num / 10;
        switch (num % 10){
            case 1:
                switch (first){
                    case "":
                        first = "ten";
                        break;
                    case "one":
                        first = "eleven";
                        break;
                    case "two":
                        first = "twelve";
                        break;
                    case "three":
                        first = "thirteen";
                        break;
                    case "four":
                        first = "fourteen";
                        break;
                    case "five":
                        first = "fifteen";
                        break;
                    case "six":
                        first = "sixteen";
                        break;
                    case "seven":
                        first = "seventeen";
                        break;
                    case "eight":
                        first = "eighteen";
                        break;
                    case "nine":
                        first = "nineteen";
                        break;
                }
                break;
            case 2:
                second = "twenty";
                break;
            case 3:
                second = "thirty";
                break;
            case 4:
                second = "forty";
                break;
            case 5:
                second = "fifty";
                break;
            case 6:
                second = "sixty";
                break;
            case 7:
                second = "seventy";
                break;
            case 8:
                second = "eighty";
                break;
            case 9:
                second = "ninety";
                break;
        }
        num = num / 10;
        switch (num % 10){
            case 1:
                third = "one hundred";
                break;
            case 2:
                third  = "two hundred";
                break;
            case 3:
                third  = "three hundred";
                break;
            case 4:
                third  = "four hundred";
                break;
            case 5:
                third  = "five hundred";
                break;
            case 6:
                third  = "sex hundred";
                break;
            case 7:
                third  = "seven hundred";
                break;
            case 8:
                third  = "eight hundred";
                break;
            case 9:
                third  = "nine hundred";
                break;
        }
        return third + second + first;
    }

    public static String getSha256Hash(String string){ //task 48
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] futHash = messageDigest.digest(string.getBytes("UTF-8"));
            String hex = new String();
            for (int i = 0; i < futHash.length; i++) {
                String hex2 = Integer.toHexString(0xff & futHash[i]);
                if(hex2.length() == 1) hex += "0";
                hex += hex2;
            }
            return hex;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String correctTitle(String string){ //task 49
        String title = "";
        String[] words = string.split(" ");
        for (String word: words){
            word = word.toLowerCase();
            if(!(word.contains("and") ||word.contains("the") ||word.contains("of"))){
                title += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
            }
            else{
                title += word + " ";
            }
        }
        return title;
    }

    public static String hexLattice(int n){ //task 50
        String ans = "";
        int temp = 1;
        int l = 1;
        while (temp < n ){
            temp = temp + (l * 6);
            l++;
        }
        if (temp != n)return "Invalid";
        for (int i = l ; i <= 2 * l  - 1; i++){
            ans += Task10_20.repeat(" ", 2 * l - i);
            for (int j = 0; j < i; j++){
                ans += " o";
            }
            ans += "\n";
        }
        for (int i = 2 * l  - 2 ; i >= l ; i--){
            ans += Task10_20.repeat(" ", 2 * l - i);
            for (int j = 0; j < i; j++){
                ans += " o";
            }
            ans += "\n";
        }
        return ans;
    }

}
