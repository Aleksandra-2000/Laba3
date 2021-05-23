package com.company;

public class Task10_20 {
    public static String repeat(String string, int n){ //task11
        String ans = "";
        for(int i = 0; i < string.length(); i++){
            for(int j = 0; j < n; j++){ //проходимся по слову и после по каждой букве записывая n раз
                ans += string.charAt(i); //в ans и выводим ans
            }
        }
        return ans;
    }
    public static int differenceMaxMin(int[] a){ //task12
        int max = a[0]; //вводим массив чисел
        int min = a[0];
        for(int i = 0; i < a.length; i++){
            if(max < a[i])max = a[i]; //если число в i больше того что что уже есть в max записываем его
            if(min > a[i])min = a[i]; //если число в i меьнше min то вводим в min
        }
        return max - min;
    }
    public static boolean isAvgWhole(int[] a){ //task13
        double avg = 0; //
        for(int i =0; i < a.length; i++){
            avg += a[i]; // проходимся по массиву и сумму всех чисел записываем в avg
        }
        avg = avg/a.length; // делим на количество элементов
        return (int)avg - avg == 0;
    }
    public static int[] cumulativeSum(int[] a){ //task14
        for(int i = 1; i < a.length; i++){ //начинаем со второго числа
             a[i] += a[i-1] ; //и проходимся по массиву складывая в массиве все последующие числа
        }
        return a;
    }
    public static int getDecimalPlaces(String string){ //task15
        String[] number = string.split(","); //  делим число по точке и выводим его длинну.
        return number[1].length();
    }
    public static int Fibonacci(int n){ //task16
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1; //сумма двух предыдущих чисел дает следующее и тд, меняем их местами и прибавляем
        for(int i = 2; i <= n; i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[n];
    }
    public static boolean isValid(String index){ //task17
        try {
            return (Integer.parseInt(index) > 9999 && Integer.parseInt(index) < 100000);
        } //парсим числа от 9999 до 1000000(ибо уже 6 чисел) если символ не число "ловим ошибку"
        catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isStrangePair(String string1, String string2){ //task18
        return (string1.charAt(0) == string2.charAt(string2.length() - 1)) //последний символ ставим на 0 индекс
                && (string1.charAt(string1.length() - 1) == string2.charAt(0)); //первый на последнее
    }
    public static boolean isPrefix(String word, String prefix){ //task19
        return word.startsWith(prefix.substring(0,prefix.length()-2)); //используя метод startswith проверяем префикс ли
    }
    public static boolean isSuffix(String word, String suffix){
        return word.endsWith(suffix.substring(1)); //используя метод edswith проверяем суффикс ли
    }
    public static void boxSeq(int step){
        if(step%2 == 0){
            System.out.print("BoxSeq("+step+") -> " + step);
            //судя по логике в задании, если шаг четный то выводим то же значние
        }
        else{
            System.out.print("BoxSeq("+step+") -> " + (step+2)); //значение шага +2
        } //task20
    }


}
