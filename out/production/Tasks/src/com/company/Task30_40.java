package com.company;
import  java.util.*;
import java.util.ArrayList;

/*Принимаем на вход текст и количество символов в строке, сплитим по пробелам, вставляем слово и пробел, и проверяем
* хватает ли места на еще слово+пробел, если нет то смещаемся на след строку.*/
public class Task30_40 { //task31
    public static String bessi(String s, int n) {
        String[] arr = s.split(" ");
        StringBuilder s1 = new StringBuilder();
        int tmp = 0;
        for (String x : arr) {
            if (tmp + x.length() <= n) {
                s1.append(x).append(" ");
                tmp += x.length();
            } else {
                s1.append(System.lineSeparator());
                s1.append(x).append(" ");
                tmp = x.length();
            }
        }
        return s1.toString();
    }

    /*сравниваем количество открытых и закрытых скобок, в момент его совпадения мы ставим пробел и дальше по пробелу делим
     строку*/
    public static String[] clasterSkobok(String string) { //task32
        String ans = "";
        int otkr = 0;
        int zakr = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') otkr++;
            if (string.charAt(i) == ')') zakr++;
            ans += string.charAt(i);
            if (otkr == zakr) ans += " ";
        }
        return ans.split(" ");
    }

    /*проходимся по строке удаляя его и увеличиваем следующий*/
    public static String toCamelCase(String string) { //task 33
        while (string.contains("_")) {
            char temp = string.charAt(string.indexOf("_") + 1);
            string = string.replaceFirst("_" + temp, String.valueOf(Character.toUpperCase(temp)));
        }
        return string;
    }

    /*проходимся по строке и если есть буквы в верхнем регистре то уменьшаем их и двигаем подставляя нижнее подчеркивание*/
    public static String toSnakeCase(String string) { //task 33
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                string = string.replace((String.valueOf(string.charAt(i))),
                        "_" + Character.toLowerCase(string.charAt(i)));
            }
        }
        return string;
    }

    /*если время окончания рабочего дня больше 17 то считаем сколько переработали и считаем по формулам*/
    public static String overTime(double[] a) { //task 34
        double money = 0;
        double overtime = 0;
        if (a[1] > 17) overtime = a[1] - 17;
        money = (a[1] - a[0] - overtime) * a[2] + (overtime * a[2] * a[3]);
        return "$" + String.format("%.2f", money);
    }

    /*принимаем вес и единицу измерения веса, а так же рост и единицу измерения роста, и считаем по предоставленным формулам*/
    public static String BMI(String mas, String length) { //task 35
        double m, l;
        String[] temp = mas.split(" ");
        m = Double.parseDouble(temp[0]);
        if (temp[1].equals("pounds")) m = m / 2.205;
        temp = length.split(" ");
        l = Double.parseDouble(temp[0]);
        if (temp[1].equals("inches")) l = l / 39.37;
        double bmi = m / (l * l);
        if (bmi < 18.5) return String.format("%.1f", bmi) + " Underweight";
        else if (bmi >= 18.5 && bmi < 25) return String.format("%.1f", bmi) + " Normal weight";
        else return String.format("%.1f", bmi) + " Overweight";
    }

    /*путем хитрых мат. вычислений число умножаем позначно до тех пор пока это возможно и есть что умножать*/
    public static int bugger(int n) { //task 36
        int temp = 1, times = 0;
        while (n > 9) {
            temp = temp * (n % 10);
            n = n / 10;
            if (n < 10) {
                temp = temp * (n % 10);
                n = temp;
                temp = 1;
                times++;
            }
        }
        return times;
    }

    /*проверяем предыдущую букву и если она не совпадает с текущей i или = концу строки то прибавляем счетчик, и пока
     * не будет другая буква прибавляем счетчик, и потом "умножаем" слово на обороты счетчика*/
    public static String toStarShorthand(String string) { //task 37
        String ans = "";
        char temp = string.charAt(0);
        int n = 1;
        for (int i = 1; i < string.length(); i++) {
            if (temp != string.charAt(i) || i == string.length() - 1) {
                ans += temp;
                if (n > 1) ans += "*" + n;
                n = 1;
                temp = string.charAt(i);
            } else {
                n++;
            }
        }
        return ans;
    }

    /*проверяем предпоследню букву в первом и втором предложении(с учетом точки) и сравниваем их*/
    public static boolean doesRhyme(String string1, String string2) { //task 38
        char t1 = string1.charAt(string1.length() - 1), t2 = string2.charAt(string2.length() - 1);
        if (!Character.isAlphabetic(string1.charAt(string1.length() - 1))) t1 = string1.charAt(string1.length() - 2);
        if (!Character.isAlphabetic(string2.charAt(string2.length() - 1))) t2 = string2.charAt(string2.length() - 2);
        return t1 == t2;
    }

    /*вводим числа, и по каждому числу пробегаемся, если какое то число встречается чаще constant то значение true
     * так же и со вторым, если оба boolean в конце == true то возвращем True*/
    public static boolean trouble(long a, long b) { //task 39
        for (int i = 0; i < 10; i++) {
            boolean checkFirst = helper(a, i, 3);
            boolean checkSecond = helper(b, i, 2);
            if ((checkFirst == checkSecond) && checkFirst)
                return true;
        }
        return false;
    }

    private static boolean helper(long temp, int iter, int constant) {
        boolean[] digits = new boolean[10];
        int t = 0;
        while (temp > 0) {
            if (temp % 10 == iter) t++;
            else t = 0;
            if (t >= constant) digits[iter] = true;
            temp /= 10;
        }
        return digits[iter];
    }
/*добавляем каждый уникальный символ в хешсет кроме разделителя, выводим количество уникальных символов хешсета*/
    public static int countUniqueBooks(String text, char bookEnd) { //task 40
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != bookEnd) {
                h.add(text.charAt(i));
            }
        }
        return h.size();
    }
}
